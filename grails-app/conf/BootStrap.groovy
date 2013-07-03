import ni.edu.uccleon.*
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
    	switch(GrailsUtil.environment) {
    		case "development":
                //users
                def u1 = User.build(password:"123", enabled:true, role:"admin")
                def u2 = User.build(enabled:true)
                def u3 = User.build(enabled:true, password:"123", department:"Registro")
                def u4 = User.build(enabled:true, password:"123", department:"Recursos Humanos")

    			def app1 = Application.build(department:"Soporte Tecnico", user:u1)
                def app2 = Application.build(department:"Administracion", user:u2)
                def app3 = Application.build(department:"Soporte Tecnico", user:u3)
                def app4 = Application.build(department:"Soporte Tecnico", user:u4)

                def task1 = Task.build(application:app1)
                def task2 = Task.build(application:app1)
                def task3 = Task.build(application:app1)
    		break
    	}
    }
    def destroy = {

    }

}