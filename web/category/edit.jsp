<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Cadastro de categorias</title>
		<style type="text/css">
			@import url("../css/dtree.css");
		</style>
		<script type="text/javascript" src="../javascript/dtree.js"></script>
		<ww:head />
	</head>
	<body>
		
		<h1>Cadastro de categorias</h1>
		
		<ww:if test="${action == 'new' || action == 'edit' }">
			<div class="dtree" style="float: left; width: 200px; height: 100%;">
				<script type="text/javascript">${treeView}</script>
			</div>
			
			<ww:form method="post" action="save.do">
				<ww:hidden name="category.id" value="0" />
				<ww:textfield label="Nome" name="category.name" size="40" required="true" />
				<ww:textfield label="Descri��o" name="category.description" size="40" />
				<ww:textarea label="Crit�rios de busca" name="category.criteria" cols="40" rows="5" required="true" />
				<ww:submit value="Salvar" />
			</ww:form>
		</ww:if>
		<ww:else>
			<div class="dtree">
				<script type="text/javascript">${treeView}</script>
			</div>
		</ww:else>
		
	</body>
</html>