<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ page import="org.jredway.tools.JDate" 
%>

<%
JDate test = new JDate(10,03,1991);

out.println(test.toString());
out.println(test.toDate());
out.println(test.toInt());

%>