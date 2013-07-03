package ni.edu.uccleon

class TaskController {

	static defaultAction = "create"
	static allowedMethods = [
		create:["GET", "POST"],
		delete:"GET"
	]

    def create() {
    	if (request.method == "POST") {
    		def task = new Task(params)

    		if (!task.save()) {
    			chain action:"create", model:[task:task], params:[id:params.application.id]
    			return
    		}

    		flash.message = "task.saved"
    		redirect action:"create", params:[id:params.application.id]
    		return
    	}
    }

    def show(Integer id) {
    	def task = Task.get(id)

    	if (!task) {
    		response.sendError 404
    	}

    	[task:task]
    }

    def update(Integer id) {
    	def task = Task.get(id)

    	if (!task) {
    		response.sendError 404
    	}

    	task.properties["problem", "solution"] = params

    	if (!task.save()) {
    		flash.message = "upps.something.when.wrong.please.try.again"
    		chain action:"show", model:[task:task], params:[applicationId:params.application.id, id:params.id]
    		return
    	}

    	flash.message = "task.updated"
    	redirect controller:"application", action:"info", params:[id:params.application.id]
    }

    def delete(Integer id) {
    	def task = Task.get(id)

    	if (!task) {
    		response.sendError 404
    	}

    	task.delete()

    	flash.message = "task.deleted"
    	redirect controller:"application", action:"info", params:[id:params.applicationId]
    }

    def updateState(Integer id) {
    	def task = Task.get(id)

    	if (!task) {
    		response.sendError 404
    	}

    	task.state = (task.state) ? false : true
    	redirect controller:"application", action:"info", params:[id:params.applicationId]
    }

}