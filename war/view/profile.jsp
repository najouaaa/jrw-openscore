<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:useBean id="label" class="org.jredway.bean.ProfileBean" />
<c:catch>
	<jsp:useBean id="uti" class="org.jredway.bean.UtilisateurBean" />
</c:catch>

<c:choose>
	
	<c:when test="${uti.existe}">
		
		<div id="inscrit">
	
			<h2><jsp:getProperty name="label" property="titreModifier"/></h2>
	
				<form method="post" action="/openscore/modifierprofile">
					<jsp:getProperty name="label" property="nom"/><input type="text" name="nom" value="${uti.nom}"/><br/><br/>
					<jsp:getProperty name="label" property="prenom"/><input type="text" name="prenom" value="${uti.prenom}"/><br/><br/>
					<jsp:getProperty name="label" property="index"/><input type="text" name="index" value="${uti.index}"/><br/><br/>
					<input type="submit" value="Sauvegarder" id="sauve"/>
				</form>

		</div>
		
	</c:when>
	
	<c:otherwise>
	
		<div id="inscrit">
	
			<h2><jsp:getProperty name="label" property="titreCreation"/></h2>
	
				<form method="post" action="/openscore/creerprofile">
					<jsp:getProperty name="label" property="nom"/><input type="text" name="nomVide"/><br/><br/>
					<jsp:getProperty name="label" property="prenom"/><input type="text" name="prenomVide"/><br/><br/>
					<jsp:getProperty name="label" property="index"/><input type="text" name="indexVide"/><br/><br/>
					<input type="submit" value="Sauvegarder" id="sauve"/>
				</form>

		</div>
	
	</c:otherwise>
	
</c:choose>