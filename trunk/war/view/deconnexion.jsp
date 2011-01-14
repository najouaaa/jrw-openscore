<?xml version="1.0" encoding="utf-8" ?>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory, 
com.google.appengine.api.users.UserService,
com.google.appengine.api.users.User" 
%>

<% 
UserService userService = UserServiceFactory.getUserService();
%>

<div id="deconnexion">
	<p>Voulez-vous vraiment vous déconnecter ?</p>
	<a href="<%=userService.createLoginURL(request.getRequestURI())%>" id="confirm">Déconnexion</a>
</div>