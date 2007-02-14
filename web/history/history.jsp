<%@ taglib prefix="ww" uri="/webwork" %>
<html>
	<head>
		<title>Histórico de pesquisa</title>
		<ww:head />
		<script type="text/javascript">
			function qualify(id, feedbackScore) {
				window.alert("qualify.do?history.id=" + id + "&history.feedbackScore=" + feedbackScore);
				window.location = "qualify.do?history.id=" + id + "&history.feedbackScore=" + feedbackScore;
			}
		</script>
	</head>
	<body>
		
		<h1>Histórico de pesquisa</h1>
		
		<div>
			<ww:iterator value="histories">
				<a href="<ww:property value="url" />"><ww:property value="title" /></a>
				
				<a href="#" onclick="javascript:qualify(${id}, 0.2);">1</a>
				<a href="#" onclick="javascript:qualify(${id}, 0.4);">2</a>
				<a href="#" onclick="javascript:qualify(${id}, 0.6);">3</a>
				<a href="#" onclick="javascript:qualify(${id}, 0.8);">4</a>
				<a href="#" onclick="javascript:qualify(${id}, 1.0);">5</a>
				
				<br />
			</ww:iterator>
		</div>
		
	</body>
</html>