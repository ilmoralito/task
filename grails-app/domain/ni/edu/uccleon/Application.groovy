package ni.edu.uccleon

class Application {

    String department
    String description
    String state = "pending"

	Date dateCreated
	Date lastUpdated

    static constraints = {
        department blank:false
        description blank:false
        state inList:["pending", "attending", "attended"], maxSize:255
    }

    static belongsTo = [user:User]
    static hasMany = [attendedBy: String]

    static mapping = {
    	version false
    }

    String toString() {
    	"$user $dateCreated"
    }

}