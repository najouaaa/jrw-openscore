<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<jsp:useBean id="label" class="org.jredway.bean.CreationScoreBean" />

<div id="wrapSaisi">

	<span id="titre"></span>

	<form method="post">
		<table border="1" class="sample">
			<c:forEach var="i" begin="0" end="18" step="1">
				<c:if test="${i==0}">
					<tr>
    					<td class="N"><span id=""><jsp:getProperty property="trou" name="label"/></span></td>
    					<td class="P"><span id=""><jsp:getProperty property="par" name="label"/></span></td>
    					<td class="H"><span id=""><jsp:getProperty property="hcp" name="label"/></span></td>
    					<td class="D"><span id=""><jsp:getProperty property="distance" name="label"/></span></td>
    					<td><span id=""><jsp:getProperty property="score" name="label"/></span></td>
  					</tr>
				</c:if>
				<c:if test="${i>0}">
  					<tr>
    					<td class="N"><span id="N${i}"></span></td>
    					<td class="P"><span id="P${i}"></span></td>
    					<td class="H"><span id="H${i}"></span></td>
    					<td class="D"><span id="D${i}"></span></td>
    					<td><input class="saisi" type="text" name="S${i}"/></td>
  					</tr>
  				</c:if>
			</c:forEach>
		</table>
		<a href="/openscore?page=creationPartie" class="jbouton"><jsp:getProperty property="retour" name="label"/></a>
		<input type="submit" value="${label.sauve}" class="jbouton"/>
	</form>
	
</div>