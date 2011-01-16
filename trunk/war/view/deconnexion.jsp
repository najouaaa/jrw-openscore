<?xml version="1.0" encoding="utf-8" ?>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory, 
com.google.appengine.api.users.UserService" 
%>

<jsp:useBean id="label" class="org.jredway.bean.DeconnexionBean"/>

<% 
UserService userService = UserServiceFactory.getUserService();
%>

<div id="deconnexion">
	<p><jsp:getProperty name="label" property="question"/></p>
	<a href="<%=userService.createLoginURL(request.getRequestURI())%>" id="confirm">
		<jsp:getProperty name="label" property="bouton"/>
	</a>
</div>