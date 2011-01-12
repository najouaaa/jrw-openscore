<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory, 
com.google.appengine.api.users.UserService,
com.google.appengine.api.users.User" 
%>

<% UserService userService = UserServiceFactory.getUserService(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>openScore</title>
	<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
	<link type="text/css" rel="stylesheet" href="/stylesheets/style.css" />
	<link type="text/css" href="/js/css/start/jquery-ui-1.8.7.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="/js/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="/js/js/jquery-ui-1.8.7.custom.min.js"></script>
	<script type="text/javascript" src="/js/animation.js"></script>
</head>

<body>
	<div id="fenetre">

		<div id="saut">
			
		</div>
		
		<div id="page">
		
			<div id="menu">
				
				<div id="membre">
					
					<img id="mmd" src="/img/mmd.png"/> <br/><br/>	
					
					Bonjour : <span class="info"></span><br/><br/>
					
					> Club: <span class="info"></span><br/>
					> Index: <span class="info"></span><br/>
					> Dernière partie: <span class="info"></span><br/>
					
				</div>
			
				<div id="ssmenu">
			
					<h3><a href="#">PARTIE</a></h3>
			    	<div id="partie">
						<a href="ajouterPartie"><img id="img" src="/img/ajouter.png"/> Ajouter partie</a><br/><br/>
						<a href="chargerPartie"><img id="img" src="/img/charger.png"/> Charger partie</a><br/><br/>
						<a href="supprimerPartie"><img id="img" src="/img/supp.png"/> Supprimer partie</a><br/><br/>
					</div>
				
			    	<h3><a href="#">PROFILE</a></h3>
					<div id="profile">
						<br/><br/>
						<a href="/openscore?page=profile"><img id="img" src="/img/edit.png"/> Modifier profile</a><br/><br/>
						<a href="<%=userService.createLogoutURL("/openscore?page=bienvenue")%>" id="confirm"><img id="img" src="/img/deco.png"/> Déconnexion</a>
						<br/><br/>
					</div>
			
				</div>
				
				<div >
				<img src="/img/jrwlogo.png" alt="Powered by JRed Way" id="jrw"/>
				<img src="http://code.google.com/appengine/images/appengine-silver-120x30.gif" alt="Powered by Google App Engine" id="pub"/>
				</div>
			
			</div>
		
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
		
			<div id="pied">
			
			</div>
		
		</div>
	
	</div>
	
</body>
</html>