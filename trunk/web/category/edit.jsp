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
		
		<ww:if test="${step == 'new' || step == 'edit' }">
			<div class="dtree" style="float: left; width: 200px;">
				<script type="text/javascript">${treeView}</script>
			</div>
			
			<ww:form method="post" action="save.do">
				<ww:if test="${category.id != null}">
					<ww:hidden name="category.id" />
				</ww:if>
				<ww:if test="${category.parent.id != null}">
					<ww:hidden name="category.parent.id" />
				</ww:if>
				<ww:textfield label="Nome" name="category.name" size="40" required="true" />
				<ww:textfield label="Descrição" name="category.description" size="40" />
				<ww:textarea label="Critérios de busca" name="category.criteria" cols="40" rows="5" required="true" />
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