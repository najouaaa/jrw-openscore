<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="org.jredway.model.BaseParcours,
org.jredway.openscore.OpenScoreServlet,
com.google.appengine.api.users.User,
com.google.appengine.api.users.UserService,
com.google.appengine.api.users.UserServiceFactory,
java.util.ArrayList,
java.util.logging.Logger,
java.util.Date" 
%>

<%
Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();


%>