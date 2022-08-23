<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
	pageEncoding="ISO-8859-15"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libreria</title>
</head>
<body>
	<br>
	<table style="width:100%" rules="all" >
		<tr>
			<th>Titolo</th>
			<th>Autore</th>
			<th>Volumi</th>
			<th>Prezzo</th>
			<th>Stato</th>
		</tr>
		<c:forEach items="${mangas}" var="manga">
			<tr>
				<td align="center" style="width:20%">${manga.title}</td>
				<td align="center">${manga.author}</td>
				<td align="center">${manga.volumes}</td>
				<td align="center">¤${manga.price}</td>
				<td align="center">${manga.releaseStatus}</td>
				<%-- <td><a
					href="<%=request.getContextPath()%>/MangaController?flag=modificaManga&mangaSeriesID=${manga.mangaSeriesID}">modifica</a></td> --%>
				<td align="right"><a
					href="<%=request.getContextPath()%>/MangaController?flag=eliminaManga&mangaSeriesID=${manga.mangaSeriesID}">elimina</a></td>
			</tr>
		</c:forEach>
	</table> 
	<div style="width:100%; text-align:center;">
		<a href="aggiungi_manga.jsp">Aggiungi manga</a>
		<br><br>
		<a href="index.jsp">Vai alla homepage</a>
	</div>
</body>
</html>