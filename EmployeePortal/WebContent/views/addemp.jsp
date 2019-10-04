<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "spr"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<title>Employee Portal</title>
</head>
<body>
	<div class="container"> 
		<br>
		<h2 class="text-center">Add Employee</h2>
		<br>
		<spr:form method = "POST" modelAttribute="emp" action = "/EmployeePortal/registeremp">
			
			<label><b>First Name</b></label>
	        <spr:input type="text" path = "firstName" placeholder= "First Name" class="from form-control"></spr:input> <br/>
	        <label><b>Last Name</b></label>
	        <spr:input type="text" path = "lastName" placeholder= "Last Name" class="from form-control"></spr:input> <br/>
	        <label><b>Age</b></label>
	        <spr:input type="text" path = "age" placeholder="Age" class="from form-control"></spr:input>   <br/>
	        <label><b>Present Address</b></label>
	        <spr:input type="text" path= "presentAddress" placeholder= "Address" class="from form-control"></spr:input> <br/>
	        <label><b>Project Name</b></label> 
	        <spr:input type="text" path= "projName" placeholder= "Project Name" class="from form-control"></spr:input> <br/>
	        <label><b>Project Duration</b></label>
	        <spr:input type="text" path= "projDuration" placeholder= "Project Duration" class="from form-control"></spr:input> <br/>
	        <label><b>Project Status</b></label>
	        <spr:input type="text" path= "status" placeholder= "Project Status" class="from form-control"></spr:input> <br/> 
	        <input type = "submit" value = "Add" class="btn btn-success">
	        
      	</spr:form>
	</div>

</body>
</html>