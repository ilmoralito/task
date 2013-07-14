import ni.edu.uccleon.*
import grails.util.GrailsUtil
//import grails.plugin.heroku.PostgresqlServiceInfo

class BootStrap {

    def init = { servletContext ->
        /*
        String DATABASE_URL = System.getenv('DATABASE_URL')
        if (DATABASE_URL) {
            try {
                PostgresqlServiceInfo info = new PostgresqlServiceInfo()
                println "\nPostgreSQL service ($DATABASE_URL): url='$info.url', " + "user='$info.username', password='$info.password'\n"
            }
            catch (e) {
                println "Error occurred parsing DATABASE_URL: $e.message"
            }
        }
        */

    	switch(GrailsUtil.environment) {
    		case "development":
                //users
                def u1 = User.build(fullName:"admin", password:"123", enabled:true, role:"admin")//ST
                def u2 = User.build(fullName:"mario roger", password:"123", enabled:true, role:"user")//ST
                def u3 = User.build(fullName:"amanda morales meza", password:"123", enabled:true, department:"Registro")
                def u4 = User.build(fullName:"roger hadned martinez morales", password:"123", enabled:true, department:"Registro")

    			def app1 = Application.build(department:"Soporte Tecnico", description:"very important test", user:u3, owner:u1, state:"attending")
                def app2 = Application.build(department:"Soporte Tecnico", description:"lorem ipsum", user:u3)

                def task1 = Task.build(application:app1)
                def task2 = Task.build(application:app1)
                def task3 = Task.build(application:app1)
    		break
            case "production":
                def user = User.findByEmail("mario.martinez@ucc.edu.ni")

                if (!user) {
                    new User(email:"mario.martinez@ucc.edu.ni", password:"password", fullName:"Mario Roger Martinez Morales", department:"Soporte Tecnico", role:"admin").save()
                }
            break
    	}
    }
    def destroy = {

    }

}