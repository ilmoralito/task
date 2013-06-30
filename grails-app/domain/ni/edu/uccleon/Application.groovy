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
        listByState {state, user ->
            eq "state", state
            eq "user", user
        }
    }

    static belongsTo = [user:User]
    static hasMany = [attendedBy: String]

    String toString() {
    	"$user $dateCreated"
    }

}