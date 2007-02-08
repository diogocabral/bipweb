<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
		<ww:head />
	</head>
	<body>
		
		<h1>Cadastro de usuários</h1>
		
		Aguarde...
		
		<ww:form method="post" action="doSave.action">
			<ww:textfield label="Usuário" name="user.username" required="true" />
			<ww:password label="Senha" name="user.password" required="true" />
			<ww:password label="Confirmação da Senha" name="passwordConfirm" required="true" />
			<ww:submit value="Salvar" />
		</ww:form>
		
	</body>
</html>