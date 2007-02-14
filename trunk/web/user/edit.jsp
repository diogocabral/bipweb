<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
	</head>
	<body>
		
		<h1>Minha Conta</h1>
		
		<form method="post" action="edit.do">
			<table>
				<tr>
					<td>Senha :</td>
					<td>
						<input type="hidden" name="user.username" value="<ww:property value="user.username" />" />
						<input type="password" name="user.password" />
					</td>
				</tr>
				<tr>
					<td>Confirmação :</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Alterar" /></td>
				</tr>
			</table>
		</form>

		<ww:actionmessage />
		<ww:actionerror />
	</body>
</html>