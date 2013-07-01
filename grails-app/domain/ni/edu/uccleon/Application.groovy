package ni.edu.uccleon

class Application {

    String department
    String description
    String state = "pending"

	Date dateCreated
	Date lastUpdated

    static constraints = {
        department blank:false
        description blank:false, maxSize:140
        state inList:["pending", "attending", "attended"], maxSize:255
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

    static belongsTo = [user:User]
    static hasMany = [attendedBy: String]

    String toString() {
    	"$user $dateCreated"
    }

}