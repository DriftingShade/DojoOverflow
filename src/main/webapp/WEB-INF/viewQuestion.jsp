<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Question</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
</head>
<body>
	<div class="container mx-auto w-75 text-center">
		<h1>${question.text}</h1>
		<h3 class="my-3">Tags:
			<c:forEach var="tag" items="${question.tags}">
				<button class="btn btn-primary">${tag.subject}</button>
			</c:forEach>
		</h3>
		
		<hr />
		<div class="main mx-auto w-75 text-center">
			<h3>Answers:</h3>
			<c:forEach var="answer" items="${question.answers}">
				<ul>
					<li>${answer.text}</li>
				</ul>
			</c:forEach>
			<hr />
			<form:form action="/questions/${question.id}/answers/new" modelAttribute="answer" method="post">
				<form:label for="text" class="form-control" path="text">Answer:</form:label>
				<form:errors path="text" class="form-control"></form:errors>
				<form:textarea path="text" rows="4" class="form-control"></form:textarea>
				<br />
				<button type="submit" class="btn btn-primary my-3">Submit</button>
			</form:form>
		</div>
		<a href="/" class="btn btn-primary my-5">Dashboard</a>
	</div>
</body>
</html>