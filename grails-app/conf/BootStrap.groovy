import ni.edu.uccleon.*
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
    	switch(GrailsUtil.environment) {
    		case "development":
                //users
                def u1 = User.build(password:"123", enabled:true, role:"admin")
                def u2 = User.build(enabled:true)

    			def app1 = Application.build(department:"Soporte Tecnico", user:u1)
                def app2 = Application.build(department:"Administracion", user:u2)
    		break
    	}
    }
    def destroy = {

    }

}