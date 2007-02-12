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
				Uma ferramenta de busca de informa��es personalizadas na Web.
			</h1>
			
			<ul>
			<ww:if test="#session.user != null">
				<li><b><ww:property value="#session.user.username" /></b></li>
				<li><a href="${root}/search/search.jsp">Pesquisar</a></li>
				<li><a href="${root}/search/history.jsp">Hist�rico de pesquisa</a></li>
				<li><a href="${root}/category/manage.do">Gerenciar categorias</a></li>
				<li><a href="${root}/user/load.do">Minha Conta</a></li>			
				<li><a href="${root}/help/help.jsp">Ajuda</a></li>
				<li><a href="${root}/user/logout.do">Sair</a></li>
			</ww:if>
			<ww:else>
				<li><a href="${root}/user/login.jsp">Entrar</a></li>
				<li><a href="${root}/user/save.jsp">Cadastre-se</a></li>
				<li><a href="${root}/help/help.jsp">Ajuda</a></li>
			</ww:else>
			</ul>
			
		</div>
		
		<div id="corpo">
			<decorator:body />
		</div>
		
		<div id="rodape" align="center">
			&copy; 2007 BIPWeb
		</div>
		
	</body>
</html>