<g:set var="departments" value="${grailsApplication.config.ni.edu.uccleon.departments}"/>

<label for="email">Correo electronico</label>
<g:textField name="email" value="${user?.email}" class="span5" autofocus="true" placeholder="fullName@ucc.edu.ni"/>

<label for="fullName">Nombre completo</label>
<g:textField name="fullName" value="${user?.fullName}" class="span5"/>

<label for="department">Departamento</label>
<g:select name="department" from="${departments}" value="${user?.department}"/>