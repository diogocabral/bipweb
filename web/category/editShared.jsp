<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Cadastro de categorias</title>
		<style type="text/css">
			@import url("../css/dtree.css");
		</style>
		<script type="text/javascript" src="../javascript/dtree.js"></script>
		<script type="text/javascript">
			function unjoinCategory(id) {
				if (window.confirm("Deseja desvincluar-se desta categoria?")) {
					window.location = "unjoin.do?category.id=" + id;
				}
			}
		</script>
	</head>
	<body>
		
		<h1>Categorias associadas</h1>
		
		<ww:if test="${step == 'editShared'}">
			<div class="dtree" style="float: left; width: 200px;">
				<script type="text/javascript">${treeView}</script>
			</div>
			
			<table>
				<tr>
					<td>Nome:</td>
					<td>${category.name}</td>
				</tr>
				<tr>
					<td>Descrição:</td>
					<td>${category.description}</td>
				</tr>
				<tr>
					<td>Critérios de busca:</td>
					<td>${category.criteria}</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="right">
						<ww:if test="${category.parent == null}">
							<input type="button" value="Desvincular-se" onclick="javascript:unjoinCategory(${category.id});">
						</ww:if>
						</div>
					</td>
				</tr>
			</table>
			
		</ww:if>
		<ww:else>
			<div class="dtree">
				<script type="text/javascript">${treeView}</script>
			</div>
		</ww:else>
		
		<br />
		
		<a href="searchShared.do">Associar-se a mais categorias</a>
		
	</body>
</html>