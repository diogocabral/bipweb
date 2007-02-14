<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
	</head>
	<body>
		
		<h1>Entrar</h1>

		<ww:form method="post" action="/user/login.do">
			<ww:textfield label="Usuário" name="user.username" />
			<ww:password label="Senha" name="password" />
			<ww:submit value="Entrar" />
		</ww:form>
		
		<ww:actionerror />
		
		<p>Não é cadastrado? <a href="save.jsp">Cadastre-se</a></p>
		
	</body>
</html>