<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
	</head>
	<body>
		
		<h1>Cadastro de usu�rios</h1>
		
		<ww:form method="post" action="save.do">
			<ww:textfield label="Usu�rio" name="user.username" required="true" />
			<ww:password label="Senha" name="user.password" required="true" />
			<ww:password label="Confirma��o da Senha" name="password" required="true" />
			<ww:submit value="Salvar" />
		</ww:form>
		
	</body>
</html>