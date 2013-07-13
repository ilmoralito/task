<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="back">
	<title>Solicitudes de servicio</title>
	<r:require modules = "bootstrap-css, bootstrap-responsive-css, bootstrap-dropdown, bootstrap-dropdown, style"/>
</head>
<body>
	<ul class="nav nav-tabs">
        <li class="${(params.state == 'pending') ? 'active' : 'no-active'}">
            <g:link action="pendingApplications" params="[state:'pending']">
                Pendientes <g:countApps status="pending"/>
            </g:link>
        </li>
        <li class="${(params.state == 'attending') ? 'active' : 'no-active'}">
            <g:link action="pendingApplications" params="[state:'attending']">
                Atendiendose <g:countApps status="attending"/>
            </g:link>
        </li>
        <li class="${(params.state == 'attended') ? 'active' : 'no-active'}">
            <g:link action="pendingApplications" params="[state:'attended']">
                Atendidas <g:countApps status="attended"/>
            </g:link>
        </li>
    </ul>

    <g:if test="${apps}">
    	<table class="table table-hover">
    		<thead>
    			<th>Descripcion</th>
    			<th></th>
                <th></th>
    		</thead>
    		<tbdoy>
    			<g:each in="${apps}" var="app">
    				<tr>
    					<td>
    						<g:link action="info" id="${app.id}">
    							${app.description} por <strong>${app.user.fullName}</strong> - ${app.user.department}
    						</g:link>
    					</td>
    					<td class="td-mini">
    						<g:link action="updateState" id="${app.id}">
                                <g:status status="${app.state}"/>
                            </g:link>
    					</td>
                        <td class="td-mini">
                            <g:renderDate date="${app.dateCreated}"/>
                        </td>
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