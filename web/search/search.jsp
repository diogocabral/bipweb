<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Pesquisar</title>
		<style type="text/css">
			@import url("../css/dtree.css");
			@import url("../css/grid.css");
		</style>
		<script type="text/javascript" src="../javascript/dtree.js"></script>
		<script type="text/javascript" src="../javascript/grid.js"></script>
		<script type="text/javascript">
			var old = window.onload;
			window.onload = function(event) {
				stripe('grid', '#fff', '#edf3fe');
				return old();
			}
		</script>
	</head>
	<body>
		
		<h1>Pesquisar</h1>
		
		<p>Clique na categoria desejada para iniciar a busca.</p>
		
		<ww:if test="${step == 'search' || step == 'searchNext' }">
			<div class="dtree" style="width: 200px;">
				<script type="text/javascript">${treeView}</script>
				<br />
				<a href="searchNext.do">Mais resultados</a>
			</div>

			<div style="">
				<table id="grid" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th width="60">Relevância</th>
							<th>Título</th>
						</tr>					
					</thead>
					<tbody>
					<ww:iterator value="documents">
						<tr onclick="window.location = 'open.do?document.url=<ww:property value="url" />'">
							<td><ww:property value="score" /></td>
							<td><ww:property value="title" /></td>
						</tr>
					</ww:iterator>
					</tbody>
				</table>
			</div>
				
		</ww:if>
		<ww:else>
			<div class="dtree">
				<script type="text/javascript">${treeView}</script>
			</div>
		</ww:else>
		
	</body>
</html>