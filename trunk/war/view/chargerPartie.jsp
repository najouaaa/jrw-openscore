<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:useBean id="label" class="org.jredway.bean.SupprimerPartieBean" />
<jsp:useBean id="clabel" class="org.jredway.bean.ChargementBean" />

<div id="chargement">

	<h2><jsp:getProperty property="titre" name="clabel"/></h2>
	<form action="/openscore/ChargerPartie" method="post">
		<select name="pKey">
			<jsp:getProperty property="parcours" name="label"/>
		</select>
		<br/>
		<br/>
		<input type="submit" Value="${clabel.bouton}" class="jbouton"/>
	</form>	

</div>
