package ni.edu.uccleon

class ApplicationController {

	static defaultAction = "list"
	static allowedMethods = [
		list:"GET"
	]

    def list(String state) {
    	def apps = Application.listByState(state, session?.user).list()

    	[apps:apps]
    }

}