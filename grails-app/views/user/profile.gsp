<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Perfil de ${session?.user}</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<g:hasErrors bean="${user}">
		<g:renderErrors bean="${user}"/>
	</g:hasErrors>

	<div class="row">
		<div class="span6">
			<legend>Perfil</legend>
			
			<g:form action="profile">
				<label for="email">Correo electronico</label>
				<g:textField name="email" value="${user?.email}" class="input-block-level" autofocus="true"/>
			
				<label for="fullName">Nombre completo</label>
				<g:textField name="fullName" value="${user?.fullName}" class="input-block-level"/>
			
				<label for="department">Departamento</label>
				<g:select from="${user?.constraints?.department?.inList}" name="department" value="${user?.department}"/>
			
				<br>
				<g:submitButton name="send" value="Guardar cambios" class="btn"/>
			</g:form>
		</div>
		
		<div class="span5">
			<legend>Actualizar clave</legend>
			
			<g:form action="updatePassword">
				<label for="password">Clave actual</label>
				<g:passwordField name="password"/>
			
				<label for="nPassword">Nueva clave</label>
				<g:passwordField name="nPassword"/>
			
				<label for="rPassword">Repetir clave</label>
				<g:passwordField name="rPassword"/>
			
				<br>
				<g:submitButton name="send" value="Confirmar nueva clave" class="btn"/>
			</g:form>
		</div>
	</div>
</body>
</html>