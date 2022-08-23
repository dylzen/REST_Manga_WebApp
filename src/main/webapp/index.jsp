<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libreria</title>
</head>
<body>
<h1>Libreria</h1>
<a href="aggiungi_manga.jsp">Aggiungi un manga</a>
<br><br>
<a href="<%=request.getContextPath()%>/MangaController?flag=mostraManga">Mostra tutti i manga</a>

</body>
</html>