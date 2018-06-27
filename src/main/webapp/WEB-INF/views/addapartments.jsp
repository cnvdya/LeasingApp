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
            <div class="row">
                <div class="col-sm-9">
                    <h2>Add Apartmentment</h2>
                </div>
                <div class="col-sm-3">
                    <button class="btn btn-primary" type="submit" onclick="location.href='/'">Home page</button>
                </div>
            </div>
            <form:form method="POST" action="${pageContext.request.contextPath}/saveapartment" modelAttribute="apartmentvo" >
                <div class="form-group">
                    <form:label path="apartmentName">Apartment Name</form:label>
                    <form:input type="text" class="form-control" path="apartmentName" placeholder="Enter apartment name"/>
                </div>
                <div class="form-group">
                    <form:label path="adressLine1">Address Line 1</form:label>
                    <form:input type="text" class="form-control" path="adressLine1" placeholder="Enter address line 1"/>
                </div>
                <div class="form-group">
                    <form:label path="adressLine2">Address Line 2</form:label>
                    <form:input type="text" class="form-control" path="adressLine2" placeholder="Enter address line 2"/>
                </div>
                <div class="form-group">
                    <form:label path="city">City</form:label>
                    <form:input type="text" class="form-control" path="city" placeholder="Enter city"/>
                </div>
                <div class="form-group">
                    <form:label path="state">State</form:label>
                    <form:input type="text" class="form-control" path="state" placeholder="Enter state"/>
                </div>
                <div class="form-group">
                    <form:label path="country">Country</form:label>
                    <form:input type="text" class="form-control" path="country" placeholder="Enter country name"/>
                </div>
                <div class="form-group">
                    <form:label path="code">Zip Code</form:label>
                    <form:input type="text" class="form-control" path="code" placeholder="Enter zip code"/>
                </div>
                <input type="submit" class="btn-primary" value="Add Apartment"/>
            </form:form>
        </div>

        <script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
