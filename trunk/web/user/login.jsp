<%@ taglib prefix="ww" uri="/webwork" %>

<html>
	<head>
		<ww:head />
	</head>
	<body>
		
		<h3>Bem-vindo ao BIPWeb</h3>
		
		<ww:form method="post" action="doLogin.action">
			<ww:textfield label="Usuário" name="username" />
			<ww:password label="Senha" name="password" />
			<ww:submit value="Entrar" />
		</ww:form>
		
	</body>
</html>