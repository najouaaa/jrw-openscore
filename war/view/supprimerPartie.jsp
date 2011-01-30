<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="label" class="org.jredway.bean.SupprimerPartieBean" />
    
<div id="suppression">

	<h2><jsp:getProperty property="titre" name="label"/></h2>
	<form action="/openscore/SupprimerPartie" method="post">
		<select name="pKey">
			<jsp:getProperty property="parcours" name="label"/>
		</select>
		<br/>
		<br/>
		<input type="submit" Value="${label.bouton}" class="JBouton"/>
	</form>	
	
</div>