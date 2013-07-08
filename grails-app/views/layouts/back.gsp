<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title><g:layoutTitle default="task"/></title>
	<r:layoutResources/>
</head>
<body>
	<g:set var="app" value="${ni.edu.uccleon.Application}"/>

	<div class="container main">
		<div class="row">
			<div class="span2">
				<!--sidebar-->
				<ul class="nav nav-tabs nav-stacked">
					<li><g:link controller="user" action="profile"><g:profile/></g:link></li>
					<li><g:link controller="application" params="[state:'pending']">Solicitudes</g:link></li>
					<li>
						<g:link controller="application" action="pendingApplications">
							Requerimientos ${app.listByDepartment(session?.user?.department).listByApplicationState("pending").count()}
						</g:link>
					</li>
					<li><g:link controller="user" action="logout">Cerrar sesion</g:link></li>
    			</ul>
			</div>
			<div class="span10">
				<!--main content-->
				<g:layoutBody/>
				<g:if test="${flash.message}">${flash.message}</g:if>
			</div>
		</div>
	</div>
	<r:layoutResources/>
</body>
</html>