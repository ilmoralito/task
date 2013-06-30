<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>editar solicitud</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, style"/>
</head>
<body>
	<g:hasErrors bean="${app}">
		<g:renderErrors bean="${app}"/>
	</g:hasErrors>

	<g:form action="update">
		<g:hiddenField name="id" value="${params?.id}"/>
		<g:render template="form"/>
		<g:submitButton name="send" value="Actualizar solicitud" class="btn"/>
		<g:link action="delete" id="${params?.id}" class="btn">Borrar solicitud</g:link>
	</g:form>
</body>
</html>