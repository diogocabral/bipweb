<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Histórico de pesquisa</title>
		<style type="text/css">
			@import url("../css/estrelas.css");
			@import url("../css/grid.css");
		</style>
		<ww:head />
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
		
		<h1>Histórico de pesquisa</h1>

		<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>			
		<table id="grid" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Site</th>
					<th>Estrelas</th>
				</tr>
			</thead>
			<tbody>
				<ww:iterator value="histories">				
					<tr>
						<td><a href="<ww:property value="url" />"><ww:property value="title" /></a></td>						
						<td>
							<ul class="star-rating">
								<li><a href="qualify.do?history.id=${id}&feedbackScore=0.2" class="one-star">1</a></li>
								<li><a href="qualify.do?history.id=${id}&feedbackScore=0.4" class="two-stars">2</a></li>
								<li><a href="qualify.do?history.id=${id}&feedbackScore=0.6" class="three-stars">3</a></li>
								<li><a href="qualify.do?history.id=${id}&feedbackScore=0.7" class="four-stars">4</a></li>
								<li><a href="qualify.do?history.id=${id}&feedbackScore=1.0" class="five-stars">5</a></li>																																
							</ul>								
						</td>
					</tr>
				</ww:iterator>							
			</tbody>	
		</table>
		<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>
		
	</body>
</html>