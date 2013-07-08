import ni.edu.uccleon.*
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
    	switch(GrailsUtil.environment) {
    		case "development":
                //users
                def u1 = User.build(fullName:"admin", password:"123", enabled:true, role:"admin")//ST
                def u2 = User.build(fullName:"mario", password:"123", enabled:true, role:"user")//ST
                def u3 = User.build(fullName:"amanda", password:"123", enabled:true, department:"Registro")

    			def app1 = Application.build(department:"Soporte Tecnico", description:"very important test", user:u3, owner:u1, state:"attending")
                def app2 = Application.build(department:"Soporte Tecnico", description:"lorem ipsum", user:u3)

                def task1 = Task.build(application:app1)
                def task2 = Task.build(application:app1)
                def task3 = Task.build(application:app1)
    		break
    	}
    }
    def destroy = {

    }

}