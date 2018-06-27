<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>EaseYourLease</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>

<body>
<%--navbar begin--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <img class="navbar-header-img" src="images/logo.jpeg" width="40" height="40">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Ease Your Lease</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href=${'easeyourlease'}>Home</a></li>
            <li><a href=${'apartments'}>Apartment List</a></li>
            <li><a href="https://public.tableau.com/profile/mudrita#!/vizhome/ApartmentAvailibility/Sheet1?publish=yes" target="_blank">Reports</a></li>
            <li><a href="http://localhost:7070" target="_blank">Jenkins</a></li>
            <li><a href=${'contactus'}>Contact US</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<%--navbar end--%>


<div class="container">
    <h2>Tenant's Details</h2>
    <form:form method="POST" action="${pageContext.request.contextPath}/confirmtenant" modelAttribute="tenant" >
    <div class="form-group">

        <div class="row">
            <div class="col-sm-5">
                <form:label path="flatid">Flat Number</form:label>
            </div>
            <div class="col-sm-5">
                <input type="text" class="form-control"  value="${flatName}" disabled="true" />
                <form:input type="hidden" class="form-control" path="flatid" value="${flatid}" />
            </div>
        </div>
    </div>
        <div class="form-group">
            <form:label path="firstName">First Name</form:label>
            <form:input type="text" class="form-control" path="firstName" placeholder="Enter first name"/>
        </div>
        <div class="form-group">
            <form:label path="lastName">Last Name</form:label>
            <form:input type="text" class="form-control" path="lastName" placeholder="Enter last name"/>
        </div>
        <div class="form-group">
            <form:label path="rentDate">Start Date</form:label>
            <form:input type="text" class="form-control" path="rentDate" placeholder="Enter start ldate"/>
        </div>
        <div class="form-group">
            <form:label path="contact">Contact Number</form:label>
            <form:input type="text" class="form-control" path="contact" placeholder="Enter contact number"/>
        </div>


        <input type="submit" class="btn-primary" value="Confirm"/>
        <%--<button type="submit" class="btn btn-primary">Login</button>--%>
    </form:form>
</div>


<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
