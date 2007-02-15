<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Tchmramram</title>
		<style type="text/css">
			@import url("../css/grid.css");
		</style>		
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
		
		<h1>Tchamramram</h1>
		
		<center>
		<form action="searchShared.do">
			<input type="text" name="query" />
			<input type="submit" value="Pesquisar" />
		</form>
		</center>
		
		<ww:if test="categories != null">
			<div style="text-align: center;">
				<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>								
				<table id="grid" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Categoria</th>
							<th>Descrição</th>					
							<th> </th>
						</tr>
					</thead>
					<tbody>
						<ww:if test="categories.size() > 0">
							<ww:iterator value="categories">
								<tr>
									<td>${name}</td>
									<td>${description}</td>
									<td style="text-align: center; width: 100px;"><a href="join.do?category.id=${id}">Vincular-se</a></td>					
								</tr>
							</ww:iterator>	
						</ww:if>
						<ww:else>
							<tr>
								<td colspan="3">Nenhuma categoria encontrada</td>
							</tr>
						</ww:else>		
					</tbody>
				</table>
				<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>							
			</div>
		</ww:if>		
	</body>
</html>