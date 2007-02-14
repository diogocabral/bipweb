<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Tchmramram</title>
	</head>
	<body>
		
		<h1>Tchamramram</h1>
		
		<center>
		<form action="searchShared.do">
			<input type="text" name="query" />
			<input type="submit" value="Pesquisar" />
		</form>
		</center>
		
		<ww:iterator value="categories">
			${name}
			<a href="join.do?category.id=${id}">Vincular-se</a>
			<br />
		</ww:iterator>
		
	</body>
</html>