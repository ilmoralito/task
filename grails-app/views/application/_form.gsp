<g:set var="departments" value="${grailsApplication.config.ni.edu.uccleon.departments}"/>

<label for="department">Departamento</label>
<g:select name="department" from="${departments}" value="${app?.department}"/>

<label for="description">Descripcion</label>
<g:textField name="description" value="${app?.description}" class="input-block-level" placeholder="Descripcion en 120 caracteres..."/>