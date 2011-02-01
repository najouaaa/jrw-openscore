<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
		
<jsp:useBean id="label" class="org.jredway.bean.MenuBean"/>

			<div id="menu">
				
				<div id="membre">
				
					<c:catch var="off">
						<jsp:useBean id="uti" class="org.jredway.bean.UtilisateurBean"/>
					
						<img id="mmd" src="/img/mmd.png"/> <br/><br/>	
						<jsp:getProperty name="label" property="lBonjour"/><br/><br/>
						<jsp:getProperty name="label" property="lCompte"/> <span class="info"><jsp:getProperty name="uti" property="compte"/></span><br/>
						<jsp:getProperty name="label" property="lIndex"/> <span class="info"><jsp:getProperty name="uti" property="index"/></span><br/>
					</c:catch>
					
					<c:if test="${not empty off}">
						<img id="mmd" src="/img/mmd.png"/> <br/><br/>	
						<jsp:getProperty name="label" property="lBonjour"/><br/><br/>
						<jsp:getProperty name="label" property="lCompte"/> <span class="info"></span><br/>
						<jsp:getProperty name="label" property="lIndex"/> <span class="info"></span><br/>
						<jsp:getProperty name="label" property="lPartie"/> <span class="info"></span><br/>
					</c:if>
					
				</div>
				
				<div id="ssmenu">
			
					<h3><a href="#"><jsp:getProperty name="label" property="lTitrePartie"/></a></h3>
			    	<div id="partie">
						<a href="/openscore?page=creationPartie"><img class="img" src="/img/ajouter.png"/></a>
						<a href="/openscore?page=chargerPartie"><img class="img" src="/img/charger.png"/></a>
						<a href="/openscore?page=supprimerPartie"><img class="img" src="/img/supp.png"/></a>
					</div>
				
			    	<h3><a href="#"><jsp:getProperty name="label" property="lTitreProfile"/></a></h3>
					<div id="profile">
						<br/><br/>
						<a href="/openscore?page=profile"><img class="img"  src="/img/edit.png"/></a><br/><br/>
						<a href="/openscore?page=deconnexion"><img class="img"  src="/img/deco.png"/></a>
						<a href="#"><img class="img"  src="/img/nothing.png"/></a>
						<br/><br/>
					</div>
			
				</div>
				
				<div >
					<img src="http://code.google.com/appengine/images/appengine-silver-120x30.gif" alt="Powered by Google App Engine" id="pub"/>
				</div>
			
			</div>