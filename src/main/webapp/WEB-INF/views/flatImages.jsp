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
    <div class="row">
        <div class="col-sm-9">
            <h3>Flats Details for flat  ${searchResult.flatName} in ${searchResult.apartmentName}</h3>
        </div>
        <div class="col-sm-3" align="right" margin-top="20">
            <button type="submit" class="btn" onclick="location.href='/'">Back&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <i class="glyphicon glyphicon-triangle-left"></i>
            </button>
                <%--<input type="button"  onclick="location.href='/'" value="Back" >--%>
            <%--</div>--%>
        </div>
    </div>
	<hr>


    <!-- Iterating through imageList to display images -->
    <div class="row">
        <div class="col-sm-12" align="center">
        <c:forEach var="img" items="${images}">

                <img src="<c:out value="${img}"/>" width="300" height="250">


        </c:forEach>
        </div>

    </div>

    <br />
    <hr>
    <br />

    <table class="table table-hover">
        <tr><td>Building : ${searchResult.apartmentName}</td></tr>
        <tr><td>Apartment name: ${searchResult.flatName}</td></tr>
        <tr><td><b>Address :</b> ${searchResult.adressLine1} &nbsp;,${searchResult.adressLine2} &nbsp;,${searchResult.city} &nbsp;,${searchResult.state} &nbsp;,${searchResult.code}</td></tr>
        <tr><td><b>Type :</b> ${searchResult.type}</td></tr>
        <tr><td><b>Rent :</b> $ ${searchResult.price}</td></tr>
        <tr><td><b>Availibility:</b> ${flat.availability=='false'?'Not Available' : 'Available'}</td></tr>
        <tr><td><b>Details :</b> ${searchResult.details} , ${searchResult.labels}</td></tr>

    </table>

    <div align="right">
        <input type="button"  onclick="location.href='/'" value="Back" >
    </div>



</div>



<%-- <form class="sa-innate-form" action="detectlabels.do" method="post">
  <div class=”form-group”>
  <button type="submit" style="width: 50%; font-size:1.1em;" >
  <b><font color="">Detect Labels</font></b></button>
  </div>
  </form> --%>


