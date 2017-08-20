<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customers</title>

<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

<div id="wrapper">
<div id="header">
<h2>CRM - Customer Relationship Manager </h2>
</div>
</div>
<br/>


<div id="content">

<input type="button" value="Add Customer" onclick="window.location.href='ShowformAdd' ; return false;" class="add-button"/>

<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>
</tr>


<c:forEach var="tmpCustomer" items="${customers}">


<!--  Construct the update Action using the id column  -->
<c:url var="updatelink" value="/customer/showformforupdate">

<c:param name="customerID" value="${tmpCustomer.id}"></c:param>

</c:url>


<!-- delete -->

<c:url var="deletelink" value="/customer/delete">

<c:param name="customerID" value="${tmpCustomer.id}"></c:param>

</c:url>


<tr>

<td>${tmpCustomer.firstname}</td>
<td>${tmpCustomer.lastname}</td>
<td>${tmpCustomer.email}</td>
<td> <a href="${updatelink}">Update</a>
 | 
<a href="${deletelink}" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete </a>
</td>

</tr>

</c:forEach>
</table>


</div>

<div  style="clear: both;" ></div>
<p>
<a href="${pageContext.request.contextPath}/resources/js/restClient.html"> Restfull Service Page</a>

</p>



</body>
</html>