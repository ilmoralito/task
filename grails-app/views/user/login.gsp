<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="front">
	<title>Iniciar sesion</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, style"/>
</head>
<body>
	<g:form action="login">
		<label for="email">Correo electronico</label>
		<g:textField name="email" value="${params?.email}" class="input-block-level" autofocus="true" placeholder="my@email.com"/>

		<label for="password">Clave</label>
		<g:passwordField name="password" class="input-block-level"/>

		<g:submitButton name="send" value="Iniciar sesion" class="btn"/>
	</g:form>
</body>
</html>