package ni.edu.uccleon

class TaskController {

	static defaultAction = "create"
	static allowedMethods = [
		create:["GET", "POST"]
	]

    def create() {
    	if (request.method == "POST") {

    	}
    }

}