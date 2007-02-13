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
		
			<a href="${root}/"><img border="0" src="${root}/images/logo.jpg" alt="BipWeb" /></a>
			
			<b class="menurtop"><b class="menur1"></b><b class="menur2"></b><b class="menur3"></b><b class="menur4"></b></b>
			<ul>
			<ww:if test="#session.user != null">
				<div style="position: absolute; right: 100px; top: 120px;"><b>Usuário: <ww:property value="#session.user.username" /></b></div>
				<li><a href="${root}/search/load.do">Pesquisar</a></li>
				<li><a href="${root}/history/load.do">Qualificações</a></li>
				<li><a href="${root}/category/manage.do">Categorias</a></li>
				<li><a href="${root}/user/load.do">Alterar senha</a></li>
				<li><a href="${root}/help/help.jsp">Ajuda</a></li>
				<li><a href="${root}/user/logout.do">Sair</a></li>
			</ww:if>
			<ww:else>
				<li><a href="${root}/">Principal</a></li>			
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
		<b class="menurbottom"><b class="menur4"></b><b class="menur3"></b><b class="menur2"></b><b class="menur1"></b></b>			
		
	</body>
</html>