<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<<jsp:useBean id="label" class="org.jredway.bean.ErreurBean"/>

<div id="erreur">

	<h1><jsp:getProperty name="label" property="titre"/></h1>
	<p><jsp:getProperty name="label" property="message"/></p>
	<a href="/openscore"><jsp:getProperty name="label" property="bouton"/></a>

</div>