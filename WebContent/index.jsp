<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório</title>
</head>
<body>
	<div align="center">
	<c:if test="${not empty erro}">
	<h2><c:out value="${erro}"/>
	</c:if>
	<form action="relatorio" method="post" >
	<table>
		<tr>
			<td><input type="text" name="rua"
					placeholder="RUA">
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Gerar">
			</td>
		</tr>				
			</table>
			</form>
			</div>

</body>
</html>

