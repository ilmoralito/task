package ni.edu.uccleon

class ApplicationController {

	static defaultAction = "list"
	static allowedMethods = [
		list:"GET",
		create:["GET", "POST"]
	]

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

}