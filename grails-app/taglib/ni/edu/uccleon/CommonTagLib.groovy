package ni.edu.uccleon

class CommonTagLib {
	def renderDate = { attrs, body ->
		def dateCreated = attrs.date
		def today = new Date()

		def todayYear = today[Calendar.YEAR]
		def dateCreatedYear = dateCreated[Calendar.YEAR]
		def todayDay = today[Calendar.DATE]
		def dateCreatedDay = dateCreated[Calendar.DATE]

		def months = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Ocutbre", "Noviembre", "Diciembre"]

		if (todayYear == dateCreatedYear) {
			if (todayDay == dateCreatedDay) {
				out << dateCreated[Calendar.HOUR] + ":" + dateCreated[Calendar.MINUTE]
			} else {
				out << dateCreated[Calendar.DAY_OF_MONTH] + " de " + months[dateCreated[Calendar.MONTH]]
			}
		} else {
			out << dateCreatedYear + "-" + dateCreated[Calendar.MONTH] + "-" + dateCreated[Calendar.DATE]
		}
	}

	def state = {attrs, body ->
		def state = attrs.state

		if (!state) {
			out << "<i class='icon-time'></i>"
		} else {
			out << "<i class='icon-ok'></i>"
		}
	}

	def status = {attrs, body ->
		def status = attrs.status

		if (status == "pending") {
			out << "Pendiente"
		} else if (status == "attending") {
			out << "Atendiendo"
		} else if (status == "attended") {
			out << "Terminado"
		} else {
			out << "Hecho"
		}
	}

	def countAppsByStatus = {attrs, body ->
		def status = attrs.status

		def count = Application.listByState(session?.user, status).count()

		if (count) {
			out << count
		}
	}

	def profile = {attrs, body ->
		def fullName = session?.user?.fullName
		def names = fullName.split(" ")
		def size = names.size()

		if (size == 1 || size == 2) {
			out << fullName
		} else if (size == 3) {
			out << names[0] + " " + names[1]
		} else {
			out << names[0] + " " + names[2]
		}

	}
}