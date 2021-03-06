<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>EaseYourLease</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style/easeyourlease.css"/>
  
</head>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <img class="navbar-header-img" src="images/logo.jpeg" width="40" height="40"/>
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

<div class="container">
	<h3 align="right">Welcome ${userInfo.givenName} &nbsp;</h3>
	<hr>
	<div class="row">
		<%-- <div class="col-sm-9">
			<h1>Flats Images for ${flatName}</h1>
		</div> --%>
	</div>
</div>


<!-- Iterating through imageList to display images -->
<div class="row">

	<c:forEach var="img" items="${imagesList}">
		<div class="column">
			<img src="<c:out value="${img}"/>" style="width: 100%">
		</div>
	</c:forEach>

</div>


