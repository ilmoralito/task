<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Solicitudes</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<div class="row">
		<div class="span10">
			<div class="pull-right">
				<g:link action="create" class="btn">Crear solicitud</g:link>
				<div class="btn-group">
				    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				    	Solicitudes
				    	<span class="caret"></span>
				    </a>
					<ul class="dropdown-menu">
						<li><g:link action="list" params="[state:'pending']">Pendientes</g:link></li>
						<li><g:link action="list" params="[state:'attending']">Atendiendose</g:link></li>
						<li><g:link action="list" params="[state:'attended']">Atendidas</g:link></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<br>

    <g:if test="${apps}">
    	<table class="table table-hover">
    		<thead>
    			<th>Descripcion</th>
    			<g:if test="${params.state == 'attended'}">
    				<th></th>
    			</g:if>
    		</thead>
    		<tbdoy>
    			<g:each in="${apps}" var="app">
    				<tr>
    					<td>
    						<g:link action="show" id="${app.id}">${app.description}</g:link>
    					</td>
    					<g:if test="${params.state == 'attended'}">
    						<td class="td-mini">
    							<g:link action="updateState" id="${app.id}" class="btn btn-mini btn-info">
    								<g:status status="${app.state}"/>
    							</g:link>
    						</td>
    					</g:if>
    				</tr>
    			</g:each>
    		</tbdoy>
    	</table>
    </g:if>
    <g:else>
    	<div class="alert alert-info">nothing.to.show</div>
    </g:else>
</body>
</html>