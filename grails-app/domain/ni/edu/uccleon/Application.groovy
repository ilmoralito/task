package ni.edu.uccleon

class Application {

    String department
    String description
    String state = "pending"
    User owner

	Date dateCreated
	Date lastUpdated

    static constraints = {
        department blank:false
        description blank:false, maxSize:140
        state inList:["pending", "attending", "attended", "done"], maxSize:255
        owner nullable:true
    }

    static namedQueries = {
        listByState {user, state ->
            eq "user", user
            listByApplicationState(state)
        }

        listByDepartment { department ->
            eq "department", department
        }

        listByApplicationState { state ->
            eq "state", state
        }
    }

    List tasks

    static belongsTo = [user:User]
    static hasMany = [attendedBy: String, tasks:Task]

    String toString() {
    	"$user $dateCreated"
    }

}