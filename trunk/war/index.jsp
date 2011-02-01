<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<%
String url = (String) request.getAttribute("page");
%>

<jsp:include page="/layout/head.jsp"/>

<html xmlns="http://www.w3.org/1999/xhtml">

<body>

	<div id="fenetre">

		<div id="saut">
		</div>
		
		<div id="page">
			
			<jsp:include page="/layout/menu.jsp"/>
		
			<div id="affichage">
				
				<div id="titre">						
				</div>
				
				<jsp:include page="<%=url%>"/>
								
			</div>
		
		</div>
	
	</div>
	
	<jsp:include page="/layout/footer.jsp"/>
	
</body>

</html>