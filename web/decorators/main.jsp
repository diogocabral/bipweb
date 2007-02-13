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
				<li><a href="<ww:url action="load" namespace="/search" includeParams="none" />">Pesquisar</a></li>
				<li><a href="<ww:url action="load" namespace="/history" includeParams="none" />">Qualificações</a></li>
				<li><a href="<ww:url action="manage" namespace="/category" includeParams="none" />">Categorias</a></li>
				<li><a href="<ww:url action="load" namespace="/user" includeParams="none" />">Alterar senha</a></li>
				<li><a href="<ww:url value="/help/help.jsp" includeParams="none" />">Ajuda</a></li>
				<li><a href="<ww:url action="logout" namespace="/user" includeParams="none" />">Sair</a></li>
			</ww:if>
			<ww:else>
				<li><a href="<ww:url value="/" includeParams="none" />">Principal</a></li>
				<li><a href="<ww:url value="/user/login.jsp" includeParams="none" />">Entrar</a></li>				
				<li><a href="<ww:url value="/user/save.jsp" includeParams="none" />">Cadastre-se</a></li>				
				<li><a href="<ww:url value="/help/help.jsp" includeParams="none" />">Ajuda</a></li>
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