<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
	</head>
	<body>
		
		<h1>Entrar</h1>

		<form method="post" action="<ww:url action="login" namespace="/user" includeParams="none" />" >
			<table>
				<tr>
					<td align="right"><label for="user.username">Usuário:</label></td>
					<td><input type="text" id="user.username" name="user.username" /></td>
				</tr>
				<tr>
					<td align="right"><label for="password">Senha:</label></td>
					<td><input type="password" id="password" name="password" /></td>
				</tr>
				<tr>
					<td align="right" colspan="2"><input type="submit" value="Entrar" /></td>
				</tr>								
			</table>
		</form>
		
		<ww:actionerror />
		
		<p>Não é cadastrado? <a href="save.jsp">Cadastre-se</a></p>
		
	</body>
</html>