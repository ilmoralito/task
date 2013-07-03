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
}
