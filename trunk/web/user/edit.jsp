<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
		<ww:head />
	</head>
	<body>
		
		<h1>Cadastro de usu�rios</h1>
		
		Aguarde...
		
		<ww:form method="post" action="doSave.action">
			<ww:textfield label="Usu�rio" name="user.username" />
			<ww:password label="Senha" name="user.password" />
			<ww:password label="Confirma��o da Senha" name="passwordConfirm" />
			<ww:submit value="Salvar" />
		</ww:form>
		
	</body>
</html>