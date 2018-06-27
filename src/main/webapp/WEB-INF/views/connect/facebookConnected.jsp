
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>EaseYourLease</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style/easeyourlease.css"/>
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
    <br><br><br><br><br><br><br><br>
    <div class="row">
    <div class="col-sm-12" align="center">
        <label>Following message will be posted on facebook:</label>
    </div>
    </div>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-7" align="center">
            <textarea class="form-control">
                We have Apartments available for rent at affordable prices.
                Please contact +1*******332 for more information</textarea>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-12" align="center">
        <button class="btn btn-primary" type="submit" onclick="location.href='/facebookconnect'">Confirm Post</button>
        </div>
    </div>
    <br>
    <br>
    <%--<div align="center">--%>
        <%--<a href=${'apartments'}>Back to Apartment List</a>--%>
    </div>
</div>
<br>



</div>
<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>