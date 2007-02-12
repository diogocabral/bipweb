<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Pesquisar</title>
		<ww:head />
	</head>
	<body>
		
		<h1>Pesquisar</h1>
		
		<a href="search.do">Pesquisar</a>
		
		<ww:iterator value="documents">
		<p>
			<a href="${url}">${title}</a>
			<br />
			Endereço: <a href="${url}" target="_blank">${url}</a>
		</p>
		</ww:iterator>
		
	</body>
</html>