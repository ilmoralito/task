<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Editar tarea</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<g:hasErrors bean="${task}">
		<g:renderErrors bean="${task}"/>
	</g:hasErrors>

	<g:form action="update">
		<g:hiddenField name="application.id" value="${params?.applicationId}"/>
		<g:hiddenField name="id" value="${params?.id}"/>
		<g:render template="form"/>
		<br>
		<g:submitButton name="send" value="Actualizar tarea" class="btn"/>
		<g:link controller="application" action="info" params="[id:params.applicationId]" class="btn">Regresar</g:link>
	</g:form>
</body>
</html>