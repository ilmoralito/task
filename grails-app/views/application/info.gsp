<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Solicitud</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, style"/>
</head>
<body>
	<g:set var="users" value="${ni.edu.uccleon.User}"/>

	<div class="row">
		<div class="span8">
			<h4>${app.description}</h4>
			<p>
				Por ${app.user.fullName} en ${app.user.department}, <g:renderDate date="${app.dateCreated}"/>
			</p>
		</div>
		<div class="span2">
			<g:link action="updateState" id="${app.id}" class="btn btn-block">${app.state}</g:link>
			<g:link controller="task" action="create" id="${app.id}" class="btn btn-block">Agregar tarea</g:link>

			<br>

			<g:each in="${users.findAllByDepartment(app.user.department)}" var="user">
				<label class="checkbox">
					<g:checkBox name="attendedBy" value="${user.email}"/> ${user.fullName}
				</label>
			</g:each>

			<br>

			<g:form action="" style="width:90.666%;">
				<g:select name="userName" from="${users.list()}" optionValue="fullName" class="span2"/>
				<button class="btn"><i class="icon-plus"></i></button>
			</g:form>
		</div>
	</div>
</body>
</html>