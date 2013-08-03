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

	<div class="row">
		<div class="span10">
			<g:form action="update">
				<g:hiddenField name="id" value="${params?.id}"/>
				<g:render template="form"/>
				<br>
				<g:submitButton name="send" value="Actualizar" class="btn"/>
				<g:link action="list" class="btn">Regresar</g:link>
			</g:form>
		</div>
		<div class="span2">
			<g:link action="resetPassword" params="[id:user.id]" class="btn btn-warning btn-block">Resturar clave</g:link>
		</div>
	</div>
</body>
</html>