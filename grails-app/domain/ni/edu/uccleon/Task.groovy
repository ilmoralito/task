package ni.edu.uccleon

class Task {

    String problem
    String solution
    Boolean state = false

	Date dateCreated
	Date lastUpdated

    static constraints = {
        problem blank:false, maxSize:140
        solution blank:false, maxSize:140
    }

    static belongsTo =[application:Application]

    static mapping = {
    	version false
    }

    String toString() {
    	"$problem -> $solution"
    }

}