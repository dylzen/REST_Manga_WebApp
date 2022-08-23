<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi manga</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/MangaController" method="post">
		Titolo del manga <input type="text" name="title" value="${manga.title}"><br>
		Autore del manga <input type="text" name="author" value="${manga.author}"><br>
		Prezzo del manga<input type="number" min="0" step="0.01" name="price" value="${manga.price}"><br>
		Volumi rilasciati<input type="number" name="volumes" value="${manga.volumes}"><br>
		Stato della serie<input type="text" name="releaseStatus" value="${manga.releaseStatus}"><br>
		<input type="hidden" name="mangaSeriesID" value="${manga.mangaSeriesID}"><br>
		<input type="submit" value="Aggiungi Manga">
	
	</form>

</body>
</html>