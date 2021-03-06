<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Histórico de pesquisa</title>
		<style type="text/css">
			@import url("../css/stars.css");
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
		
		<h1>Histórico de pesquisa</h1>

		<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>			
		<table id="grid" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Documento</th>
					<th>Qualificação</th>
				</tr>
			</thead>
			<tbody>
				<ww:if test="histories.size() > 0">
					<ww:iterator value="histories">				
						<tr>
							<td><a target="_new" href="<ww:property value="url" />"><ww:property value="title" /></a></td>						
							<td>
								<ul class="star-rating">
									<ww:if test="feedbackScore < 0.2">
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.2" class="one-star">1</a></li>								
									</ww:if>
									<ww:else>
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.2" class="one-star-rated">1</a></li>								
									</ww:else>
									<ww:if test="feedbackScore < 0.4">
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.4" class="two-stars">2</a></li>								
									</ww:if>
									<ww:else>
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.4" class="two-stars-rated">2</a></li>								
									</ww:else>
									<ww:if test="feedbackScore < 0.6">
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.6" class="three-stars">3</a></li>								
									</ww:if>
									<ww:else>
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.6" class="three-stars-rated">3</a></li>								
									</ww:else>
									<ww:if test="feedbackScore < 0.8">
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.8" class="four-stars">4</a></li>								
									</ww:if>
									<ww:else>
										<li><a href="qualify.do?history.id=${id}&feedbackScore=0.8" class="four-stars-rated">4</a></li>								
									</ww:else>
									<ww:if test="feedbackScore < 1.0">
										<li><a href="qualify.do?history.id=${id}&feedbackScore=1.0" class="five-stars">5</a></li>								
									</ww:if>
									<ww:else>
										<li><a href="qualify.do?history.id=${id}&feedbackScore=1.0" class="five-stars-rated">5</a></li>								
									</ww:else>
								</ul>								
							</td>
						</tr>
					</ww:iterator>	
				</ww:if>
				<ww:else>
					<tr>
						<td colspan="2">Nenhum documento</td>
					</tr>
				</ww:else>										
			</tbody>	
		</table>
		<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>
		
	</body>
</html>