<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="front">
	<title>Iniciar sesion</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, style"/>
</head>
<body>
	<h4>Bienvenido al sistema de manejo de tareas</h4>

	<g:form action="login">
		<label for="email">Correo electronico</label>
		<g:textField name="email" class="input-block-level" autofocus="true"  placeholder="Email"/>

		<label for="password">Clave</label>
		<g:passwordField name="password" class="input-block-level"/>

		<g:submitButton name="send" value="Iniciar sesion" class="btn"/>
	</g:form>
</body>
</html>