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
    <form:form method="POST" action="${pageContext.request.contextPath}/saveFlat" modelAttribute="flatVO" enctype="multipart/form-data">
        <div class="form-group">
            <div class="row">
                <div class="col-sm-5">
                    <form:label path="apartment.id">Flat Number</form:label>
                </div>
                <div class="col-sm-7">
                   

                <input type="text" class="form-control"  value="${apartmentid}" disabled="disabled" />
                    <form:input type="hidden" class="form-control" path="apartment.id" value="${apartmentid}" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <form:label path="flatName">Flat Name</form:label>
            <form:input type="text" class="form-control" path="flatName" placeholder="Enter flat name"/>
        </div>
        <div class="form-group">
            <form:label path="details">Flat Details</form:label>
            <form:textarea class="form-control" path="details" placeholder="Enter flat details"/>
        </div>
        <div class="form-group">
            <form:label path = "images">Flat Images</form:label>
            <form:input type="file" class="form-control" path = "images" name ="images" multiple = "multiple"/>
        </div>
        <div class="form-group">
            <form:label path="type">Flat type</form:label>
            <form:select path="type" >
                <form:option value="1-BHK" >1-BHK</form:option>
                <form:option value="2-BHK" >2-BHK</form:option>
                <form:option value="3-BHK" >3-BHK</form:option>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="price">Price/Rent</form:label>
            <form:input type="text" class="form-control" path="price" placeholder="Enter price for renting"/>
        </div>



        <input type="submit" class="btn-primary" value="Add Flat"/>
        <%--<button type="submit" class="btn btn-primary">Login</button>--%>
    </form:form>
</div>


<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
