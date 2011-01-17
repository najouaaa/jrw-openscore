<?xml version="1.0" encoding="utf-8" ?>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:useBean id="label" class="org.jredway.bean.DeconnexionBean"/>

<div id="deconnexion">

	<p><jsp:getProperty name="label" property="question"/></p>
	
	<form method="post" action="/openscore/deconnexion">
		<input type="submit" value="${label.bouton}" id="confirm" />
	</form>
	
</div>