<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<%@ page import="com.google.appengine.api.datastore.KeyFactory;"%>

<c:import url="./js/confirm/confirm-c.html" />

<jsp:useBean id="affiche" class="org.jredway.bean.ChargerPartieBean" />
<jsp:setProperty property="pKey" name="affiche" value='<%=KeyFactory.stringToKey((String) request.getParameter("pKey")) %>'/>

<div id="wrapSaisi">

	<jsp:getProperty property="affichageParcours" name="affiche"/>
	
</div>