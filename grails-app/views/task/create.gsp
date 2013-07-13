<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Crear solicitud</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<g:hasErrors bean="${task}">
		<g:renderErrors bean="${task}"/>
	</g:hasErrors>

	<g:form action="create">
		<g:hiddenField name="application.id" value="${params?.id}"/>
		<g:render template="form"/>
		<br>
		<g:submitButton name="send" value="Guardar tarea" class="btn"/>
		<g:link controller="application" action="info" params="[id:params?.id]" class="btn">Regresar</g:link>
	</g:form>
</body>
</html>