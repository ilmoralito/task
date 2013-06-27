package ni.edu.uccleon

class User {

    String email
    String password
    String fullName
    String department
    String role = "user"
    Boolean enabled

	Date dateCreated
	Date lastUpdated

    static constraints = {
        email blank:false, unique:true, email:true, validator:{email, user ->
            email.split("@")[1] == "ucc.edu.ni"
        }
        password blank:false
        fullName blank:false
        department inList:["Soporte Tecnico", "Administracion", "Registro", "Recursos Humanos"]
        role inList:["admin", "user"]
    }

    static namedQueries = {
        login {email, password ->
            eq "email", email
            eq "password", password.encodeAsSHA1()
        }
    }

    static mapping = {
    	version false
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