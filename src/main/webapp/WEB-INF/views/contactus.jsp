<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

    <div style="background-color: white"></div>
    <div class="row">
        <div class="col-sm-6">
            <h3>Contact US</h3>
        </div>
        <div class="col-sm-6">
            <h3 align="right"> Welcome ${userInfo.givenName} &nbsp;</h3>
        </div>


    </div>
    <hr>

    <%--<div class="row">--%>
        <%--<div class="col-sm-5">--%>
            <%--<div class="jumbotron">--%>
                <%--<p>--%>
                    <%--&lt;%&ndash;Living in a dream house is what a person works hard for and finding the same house which can&ndash;%&gt;--%>
                    <%--&lt;%&ndash;fulfill one&#180;s needs is not only hard but a tough job irrespective of how big or small city one&ndash;%&gt;--%>
                    <%--&lt;%&ndash;chooses to live in.</p><br>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<p>Property owners, on the other hand struggle in finding a suitable manager who can keep track&ndash;%&gt;--%>
                    <%--&lt;%&ndash;of their existing properties and publicize them. Trusting strangers to lend a place is not easy and&ndash;%&gt;--%>
                    <%--&lt;%&ndash;requires a series of categories of background checks making the whole process hectic and&ndash;%&gt;--%>
                    <%--&lt;%&ndash;messy one.<br><br>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;So, eradicating some of the difficulties mentioned, we have come up with an Enterprise based&ndash;%&gt;--%>
                    <%--&lt;%&ndash;Solution &ndash;%&gt;--%>
                    <%--<strong>EaseYourLease</strong>, is a Housing Property hosting platform where Property Managers can--%>
                    <%--more effectively market, manage and grow their business by hosting and posting about their--%>
                    <%--Housing Property which could be an Apartment or Student Housing or even a Community--%>
                    <%--Association.</p>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="col-sm-7">--%>
            <%--<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">--%>
                <%--<!-- Indicators -->--%>
                <%--<ol class="carousel-indicators">--%>
                    <%--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>--%>
                    <%--<li data-target="#myCarousel" data-slide-to="1"></li>--%>
                    <%--<li data-target="#myCarousel" data-slide-to="2"></li>--%>
                <%--</ol>--%>

                <%--<!-- Wrapper for slides -->--%>
                <%--<div class="carousel-inner">--%>
                    <%--<div class="item active">--%>
                        <%--<img src="images/slider-1.jpg" alt="Los Angeles" style="width:100%; height: 380px">--%>
                    <%--</div>--%>

                    <%--<div class="item">--%>
                        <%--<img src="images/slider-1.jpg" alt="Chicago" style="width:100%;height: 380px">--%>
                    <%--</div>--%>

                    <%--<div class="item">--%>
                        <%--<img src="images/slider-1.jpg" alt="New york" style="width:100%;height: 380px">--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<!-- Left and right controls -->--%>
                <%--<a class="left carousel-control" href="#myCarousel" data-slide="prev">--%>
                    <%--<span class="glyphicon glyphicon-chevron-left"></span>--%>
                    <%--<span class="sr-only">Previous</span>--%>
                <%--</a>--%>
                <%--<a class="right carousel-control" href="#myCarousel" data-slide="next">--%>
                    <%--<span class="glyphicon glyphicon-chevron-right"></span>--%>
                    <%--<span class="sr-only">Next</span>--%>
                <%--</a>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>


    <div class="row">
        <div class="col-sm-12">
            <div class="jumbotron">
                <h3>Our Offices</h3>
                <%--<img src="images/image1.png" alt="" height="150px" width="350px" align="center">--%>
                <div class="row">
                    <div class="col-sm-4">
                        <%--<ul class="list-1">--%>
                        <a href="#"><strong>Sunnyvale Apartments</strong></a> <br><br>
                            <%--<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3172.309221761434!2d-121.88326018504354!3d37.335187379841884!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fccb864de43d5%3A0x397ffe721937340e!2sSan+Jos%C3%A9+State+University!5e0!3m2!1sen!2sus!4v1512725414333" width="300" height="300" frameborder="2" style="border:10px" allowfullscreen></iframe>--%>
                            <iframe src="https://www.google.com/maps/embed?pb=!1m26!1m12!1m3!1d50720.78580696665!2d-122.04093556783981!3d37.38867078673358!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m11!3e3!4m3!3m2!1d37.3917438!2d-121.9815131!4m5!1s0x808fb645a9d05d3b%3A0x768dfb26dd7cc3a2!2sSunnyvale%2C+CA!3m2!1d37.368829999999996!2d-122.0363496!5e0!3m2!1sen!2sus!4v1512769388649" width="300" height="300" frameborder="2" style="border:10px" allowfullscreen></iframe>
                    </div>
                    <div class="col-sm-4">
                        <a href="#"><strong>San Francisco</strong></a><br><br>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10030.996480514923!2d-122.38352326685802!3d37.618911077051045!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808f778c55555555%3A0xa4f25c571acded3f!2sSan+Francisco+International+Airport!5e0!3m2!1sen!2sus!4v1512725494518" width="300" height="300" frameborder="2" style="border:0" allowfullscreen></iframe>

                    </div>
                    <div class="col-sm-4">
                        <a href="#"><strong>Santa Clara</strong></a><br><br>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50737.82101895642!2d-121.96640439544775!3d37.36348376384344!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fca6f1483a0b3%3A0xa43fe74528b69173!2sSanta+Clara+Recreation+Center!5e0!3m2!1sen!2sus!4v1512725567291" width="300" height="300" frameborder="2" style="border:0" allowfullscreen></iframe>

                    </div>
                </div>
                <br><br>
                <div class="row">
                    <div class="col-sm-4">
                        <a href="#"><strong>Milpitas</strong></a><br><br>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.6283518672167!2d-121.91949418504055!3d37.42225837982513!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fc924206c58eb%3A0x4a4b8ee958f0a452!2sMilpitas+Square!5e0!3m2!1sen!2sus!4v1512725606810" width="300" height="300" frameborder="2" style="border:0" allowfullscreen></iframe>

                    </div>
                    <div class="col-sm-4">
                        <a href="#"><strong>Mountain View</strong></a><br><br>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3169.7975657749653!2d-122.07929528504147!3d37.39461937983041!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fb7369603b7db%3A0xfc12b6c0767ac5f6!2sMountain+View+Transit+Center!5e0!3m2!1sen!2sus!4v1512725652219" width="300" height="300" frameborder="2" style="border:0" allowfullscreen></iframe>

                    </div>
                    <div class="col-sm-4">
                        <a href="#"><strong>Palo Alto</strong></a><br><br>
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3167.8780406916403!2d-122.16388238503993!3d37.43998577982181!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fbb3acde602c3%3A0xbb43423da1806dd8!2sPalo+Alto+Center%3A+Palo+Alto+Medical+Foundation%3A+Sutter+Health+Affiliate!5e0!3m2!1sen!2sus!4v1512725704193" width="300" height="300" frameborder="2" style="border:0" allowfullscreen></iframe>
                    </div>
                </div>

                            <%--<li><a href="#">Palo Alto</a></li>--%>
                        <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-4">--%>
                        <%--<img src="images/image1.png" alt="" height="150px" width="350px" align="center">--%>
                        <%--&lt;%&ndash;<ul class="list-1 last">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;&lt;%&ndash;<li><a href="#">Mountain View</a></li>&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<li><a href="#">Santa Clara</a></li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<li><a href="#">Milpitas</a></li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                    <%--</div>--%>

                </div>
                <%--<div class="lists">--%>
            </div>
        </div>



    </div>


</div>
<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>