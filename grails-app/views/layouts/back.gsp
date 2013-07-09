<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title><g:layoutTitle default="task"/></title>
	<r:layoutResources/>
</head>
<body>
	<g:set var="app" value="${ni.edu.uccleon.Application}"/>
	<g:set var="appCrudActions" value="['list', 'create', 'show', 'delete']"/>

    <div class="navbar navbar-inverse navbar-fixed-top">
	    <div class="navbar-inner">
		    <div class="container">
		    	<g:link controller="application" params="[state:'pending']" class="brand">A123</g:link>
		    	<ul class="nav pull-right">
		    		<li>
		    			<g:link controller="application" action="pendingApplications" params="[state:'pending']">
		    				<i class="icon-time icon-white"></i> <g:countApps status="pending"/>
		    			</g:link>
		    		</li>
		    		<li>
		    			<g:link controller="application" action="pendingApplications" params="[state:'attending']">
		    				<i class="icon-hand-down icon-white"></i> <g:countApps status="attending"/>
		    			</g:link>
		    		</li>
		    		<li>
		    			<g:link controller="application" action="pendingApplications" params="[state:'attended']">
		    				<i class="icon-ok icon-white"></i> <g:countApps status="attended"/>
		    			</g:link>
		    		</li>
		    		<li><g:link controller="user" action="logout">Salir</g:link></li>
		    	</ul>
		    </div>
    	</div>
    </div>

	<div class="container main">
		<div class="row">
			<div class="span2">
				<ul class="nav nav-tabs nav-stacked">
					<li class="${(controllerName == 'user') ? 'active' : 'no-active'}">
						<g:link controller="user" action="profile"><g:profile/></g:link>
					</li>
					<li class="${(controllerName == 'application' && appCrudActions.contains(actionName)) ? 'active' : 'no-active'}">
						<g:link controller="application" params="[state:'pending']">Solicitudes</g:link>
					</li>
    			</ul>
			</div>
			<div class="span10">
				<g:layoutBody/>
				<g:if test="${flash.message}">${flash.message}</g:if>
			</div>
		</div>
	</div>
	<r:layoutResources/>
</body>
</html>