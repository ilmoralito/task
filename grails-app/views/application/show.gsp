<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>editar solicitud</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<g:if test="${app.state == 'pending'}">
		<g:hasErrors bean="${app}">
			<g:renderErrors bean="${app}"/>
		</g:hasErrors>

		<g:form action="update">
			<g:hiddenField name="id" value="${params?.id}"/>
			<g:render template="form"/>
			<g:submitButton name="send" value="Actualizar solicitud" class="btn"/>
			<g:link action="delete" id="${params?.id}" class="btn">Borrar solicitud</g:link>
		</g:form>
	</g:if>
	<g:else>
		<h5>${app.description}</h5>
		<table class="table">
			<tr>
				<td>Solicitado</td>
				<td><g:renderDate date="${app.dateCreated}"/></td>
			</tr>
			<tr>
				<td>Estado</td>
				<td><g:status status="${app.state}"/></td>
			</tr>
			<tr>
				<td>Atendido por</td>
				<td>${app.owner.fullName}</td>
			</tr>
			<tr>
				<td>Grupo</td>
				<td>
					<g:if test="${app.attendedBy}">
						<ol>
							<g:each in="${app.attendedBy}" var="user">
								<li>${ni.edu.uccleon.User.findByEmail(user).fullName}</li>
							</g:each>
						</ol>
					</g:if>
					<g:else>
						...
					</g:else>
				</td>
			</tr>
			<tr>
				<td>Tareas</td>
				<td>
					<g:if test="${app.tasks}">
						<ol>
							<g:each in="${app.tasks}" var="task">
								<li>${task.problem}</li>
							</g:each>
						</ol>
					</g:if>
					<g:else>
						...
					</g:else>
				</td>
			</tr>
		</table>

		<g:link action="list" params="[state:app.state]">Regresar</g:link>
	</g:else>
</body>
</html>