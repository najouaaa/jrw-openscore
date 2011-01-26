<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:useBean id="label" class="org.jredway.bean.CreationPartieBean" />

<div id="creation">

	<h1><jsp:getProperty name="label" property="titre"/></h1>
	
	<form action="/openscore/CreationPartie" method="get">
		<jsp:getProperty property="menu" name="label"/>
		<select name="parcours" id="parcours">
			<c:import url="/parcours/list.html"/>	
		</select>
		<br/>
		<br/>
		<jsp:getProperty property="menu" name="label"/>
		<select name="depart" id="depart">
			<option value="rouge"><jsp:getProperty property="cRouge" name="label"/></option>
			<option value="bleu"><jsp:getProperty property="cBleu" name="label"/></option>
			<option value="jaune"><jsp:getProperty property="cJaune" name="label"/></option>
			<option value="blanc"><jsp:getProperty property="cBlanc" name="label"/></option>
			<option value="noir"><jsp:getProperty property="cNoir" name="label"/></option>
		</select>
		<br/>
		<br/>
		<input type="submit" value="Suivant" class="jbouton"/>
	</form>

</div>