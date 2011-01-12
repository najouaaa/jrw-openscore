<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="org.jredway.model.BaseUtilisateur"%>

<%

BaseUtilisateur membre = new BaseUtilisateur();

%>

<% if (membre.existe() == false) { %>

<div id="inscrit">

	<h2>Creation de votre compte:</h2>
	
		<form method="post" action="/openscore/creerprofile">

			<label for="nom">Nom:</label> <input type="text" name="nomVide" /> <br /><br />
	
			<label for="prenom">Prénom:</label> <input type="text" name="prenomVide" /> <br /><br />
	
			<label for="index">Index:</label> <input type="text" name="indexVide" /> <br /><br />
	
			<input type="submit" value="Sauvegarder" id="sauve"/>

		</form>

</div>

<% } else { %>

<div id="inscrit">
	
	<h2>Modifier vos informations personnelles:</h2>
	
	<form method="post" action="/openscore/modifierprofile">

		<label for="nom">Nom:</label> <input type="text" name="nom" value="<%=membre.getUtilisateur().getNom()%>"/> <br /><br />
	
		<label for="prenom">Prénom:</label> <input type="text" name="prenom" value="<%=membre.getUtilisateur().getPrenom()%>"/> <br /><br />
	
		<label for="index">Index:</label> <input type="text" name="index" value="<%=membre.getUtilisateur().getIndex()%>"/> <br /><br />
	
		<input type="submit" value="Sauvegarder" id="sauve"/>

	</form>

</div>

<% } %>