<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory, 
com.google.appengine.api.users.UserService,
com.google.appengine.api.users.User" 
%>

<% UserService userService = UserServiceFactory.getUserService(); %>

<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/layout/head.jsp"/>

<body>
	<div id="fenetre">

		<div id="saut">
			
		</div>
		
		<div id="page">
		
			<jsp:include page="/layout/menu.jsp"/>
		
			<div id="affichage">
				
				<div id="titre">
										
				</div>
			
				<% 
				
					String url = (String) request.getAttribute("page");
				
					try { %>
					    
					    <jsp:include page="<%=url%>"/>
					    
					<%} catch(Exception e) { %>
					    
					    <jsp:include page="/view/404.jsp"/>
					    
					<%} %>
				
				<!--  -->
				
			</div>
		
			<jsp:include page="/layout/footer.jsp"/>
		
		</div>
	
	</div>
	
</body>
</html>