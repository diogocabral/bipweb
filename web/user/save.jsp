<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
	</head>
	<body>
		
		<h1>Cadastro de usuários</h1>
		
		<form method="post" action="<ww:url action="save" namespace="/user" includeParams="none" />" >
			<table>
				<tr>
					<td align="right"><label for="user.username">Usuário*:</label></td>
					<td><input type="text" id="user.username" name="user.username" /></td>
				</tr>
				<tr>
					<td align="right"><label for="user.password">Senha*:</label></td>
					<td><input type="password" id="user.password" name="user.password" /></td>
				</tr>				
				<tr>
					<td align="right"><label for="password">Confirmação da Senha:</label></td>
					<td><input type="password" id="password" name="password" /></td>
				</tr>
				<tr>
					<td align="right" colspan="2"><input type="submit" value="Cadastrar" /></td>
				</tr>								
			</table>
		</form>
		
	</body>
</html>