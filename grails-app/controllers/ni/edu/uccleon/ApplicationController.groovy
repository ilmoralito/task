package ni.edu.uccleon

class ApplicationController {

    def beforeInterceptor = [action:this.&check, only:["update", "delete"]]

	static defaultAction = "list"
	static allowedMethods = [
		list:"GET",
		create:["GET", "POST"],
        delete:"GET",
        pendingApplications:"GET"
	]

    private check() {
        def app = Application.get(params.id)

        if (app.state != "pending") {
            flash.message = "action.not.allowed"
            redirect action:"list", params:[state:app.state]
            return false
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
            apps = Application.listByDepartment(session?.user?.department).list(sort:"dateCreated", order:"desc")
        } else {
            apps = Application.listByDepartment(session?.user?.department).listByApplicationState(state).list(sort:"dateCreated", order:"desc")
        }


        [apps:apps]
    }

    def updateState(Integer id) {
        def app = Application.get(id)

        if (!app) {
            response.sendError 404
        }

        def state = { application ->
            if (application.state == "pending") {
                "attending"
            } else if (application.state == "attending") {
                "attended"
            } else {
                "pending"
            }
        }

        app.state = state(app)

        flash.message = (!app.save()) ? "upps.something.when.wrong" : "app.state.succesfully.updated"
        redirect action:"pendingApplications"
    }

}