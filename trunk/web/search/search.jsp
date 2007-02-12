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
	</head>
	<body>
		
		<h1>Pesquisar</h1>
		
		<ww:if test="${step == 'search' || step == 'continue' }">
			<div class="dtree" style="width: 200px;">
				<script type="text/javascript">${treeView}</script>
				<br />
				<a href="continue.do">Mais resultados</a>
			</div>

			<div>
				<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
				<table id="grid" cellspacing="0">
					<thead>
						<tr>
							<th>Relevância</th>
							<th>Título</th>
						</tr>					
					</thead>
					<tbody>
					<ww:iterator value="documents">
						<tr onclick="window.location = '<ww:property value="url" />'">
							<td>0</td>
							<td><ww:property value="title" /></td>
						</tr>
					</ww:iterator>
					</tbody>
				</table>
				<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>	
			</div>
				
		</ww:if>
		<ww:else>
			<div class="dtree">
				<script type="text/javascript">${treeView}</script>
			</div>
		</ww:else>
		
	</body>
</html>