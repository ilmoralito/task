package ni.edu.uccleon

class CommonFilters {

    def filters = {
        all(controller:'*', action:'*') {
            def controllers = ["user", "application", "task"]

            before = {
                if (!session?.user && controllers.contains(controllerName) && actionName != "login") {
                    flash.message = "access.denied"
                    redirect controller:"user"
                    return false
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
