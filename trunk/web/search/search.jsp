<%@ taglib prefix="ww" uri="/webwork" %>

<html>
	<head>
		<title>Pesquisar</title>
		<ww:head />
	</head>
	<body>
		
		<h1>Pesquisar</h1>
		
		<a href="doSearch.action">Pesquisar</a>
		
		<ww:iterator value="documents">
		<p>
			<a href="${url}">${title}</a>
			<br />
			Endereço: <a href="${url}">${url}</a>
		</p>
		</ww:iterator>
		
	</body>
</html>