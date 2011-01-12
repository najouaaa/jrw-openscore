<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="org.jredway.model.BaseUtilisateur,
com.google.appengine.api.users.UserServiceFactory, 
com.google.appengine.api.users.UserService,
com.google.appengine.api.users.User,
javax.jdo.PersistenceManager,
javax.jdo.Query,
org.jredway.model.Utilisateur,
org.jredway.model.PMF" 
%>

<%

UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();

BaseUtilisateur membre = new BaseUtilisateur();
PersistenceManager pm = PMF.get().getPersistenceManager();

Query query = pm.newQuery(Utilisateur.class,":p.contains(compte)");

out.println("<p>"+membre.existe()+"</p>");
out.println(query.execute(user));
%>