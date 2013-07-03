<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Crear solicitud</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, style"/>
</head>
<body>
	<g:form action="create">
		<g:hiddenField name="applicationId" value="${params?.id}"/>
		<g:render template="form"/>
		<g:submitButton name="send" value="Guardar tarea" class="btn"/>
		<g:link controller="application" action="info" params="[id:params?.id]" class="btn">Regresar</g:link>
	</g:form>
</body>
</html>