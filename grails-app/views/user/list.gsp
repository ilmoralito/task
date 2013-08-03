<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Usuarios</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<div class="row">
		<div class="span12">
			<div class="row">
				<div class="span10">
					<g:form action="list" class="form-inline pull-right">
						<g:textField name="query" value="${params?.query}" placeholder="Buscar"/>
						<button type="submit" class="btn"><i class="icon-search"></i></button>
					</g:form>
				</div>
				<div class="span2">
					<g:link action="create" class="btn btn-block">Crear usuario</g:link>
				</div>
			</div>
		</div>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Usuarios ${users.size()}</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${users}" var="user">
				<tr>
					<td>
						<g:link action="show" params="[id:user.id, query:params?.query]">${user.fullName}</g:link>
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