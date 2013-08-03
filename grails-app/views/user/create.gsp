<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Usuarios</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<g:hasErrors bean="${user}">
		<g:renderErrors bean="${user}"/>
	</g:hasErrors>

	<g:form action="create">
		<g:render template="form"/>
		<br>
		<g:submitButton name="send" value="Guardar" class="btn"/>
		<g:link action="list" class="btn">Regresar</g:link>
	</g:form>
</body>
</html>