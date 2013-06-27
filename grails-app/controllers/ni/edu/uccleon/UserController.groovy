package ni.edu.uccleon

class UserController {

	static defaultAction = "login"
	static allowedMethods = [
		login:["GET", "POST"]
	]

    def login(String email, String password) {
    	if (request.method == "POST") {
    		def user = User.login(email, password).get()

    		if (!user) {
    			flash.message = "user.not.found"
    			redirect action:"login"
    			return
    		}
    	}
    }

}