package ni.edu.uccleon

import org.springframework.web.context.request.RequestContextHolder as RCH

class UserController {

	static defaultAction = "login"
	static allowedMethods = [
		login:["GET", "POST"],
		logout:"GET",
		profile:["GET", "POST"],
		updatePassword:"POST",
        list:["GET", "POST"],
        create:["GET", "POST"],
        delete:"GET",
        show:"GET",
        update:"POST"
	]

    def list() {
        if (request.method == "POST" || params.query) {
            def criteria = User.createCriteria()
            def users = criteria.list() {
                or {
                    ilike "email", "%" + params?.query + "%"
                    ilike "fullName", "%" + params?.query + "%"
                    ilike "department", "%" + params?.query + "%"
                }
            }

            return [users:users]
        } else {
            return [users:User.list()]
        }
    }

    def create() {
        if (request.method == "POST") {
            params.password = "123"

            def user = new User(params)

            if (!user.save()) {
                return [user:user]
            }

            flash.message = "user.succesfully.created"
        }
    }

    def delete(Integer id) {
        def user = User.get(id)

        if (!user) {
            response.sendError 404
        }

        user.delete()

        flash.message = "user.deleted"
        redirect action:"list"
    }

    def show(Integer id) {
        def user = User.get(id)

        if (!user) {
            response.sendError 404
        }

        [user:user]
    }

    def update(Integer id) {
        def user = User.get(id)

        if (!user) {
            response.sendError 404
        }

        user.properties["email", "fullName", "department"] = params

        if (!user.save()) {
            flash.message = "something.when.wrong.please.check.validations"
            chain action:"show", params:[id:id, user:user, query:params?.query]
            return false
        }

        flash.message = "user.succesfully.updated"
        redirect action:"show", params:[id:id, query:params?.query]
    }

    def updateEnabledState(Integer id) {
        def user = User.get(id)

        if (!user) {
            response.sendError 404
        }

        user.enabled = (user.enabled) ? false : true

        flash.message = (!user.save()) ? "upps.something.when.wrong" : "user.enabled.state.succesfully.updated"

        def path = (!params.view) ? "list" : "show"

        redirect action:path, params:params
    }

    def resetPassword(Integer id) {
        def user = User.get(id)

        if (!user) {
            response.sendError 404
        }

        user.password = "123"

        flash.message = (!user.save()) ? "upps.something.when.wrong" : "user.password.succesfully.updated"
        redirect action:"show", params:params
    }

    def login(String email, String password) {
    	if (request.method == "POST") {
    		def user = User.login(email, password).get()

    		if (!user) {
    			flash.message = "user.not.found"
                return [user:user]
    		}

    		session.user = user
    		redirect controller:"application", params:[state:"attended"]
    	}
    }

    def logout() {
    	session.user = null
    	redirect action:"login"
    }

    def profile(String email, String fullName, String department) {
    	if (request.method == "POST") {
    		def user = User.findByEmail(session?.user?.email)

    		if (!user) {
    			response.sendError 404
    		}

    		user.properties = params

    		if (!user.save()) {
    			redirect action:"profile", params:[user:user]
    			return
    		}

    		session.user = user//update current session user info
    		flash.message = "user.profile.updated"
    	}

    	[user:User.findByEmail(session?.user?.email)]
    }

    def updatePassword(updatePasswordCommand cmd) {
    	if (!cmd.validate()) {
    		flash.message = "wrong.data"
    		chain action:"profile", model:[cmd:cmd]
    		return
    	}

    	def user = cmd.updateUserPassword()

    	if (user) {
    		flash.message = "user.password.updated"
    	} else {
    		flash.message = "something.when.wrong"
    	}

    	redirect action:"profile"
    }

}

class updatePasswordCommand {
	String password
	String nPassword
	String rPassword

	static constraints = {
		importFrom User
		def session = RCH.requestAttributes.session

		password blank:false, validator:{password ->
			password.encodeAsSHA1() == session?.user?.password
		}
		rPassword blank:false, validator:{rPassword, obj ->
			rPassword == obj.nPassword
		}
	}

	User updateUserPassword() {
		def user = User.findByEmail(session?.user?.email)

		if (user) {
			user.properties["password"] = nPassword
		}

		user
	}

}