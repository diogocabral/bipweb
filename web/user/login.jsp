<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Entrar</title>
		<ww:head />
	</head>
	<body>
		
		<h1>Entrar</h1>
		
		<ww:form method="post" action="/user/login.do">
			<ww:textfield label="Usu�rio" name="user.username" />
			<ww:password label="Senha" name="password" />
			<ww:submit value="Entrar" />
		</ww:form>
		
		<ww:actionerror />
		
		<p>N�o � cadastrado? <a href="save.jsp">Cadastre-se</a></p>
		
	</body>
</html>