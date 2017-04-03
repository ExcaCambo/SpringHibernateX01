<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.aeugold.model.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring to GOLD</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/css/style.css">
</head>
<body>
<center>
	<h1>Welcome ADMIN</h1>
	<%-- <%
		ArrayList<User> user = (ArrayList)request.getAttribute("DATA");
		for(User u : user){
			out.print("<br> - ID " + u.getId() + " NAME " + u.getUsername());
		}
	%> --%>
</center>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/js/script.js"></script>
</body>
</html>