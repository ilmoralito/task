<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Usuarios</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, style"/>
</head>
<body>
	<div class="pull-right">
		<g:link action="create" class="btn">Crear usuario</g:link>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Usuarios</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${users}" var="user">
				<tr>
					<td>
						<g:link action="show" params="[id:user.id]">${user.fullName}</g:link>
					</td>
					<td class="td-mini"><g:link action="updateEnabledState" params="[id:user.id]">
						<g:if test="${user.enabled}">
							<i class="icon-ok"></i>
						</g:if>
						<g:else>
							<i class="icon-time"></i>
						</g:else>
					</g:link></td>
					<td class="td-mini">
						<g:link action="delete" params="[id:user.id]"><i class="icon-trash"></i></g:link>
					</td>
				</tr>
			</g:each>
		</tbody>
	</table>
</body>
</html>