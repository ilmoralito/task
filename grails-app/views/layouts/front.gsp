<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title><g:layoutTitle default="task"/></title>
	<r:layoutResources/>
</head>
<body>
	<div class="container main">
		<div class="row">
			<div class="span4 offset4">
				<g:layoutBody/>
				<g:if test="${flash.message}">${flash.message}</g:if>
			</div>
		</div>
	</div>
	<r:layoutResources/>
</body>
</html>