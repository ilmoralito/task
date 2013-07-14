package ni.edu.uccleon

class ApplicationController {

    def beforeInterceptor = [action:this.&check, only:["update", "delete", "updateState"]]

	static defaultAction = "list"
	static allowedMethods = [
		list:"GET",
		create:["GET", "POST"],
        delete:"GET",
        pendingApplications:"GET"
	]

    private check() {
        def app = Application.get(params.id)

        if (actionName == "updateState") {
            if (app.owner && app.user.email != session?.user?.email) {
                if (app.owner.email != session?.user?.email) {
                    flash.message = "access.denied.current.app.is.already.attended"
                    redirect action:"pendingApplications"
                    return false
                }
            }
        } else {
            if (app.state != "pending") {
                flash.message = "action.not.allowed"
                redirect action:"list", params:[state:app.state]
                return false
            }
        }
    }

    def list(String state) {
    	def apps = Application.listByState(session?.user, state).list(sort:"dateCreated", order:"desc")

    	[apps:apps]
    }

    def create(String department, String description) {
    	params.user = session?.user
    	def app = new Application(params)

    	if (request.method == "POST") {
    		if (!app.save()) {
    			return [app:app]
    		}

    		flash.message = "app.created"
    	} else {
    		return [app:app]
    	}
    }

    def show(Integer id) {
        def app = Application.findByIdAndUser(id, session?.user)

        if (!app) {
            response.sendError 404
        }

        [app:app]
    }

    def update(Integer id) {
        def app = Application.findByIdAndUser(id, session?.user)

        if (!app) {
            response.sendError 404
        }

        app.properties = params

        if (!app.save()) {
            redirect action:"show", params:[id:id, app:app]
            return
        }

        flash.message = "app.updated"
        redirect action:"show", id:id
    }

    def delete(Integer id) {
        def app = Application.findByIdAndUser(id, session?.user)

        if (!app) {
            response.sendError 404
        }

        app.delete()

        redirect action:"list", params:[state:"pending"]
    }

    def pendingApplications(String state) {
        def apps

        if (!state) {
            apps = Application.listByDepartment(session?.user?.department) {
                or {
                    isNull "owner"
                    eq "owner", session?.user
                }
            }
        } else {
            apps = Application.listByDepartment(session?.user?.department).listByApplicationState(state).list(sort:"dateCreated", order:"desc")
        }


        [apps:apps]
    }

    def updateState(Integer id, Boolean flag) {
        def app = Application.get(id)

        if (!app) {
            response.sendError 404
        }

        def state = { application ->
            if (application.user.email == session?.user?.email) {
                if (application.state == "attended") {
                    "done"
                } else if (application.state == "done") {
                    "attending"
                }
            } else if (application.user != session?.user && application.state != "done") {
                if (application.state == "pending") {
                    "attending"
                } else if (application.state == "attending") {
                    "attended"
                } else {
                    "pending"
                }
            }
        }

        def status = state(app)

        app.state = status

        if (status == "attending" && app.user.email != session?.user?.email) {
            app.owner = session?.user
        } else if (status == "pending" && app.user.email != session?.user?.email) {
            app.owner = null
        }

        flash.message = (!app.save()) ? "upps.something.when.wrong" : "app.state.succesfully.updated"
        redirect action:"info", params:[id:id]
    }

    def info(Integer id) {
        def app = Application.get(id)

        if (!app) {
            response.sendError 404
        }

        [app:app]
    }

    def addUsers(Integer id) {
        def users = params.findAll {key, value ->
            key == "attendedBy"
        }

        if (users) {
            def app = Application.get(id)

            if (!app) {
                response.sendError 404
            }

            if (users.attendedBy instanceof String[]) {
                app.attendedBy = users.attendedBy
            } else {
                List myUser = []
                myUser << users.attendedBy

                app.attendedBy = myUser
            }

            app.save()
        }

        redirect action:"info", id:id
    }

}