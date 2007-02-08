<%@ taglib prefix="ww" uri="/webwork" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%
	request.setAttribute("root", request.getContextPath());
%>
<html>
	<head>
		<title>BIPWeb - <decorator:title /></title>
		<style type="text/css">
			@import url("${root}/css/default.css");
		</style>
		<decorator:head />
	</head>
	<body>
		
		<div id="cabecalho">
		
			<h1>
				<b><a href="${root}">BIPWeb</a></b>
				Uma ferramenta de busca de informações personalizadas na Web baseada no Fidus.
			</h1>
			
			<ul>
			<ww:if test="${user}">
				<li>Pesquisar</li>
				<li>Histórico de pesquisa</li>
				<li>Gerenciar categorias</li>
			</ww:if>
			<ww:else>
				<li><a href="${root}/user/login.jsp">Entrar</a></li>
				<li><a href="${root}/user/edit.jsp">Cadastre-se</a></li>
			</ww:else>
				<li><a href="${root}/help/help.jsp">Ajuda</a></li>
			</ul>
			
		</div>
		
		<div id="corpo">
			<decorator:body />
		</div>
		
	</body>
</html>