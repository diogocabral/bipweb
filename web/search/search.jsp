<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Pesquisar</title>
		<style type="text/css">
			@import url("../css/dtree.css");
		</style>
		<script type="text/javascript" src="../javascript/dtree.js"></script>
		<ww:head />
	</head>
	<body>
		
		<h1>Pesquisar</h1>
		
		<ww:if test="${step == 'search' || step == 'continue' }">
			<div class="dtree" style="float: left; width: 200px;">
				<script type="text/javascript">${treeView}</script>
				<br />
				<a href="continue.do">Mais resultados</a>
			</div>
			<!-- Datagrid -->
			<div style="-moz-border-radius: 10px; background-color: #FFF7D7; left: 200px;">
				<ww:iterator value="documents">
					<p>
						<a href="${url}">${title}</a>
						<br />
						Endereço: <a href="${url}" target="_blank">${url}</a>
					</p>
				</ww:iterator>
			</div>
		</ww:if>
		<ww:else>
			<div class="dtree">
				<script type="text/javascript">${treeView}</script>
			</div>
		</ww:else>
		
	</body>
</html>