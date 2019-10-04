<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Employee Portal</title>
</head>
<body>
	<div class="container">
		<br>
		<h2 class="text-center">Employee Details</h2>
		<br>
		<table class="table table-bordered">
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>Project</th>
				<th>Project Duration</th>
				<th>Project Status</th>
				<th colspan="2">Operation</th>
			</tr>
		    <c:forEach items="${emplist}" var="el">
		    <tr>
		        <c:forEach items="${el}" var="el2">
		        	<td>${el2}</td>
		   		</c:forEach>
		   		<td><a href="editemp/${el[0]}" class="btn btn-primary">EDIT</a></td>
		        	<td><a href="deleteemp/${el[0]}" class="btn btn-danger">DELETE</a></td>
		   	</tr>	
		    </c:forEach>
		</table>
	</div>
</body>
</html>