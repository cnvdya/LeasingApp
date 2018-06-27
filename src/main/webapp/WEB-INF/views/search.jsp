<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="color" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>EaseYourLease</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style/easeyourlease.css"/>
    <%--<link rel="stylesheet" type="text/css" media="screen" href="style/slider.css">--%>
</head>

<body>

<%--<script>console.log('name passed to ui ${name}')</script>--%>

<%--<script>--%>
    <%--var currlabel="gym";--%>
    <%--console.log(currlabel);--%>
    <%--if('${curlabel}' != null ||'${curlabel}' != undefined ){--%>
        <%--console.log('${curlabel}');--%>
        <%--currlabel='${curlabel}';--%>
    <%--}--%>
    <%--function getlabelresult(label) {--%>
        <%--window.location.href="http://localhost:8080/alexadetectlabels?labelTag="+label;--%>
    <%--}--%>

    <%--function refresh() {--%>
        <%--var xhttp = new XMLHttpRequest();--%>
        <%--xhttp.open("GET", "https://gqlb8erss1.execute-api.us-east-1.amazonaws.com/prod", true);--%>
        <%--xhttp.send();--%>
        <%--xhttp.addEventListener("readystatechange", processRequest, false);--%>
        <%--console.log(currlabel);--%>
        <%--function processRequest(e) {--%>
            <%--console.log('starting process');--%>
            <%--if (xhttp.status == 200) {--%>
                <%--var response = JSON.parse(xhttp.responseText);--%>
                <%--console.log('response  ===== ' +response);--%>
                <%--var numberString = response.InklingPictures.toLowerCase();--%>
                <%--console.log('currlabel ======= '+currlabel);--%>
                <%--console.log('numberString ======= '+numberString);--%>
                <%--console.log('if value :');--%>

                <%--if(numberString!=(currlabel) ) {--%>
                    <%--console.log('came inside if');--%>
                    <%--currlabel=numberString;--%>
                    <%--getlabelresult(currlabel);}--%>
                <%--console.log(numberString);--%>
            <%--}--%>
        <%--}--%>
        <%--setTimeout(refresh, 5000);--%>
    <%--}--%>
    <%--refresh();--%>
<%--</script>--%>










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

    <div style="background-color: white"></div>
    <div class="row">
        <div class="col-sm-12">
            <h3 align="center">Finding Home Made Easy</h3>
        </div>
        <%--<div class="col-sm-6">--%>
            <%--<h3 align="right"> Welcome ${userInfo.givenName} &nbsp;</h3>--%>
        <%--</div>--%>


    </div>
    <hr>


    <div class="row">
        <div class="jumbotron">
            <form:form method="POST" action="${pageContext.request.contextPath}/searchApartment" modelAttribute="filter">
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="input-group" >
                                <span class="input-group-addon"><i class="glyphicon glyphicon-search" ></i></span>
                                <form:input id="search"  type="text" class="form-control input-lg" name="search" path="name" placeholder="Search"/>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <%--<button type="submit" class="form-control input-lg" color:grey>Bed&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                                <%--<i class="glyphicon glyphicon-triangle-bottom"></i>--%>
                            <%--</button>--%>
                                    <div class="input-group" >
                                    <%--<form:input id="type"  type="text" class="form-control input-lg" name="email" path="type" placeholder="Bed"/>--%>
                                        <form:select path="type" class="form-control input-lg"  placeholder="Bed" style="width:125%">
                                            <form:option value="">Select Bed</form:option>
                                            <form:option value="1-BHK">1-BHK</form:option>
                                            <form:option value="2-BHK">2-BHK</form:option>
                                            <form:option value="3-BHK">3-BHK</form:option>
                                        </form:select>
                                    </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="input-group" >
                                <form:input id="price"  type="text" class="form-control input-lg" name="Bed" path="price" placeholder="Price"/>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="input-group" >
                                <form:input id="amenities"  type="text" class="form-control input-lg" name="Bed" path="amenity" placeholder="Amenities"/>
                            </div>
                        </div>
                        <div class="col-sm-1">
                            <div class="input-group" >
                                <button type="submit" class="form-control input-lg">Go
                                    <%--<i class="glyphicon glyphicon-triangle-right"></i>--%>
                                <%--<input id="go"  type="Button" class="form-control input-lg" name="Bed"  value="Go">--%>
                                <%--<i class="glyphicon glyphicon-triangle-right"></i>--%>
                            </div>
                        </div>
                </div>

                    </div>
            </form:form>
        </div>
    </div>



    <div>


            <c:forEach items="${searchResults}" var="searchResult" >

                <div class="col-sm-12">

                        <div class="col-sm-7">
                            <table class="table table-hover">
                                <tr><td>Building : ${searchResult.apartmentName}</td></tr>
                                <tr><td>Apartment name: ${searchResult.flatName}</td></tr>
                                <tr><td>Address : ${searchResult.adressLine1} &nbsp;,${searchResult.adressLine2} &nbsp;,${searchResult.city} &nbsp;,${searchResult.state} &nbsp;,${searchResult.code}</td></tr>
                                <tr><td>Type : ${searchResult.type}</td></tr>
                                <tr><td>Rent : $ ${searchResult.price}</td></tr>
                                <tr><td>Details : ${searchResult.details} , ${searchResult.labels}</td></tr>
                                <tr align="center"><td><input type="button"  onclick="location.href='/flatDetails?flatId=${searchResult.flatId}'" value="view details" ></td></tr>
                            </table>
                        </div>
                        <div class="col-sm-5">
                            <table class="table table-hover">

                                <img src="<c:out value="${searchResult.imagepath}"/>" style="width: 100%">

                            </table>
                        </div>

                    </div>
                <hr>

            </c:forEach>
        <hr>
    </div>





    <div class="row">
        <div class="col-sm-5">
            <div class="jumbotron">
                <p>
                    <%--Living in a dream house is what a person works hard for and finding the same house which can--%>
                    <%--fulfill one&#180;s needs is not only hard but a tough job irrespective of how big or small city one--%>
                    <%--chooses to live in.</p><br>--%>
                    <%--<p>Property owners, on the other hand struggle in finding a suitable manager who can keep track--%>
                    <%--of their existing properties and publicize them. Trusting strangers to lend a place is not easy and--%>
                    <%--requires a series of categories of background checks making the whole process hectic and--%>
                    <%--messy one.<br><br>--%>
                    <%--So, eradicating some of the difficulties mentioned, we have come up with an Enterprise based--%>
                    <%--Solution --%>
                    <strong>EaseYourLease</strong>, is a Housing Property hosting platform where Property Managers can
                    more effectively market, manage and grow their business by hosting and posting about their
                    Housing Property which could be an Apartment or Student Housing or even a Community
                    Association.</p>
            </div>
        </div>

        <div class="col-sm-7">
            <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="images/slider-1.jpg" alt="Los Angeles" style="width:100%; height: 380px">
                    </div>

                    <div class="item">
                        <img src="images/slider-2.jpg" alt="Chicago" style="width:100%;height: 380px">
                    </div>

                    <div class="item">
                        <img src="images/slider-3.jpg" alt="New york" style="width:100%;height: 380px">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

    </div>

    <%--<div class="row">--%>
        <%--<div class="col-sm-7">--%>
            <%--<div class="jumbotron">--%>
                <%--<h3>Our Offices</h3>--%>
                <%--&lt;%&ndash;<img src="images/image1.png" alt="" height="150px" width="350px" align="center">&ndash;%&gt;--%>
                <%--<div class="row">--%>
                    <%--<div class="col-sm-4">--%>
                        <%--<ul class="list-1">--%>
                            <%--<li><a href="#">San Jose</a></li>--%>
                            <%--<li><a href="#">San Francisco</a></li>--%>
                            <%--<li><a href="#">Santa Clara</a></li>--%>
                            <%--<li><a href="#">Milpitas</a></li>--%>
                            <%--<li><a href="#">Mountain View</a></li>--%>
                            <%--<li><a href="#">Palo Alto</a></li>--%>
                            <%--&lt;%&ndash;<li><a href="#">Palo Alto</a></li>&ndash;%&gt;--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-4">--%>
                        <%--<img src="images/image1.png" alt="" height="150px" width="350px" align="center">--%>
                        <%--&lt;%&ndash;<ul class="list-1 last">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;<li><a href="#">Mountain View</a></li>&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<li><a href="#">Santa Clara</a></li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<li><a href="#">Milpitas</a></li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--&lt;%&ndash;<div class="lists">&ndash;%&gt;--%>
            <%--</div>--%>
        <%--</div>--%>


        <%--<div class="col-sm-5">--%>
            <%--<div class="jumbotron">--%>
                <%--<h3>Search Tenant</h3>--%>
                <%--<div class="form-group">--%>
                    <%--<label>Enter Tenant ID</label>--%>
                    <%--<input type="text" placeholder="Enter tenant ID"/>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="button" class="btn-primary btn-group-sm" value="Submit" align="center">--%>
                <%--</div>--%>

                <%--<br>--%>
                <%--<br>--%>
                <%--<div align="center">--%>
                    <%--<a href=${'apartments'}>Go to Apartment List</a>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>
    <%--<h2>Carousel Example</h2>--%>





</div>
<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
