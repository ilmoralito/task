<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Crear solicitud</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, style"/>
</head>
<body>
	<g:hasErrors bean="${app}">
		<g:renderErrors bean="${app}"/>
	</g:hasErrors>

	<g:form action="create">
		<g:render template="form"/>
		<g:submitButton name="send" value="Enviar solicitud" class="btn"/>
	</g:form>
</body>
</html>