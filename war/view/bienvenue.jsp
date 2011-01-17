<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="label" class="org.jredway.bean.BienvenueBean"/>

<div id="bienvenue">

	<h1><jsp:getProperty name="label" property="titre" /></h1>
	<p><jsp:getProperty name="label" property="message" /></p>
	<img id="" src="/img/gg.png"/>
	
</div>