package ni.edu.uccleon

class User {

    String email
    String password
    String fullName
    String department
    String role
    Boolean enabled

	Date dateCreated
	Date lastUpdated

    static constraints = {
        email blank:false, unique:true, email:true
        password blank:false
        fullName blank:false
        department inList:["Soporte Tecnico", "Administracion", "Registro", "Recursos Humanos"]
        role inList:["admin", "user"]
    }

    static mapping = {
    	verison false
    }

    def beforeInsert() {
        password = password.encodeAsSHA1()
    }

    def beforeUpdate() {
        if (isDirty("password")) {
            password = password.encodeAsSHA1()
        }
    }

    String toString() {
    	fullName
    }

}