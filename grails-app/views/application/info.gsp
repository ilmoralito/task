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

			<g:if test="${app.tasks}">
				<table class="table table-hover">
						<thead>
							<th></th>
							<th></th>
							<th></th>
						</thead>
						<tbody>
							<g:each in="${app.tasks}" var="task">
								<tr>
									<td><g:link controller="task" action="show" params="[applicationId:app.id, id:task.id]">${task.problem}</g:link></td>
									<td class="td-mini">
										<g:link controller="task" action="updateState" params="[applicationId:app.id, id:task.id]">
											<g:state state="${task.state}"/>
										</g:link>
									</td>
									<td class="td-mini">
										<g:link controller="task" action="delete" params="[applicationId:app.id, id:task.id]">
											<i class="icon-trash"></i>
										</g:link>
									</td>
								</tr>
							</g:each>
						</tbody>
					</table>
			</g:if>
		</div>
		<div class="span2">
			<g:link action="updateState" params="[id:app.id, flag:true]" class="btn btn-block">${app.state}</g:link>
			<g:link controller="task" action="create" id="${app.id}" class="btn btn-block">Agregar tarea</g:link>

			<br>

			<g:each in="${users.findAllByDepartment(app.user.department)}" var="user">
				<label class="checkbox">
					<g:checkBox name="attendedBy" value="${user.email}"/> ${user.fullName}
				</label>
			</g:each>

			<br>

			<g:form action="" style="width:90.666%;">
				<g:select name="userName" from="${users.listByNotDepartment(session?.user?.department).list()}" optionValue="fullName" class="span2"/>
				<button class="btn"><i class="icon-plus"></i></button>
			</g:form>
		</div>
	</div>
</body>
</html>