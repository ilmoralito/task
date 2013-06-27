package ni.edu.uccleon

class CommonFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if (!session.user && controllerName != "user" && actionName != "login") {
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
