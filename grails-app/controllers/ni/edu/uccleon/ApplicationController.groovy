package ni.edu.uccleon

class ApplicationController {

    def beforeInterceptor = [action:this.&check, only:["update", "delete"]]

	static defaultAction = "list"
	static allowedMethods = [
		list:"GET",
		create:["GET", "POST"],
        delete:"GET"
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
    	def apps = Application.listByState(state, session?.user).list(sort:"dateCreated", order:"desc")

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

}