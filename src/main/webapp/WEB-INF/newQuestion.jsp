<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Ask A Question</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container mx-auto w-75 text-center">
		<h1>Ask A Question</h1>
		<div class="form-control">
			<form:form action="/questions/new" modelAttribute="question" method="post">
				<form:label for="text" class="form-control" path="text">Question:</form:label>
				<form:errors path="text" class="form-control"></form:errors>
				<form:textarea rows="4" path="text" class="form-control"></form:textarea>
				
				<label for="listOfTags">Tags:</label>
				<input class="input" name="listOfTags" id="listOfTags" />
				<button type="submit" class="btn btn-primary my-3">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>