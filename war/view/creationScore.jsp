<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<c:import url="./js/confirm/confirm.html" />

<jsp:useBean id="label" class="org.jredway.bean.CreationScoreBean" />

<div id="wrapSaisi">

	<span id="titre"></span>

	<form id="confirmS" name="confirmS" method="post" action="/openscore/CreationPartie">
		<input type="text" name="pParcours" id="pParcours" class="JHide"/>
		<input type="text" name="pDepart" id="pDepart" class="JHide"/>
		<table border="1" class="sample" id="tabAller">
			<c:forEach var="i" begin="0" end="9" step="1">
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
    					<td><input class="saisi" type="text" id="S${i}" name="S${i}"/></td>
  					</tr>
  				</c:if>
			</c:forEach>
		</table>
		<table border="1" class="sample" id="tabRetour">
			<c:forEach var="i" begin="10" end="18" step="1">
				<c:if test="${i==10}">
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
    					<td><input class="saisi" type="text" id="S${i}" name="S${i}"/></td>
  					</tr>
  				</c:if>
			</c:forEach>
		</table>
		<jsp:getProperty property="date" name="label"/>
		<select name="pJour" id="pJour">
			<c:forEach var="i" begin="1" end="31" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		<select name="pMois" id="pMois">
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		<select name="pAnnee" id="pAnnee">
			<c:forEach var="i" begin="1990" end="2011" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		<br/>
		<br/>
		<a href="/openscore?page=creationPartie" class="jbouton"><jsp:getProperty property="retour" name="label"/></a>
		<input type="submit" value="${label.sauve}" id="validerScore" class="jbouton"/>
	</form>
	
</div>