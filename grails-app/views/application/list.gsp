<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Solicitudes</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, style"/>
</head>
<body>
	<ul class="nav nav-tabs">
    	<li class="${(params.state == 'pending') ? 'active' : 'no-active'}">
    		<g:link action="list" params="[state:'pending']">
    			Pendientes <g:countAppsByStatus status="pending"/>
    		</g:link>
    	</li>
    	<li class="${(params.state == 'attending') ? 'active' : 'no-active'}">
    		<g:link action="list" params="[state:'attending']">
    			Atendiendose <g:countAppsByStatus status="attending"/>
    		</g:link>
    	</li>
    	<li class="${(params.state == 'attended') ? 'active' : 'no-active'}">
    		<g:link action="list" params="[state:'attended']">
    			Atendidas <g:countAppsByStatus status="attended"/>
    		</g:link>
    	</li>
    	<li class="${(params.state == 'done') ? 'active' : 'no-active'}">
    		<g:link action="list" params="[state:'done']">
    			Terminadas
    		</g:link>
    	</li>
    </ul>

	<div class="row">
		<div class="span10">
			<div class="pull-right">
				<g:link action="create" class="btn">Crear solicitud</g:link>
			</div>
		</div>
	</div>

    <g:if test="${apps}">
    	<table class="table table-hover">
    		<thead>
    			<th>Descripcion</th>
    		</thead>
    		<tbdoy>
    			<g:each in="${apps}" var="app">
    				<tr>
    					<td>
    						<g:link action="show" id="${app.id}">${app.description}</g:link>
    					</td>
    					<g:if test="${params.state == 'attended' || params.state == 'done'}">
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
    	<br>
    	<div class="alert alert-info">nothing.to.show</div>
    </g:else>
</body>
</html>