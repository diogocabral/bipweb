<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
	<head>
		<title>BIPWeb - <decorator:title /></title>
		<style type="text/css">
			@import url("css/default.css");
		</style>
		<decorator:head />
	</head>
	<body>
		<h2>BIPWeb Tchamramram :)</h2>
		<table>
			<tr>
				<td>
					Contatos
					<ul>
						<li><a href="/crud/contact/edit.action">Novo</a></li>
					</ul>
				</td>
				<td><decorator:body /></td>
			</tr>
		</table>
	</body>
</html>