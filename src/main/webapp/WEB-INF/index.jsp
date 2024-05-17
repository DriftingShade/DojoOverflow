<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Dojo Overflow Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="main mx-auto w-75">
		<h1 class="text-center">Questions Dashboard</h1>
		
		<table class="table mx-auto align-center text-center">
			<thead>
				<tr>
					<th>Questions</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="question" items="${questions}">
					<tr>
						<td>
						<a href="/questions/${question.id}">${question.text}</a>
						</td>
					<c:forEach var="tag" items="${question.tags}">
						<td>${tag.subject}<c:if test = "${question.tags.indexOf(tag)<question.tags.size()-1}">, </c:if></td>
					</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3 class="text-center"><a href="/questions/new">New Question</a></h3>
	</div>
</body>
</html>