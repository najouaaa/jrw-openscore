<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<%@ page import="org.jredway.model.BaseUtilisateur" %>

<jsp:useBean id="label" class="org.jredway.bean.ProfileBean" />

<%
BaseUtilisateur membre = new BaseUtilisateur();
%>

<c:choose>
	
	<c:when test="<%=!membre.existe()%>">
		
		<div id="inscrit">
	
			<h2><jsp:getProperty name="label" property="titreCreation"/></h2>
	
				<form method="post" action="/openscore/creerprofile">

					<jsp:getProperty name="label" property="nom"/><input type="text" name="nomVide"/><br/><br/>
	
					<jsp:getProperty name="label" property="prenom"/><input type="text" name="prenomVide"/><br/><br/>
	
					<jsp:getProperty name="label" property="index"/><input type="text" name="indexVide"/><br/><br/>
	
					<input type="submit" value="Sauvegarder" id="sauve"/>

				</form>

		</div>
		
	</c:when>
	
	<c:otherwise>
	
		<div id="inscrit">
	
			<h2><jsp:getProperty name="label" property="titreModifier"/></h2>
	
			<form method="post" action="/openscore/modifierprofile">

				<jsp:getProperty name="label" property="nom"/><input type="text" name="nom" value="<%=membre.getUtilisateur().getNom()%>"/><br/><br/>
	
				<jsp:getProperty name="label" property="prenom"/><input type="text" name="prenom" value="<%=membre.getUtilisateur().getPrenom()%>"/><br/><br/>
	
				<jsp:getProperty name="label" property="index"/><input type="text" name="index" value="<%=membre.getUtilisateur().getIndex()%>"/><br/><br/>
	
				<input type="submit" value="Sauvegarder" id="sauve"/>

			</form>

		</div>
	
	</c:otherwise>
	
</c:choose>