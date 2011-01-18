<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<div>

	<h3></h3>
	
	<c:forEach var="i" begin="0" end="7" step="1">
  		<tr>
    		<td><c:out value="${i}"/></td>
    		<td><c:out value="${i * i * i}"/></td>
  		</tr>
	</c:forEach>
	
</div>