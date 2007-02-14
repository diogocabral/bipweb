<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Cadastro de categorias</title>
		<style type="text/css">
			@import url("../css/dtree.css");
		</style>
		<script type="text/javascript" src="../javascript/dtree.js"></script>
		<script type="text/javascript">
			function deleteCategory(id) {
				if (window.confirm("Deseja excluir esta categoria?")) {
					window.location = "delete.do?category.id=" + id;
				}
			}
		</script>
	</head>
	<body>
		
		<h1>Minhas categorias</h1>
		
		<ww:if test="${step == 'new' || step == 'edit' }">
			<div class="dtree" style="float: left; width: 200px;">
				<script type="text/javascript">${treeView}</script>
			</div>
			
			<form method="post" action="save.do">
			<ww:if test="${category.id != null}">
				<input type="hidden" name="category.id" value="${category.id}" />
			</ww:if>
			<ww:if test="${category.parent.id != null}">
				<input type="hidden" name="category.parent.id" value="${category.parent.id}" />
			</ww:if>
			<table class="wwFormTable">
				<tr>
					<td class="tdLabel"><label class="label">Nome<span class="required">*</span>:</label></td>
					<td><input type="text" name="category.name" size="40" value="${category.name}" /></td>
				</tr>
				<tr>
					<td class="tdLabel"><label class="label">Descri��o:</label></td>
					<td><input type="text" name="category.description" size="40" value="${category.description}" /></td>
				</tr>
				<tr>
					<td class="tdLabel"><label class="label">Crit�rios de busca<span class="required">*</span>:</label></td>
					<td>
						<textarea name="category.criteria" cols="40" rows="5">${category.criteria}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="right">
						<ww:if test="${category.id != null}">
							<input type="button" value="Excluir categoria" onclick="javascript:deleteCategory(${category.id});">
						</ww:if>
							<input type="submit" value="Salvar" />
						</div>
					</td>
				</tr>
			</table>
			</form>
			
		</ww:if>
		<ww:else>
			<div class="dtree">
				<script type="text/javascript">${treeView}</script>
			</div>
		</ww:else>
		
	</body>
</html>