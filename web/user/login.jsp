<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
		<ww:head />
	</head>
	<body>
		
		<h1>Entrar</h1>
		
		Aguarde...
		
		<ww:form method="post" action="doLogin.action">
			<ww:textfield label="Usu�rio" name="user.username" />
			<ww:password label="Senha" name="password" />
			<ww:submit value="Entrar" />
		</ww:form>
		
		<ww:actionerror />
		
		<p>N�o � cadastrado? <a href="edit.jsp">Cadastre-se</a></p>
		
	</body>
</html>