package ni.edu.uccleon

class UserController {

	static defaultAction = "login"
	static allowedMethods = [
		login:["GET", "POST"],
		logout:"GET",
		profile:["GET", "POST"]
	]

    def login(String email, String password) {
    	if (request.method == "POST") {
    		def user = User.login(email, password).get()

    		if (!user) {
    			flash.message = "user.not.found"
    			redirect action:"login"
    			return
    		}

    		session.user = user
    		redirect controller:"application"
    		return
    	}
    }

    def logout() {
    	session.user = null
    	redirect action:"login"
    }

    def profile(String email, String fullName, String department) {
    	if (request.method == "POST") {
    		def user = User.get(session?.user?.id)

    		if (!user) {
    			response.sendError 404
    		}

    		user.properties = params

    		if (!user.save()) {
    			return [user:user]
    		}

    		session.user = user//update current session user info
    		flash.message = "user.profile.updated"
    	}

    	[user:User.findByEmail(session?.user?.email)]
    }

}