<%@ taglib prefix="ww" uri="/webwork" %>

<html>
	<head>
		<title>Cadastro de categorias</title>
		<style type="text/css">
			@import url("../css/default.css");
		</style>
		<ww:head />
	</head>
	<body>
		
		<h1>Cadastro de categorias</h1>
		
		<ww:form method="post" action="doSave.action">
			<ww:textfield label="Nome" name="category.name" size="40" required="true" />
			<ww:textfield label="Descrição" name="category.description" size="40" />
			<ww:textarea label="Critérios de busca" name="category.criteria" cols="40" rows="5" required="true" />
			<ww:submit value="Salvar" />
		</ww:form>
		
	</body>
</html>