class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				id matches:/\d+/
			}
		}

		//root
		"/"(controller:"user", action:"login")

		//user
		"/login" {
			controller = "user"
			action = "login"
		}

		"/logout" {
			controller = "user"
			action = "logout"
		}

		"/profile" {
			controller = "user"
			action = "profile"
		}

		"/listUsers/$query?" {
			controller = "user"
			action = "list"
		}

		"/showUser/$id/$query?/$view?" {
			controller = "user"
			action = "show"
		}

		"/updateUserState/$id/$view?/$query?" {
			controller = "user"
			action = "updateEnabledState"
		}

		"/resetUserPassword/$id/$query?" {
			controller = "user"
			action = "resetPassword"
		}

		//application
		"/myapplications/$state" {
			controller = "application"
			action = "list"
			constraints {
				state inList:["pending", "attending", "attended", "done"]
			}
		}

		"/applications/$state" {
			controller = "application"
			action = "pendingApplications"
			constraints {
				state inList:["pending", "attending", "attended"]
			}
		}

		//task
		"/deleteTask/$id/$applicationId" {
			controller = "task"
			action = "delete"
			constraints {
				id matches:/\d+/
				applicationId matches:/\d+/
			}
		}

		"/updateTaskStatus/$id/$applicationId" {
			controller = "task"
			action = "updateState"
			constraints {
				id matches:/\d+/
				applicationId matches:/\d+/
			}
		}

		"500"(view:'/error')
	}
}
