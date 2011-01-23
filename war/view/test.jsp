<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="org.jredway.model.BaseParcours,
com.google.appengine.api.users.User,
com.google.appengine.api.users.UserService,
com.google.appengine.api.users.UserServiceFactory" 
%>

<%
UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();

BaseParcours test = new BaseParcours();
int trou[] = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18};
//test.ajouter(user, "chassieu", "jaune", trou);
%>