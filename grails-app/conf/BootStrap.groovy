import ni.edu.uccleon.*
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
    	switch(GrailsUtil.environment) {
    		case "development":
    			def u1 = User.build(role:"admin")
    			def u2 = User.build()
    			def u3 = User.build()
    			def u4 = User.build()
    		break
    	}
    }
    def destroy = {
    }
}
