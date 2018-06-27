<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>EaseYourLease</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="style/easeyourlease.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
    <div class="topnav">
     <!-- <div class="search-container">
    <form action="/searchLabels?">
      <input type="text" placeholder="Search Amenities.." name="searchLabel">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div> -->
  </div>
</nav>
<%--navbar end--%>

<div class="container">
    <h3 align="right"> Welcome ${userInfo.givenName} &nbsp;</h3>
    <hr>
    <div class="row">
        <div class="col-sm-9">
            <h1>Flats List for ${apartmentName}</h1>
        </div>
        <div class="col-sm-3">
            <c:set var="addflatLinks" value="${'/addflat?apartmentid='}${apartmentid}" />
            <button class="btn btn-primary btn-lg" type="submit" onclick="location.href='${addflatLinks}'">Add new Flat</button>
        </div>
    </div>
    <br>


    <table class="table table-hover">
        <thead>
        <tr>
            <th>Flat number</th>
            <th>Details</th>
            <th>Type</th>
            <th>Price</th>
            <th>Availability</th>
            <th>Images</th>
            <th>Actions</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${flats}" var="flat" >
            <c:set var="flatLinks" value="${'/rentapartment?flatid='}${flat.id}" />

            <tr>
                <c:choose>
                <c:when test = "${flat.availability=='false'}">
                <td>
                    <a href=${'viewTenant?flatid='}${flat.id}>
                            ${flat.flatName}
                    </a></td>
                    </c:when>
                <c:when test = "${flat.availability=='true'}">
                    <td>

                                ${flat.flatName}
                        </td>
                </c:when>
                    <c:otherwise>
                        No comment sir...
                    </c:otherwise>
                </c:choose>

                        <%--${flat.availability=='true' ? 'disabled="disabled"' : ''}--%>
                    <%--<a href=${'viewTenant?flatid='}${flat.id}>--%>
                       <%--${flat.flatName}--%>
                <%--</a></td>--%>
                <td>${flat.details}</td>
                <td>${flat.type}</td>
                <td>${flat.price}</td>
                <td>${flat.availability=='false'?'Not Available' : 'Available'}</td>
               <td><input type="button"  onclick="location.href='/viewImages?fileId=${flat.id}'" value="viewImages" ></td>
                <td><button type="submit" class="btn-primary"  onclick="location.href='${flatLinks}'"
                ${flat.availability=='false' ? 'disabled="disabled"' : ''}>Rent this Appartment</button></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


    <br><br><br><br>
    <div align="center">
        <hr>
        <p>Share Apartment availability on social media</p>
        <div class="row" align="center">
            <div class="col-sm-4"></div>
            <div class="col-sm-1">
                <form action="/connect/facebook" method="POST">
                    <input type="hidden" name="scope" value="user_posts,manage_pages,email,publish_pages,pages_show_list" />
                    <input type="image" value="submit" src="images/fbicon.jpeg"alt="submit Button" width="100" height="50" onMouseOver="this.src='images/fbicon.jpeg'">
                </form>
            </div>
            &nbsp;&nbsp;
            <div class="col-sm-2" align="center">
                <form action="/connect/twitter" method="POST">
                    <input type="image" value="submit" src="images/twittericon.jpeg"alt="submit Button" width="50" height="50" onMouseOver="this.src='images/twittericon.jpeg'">
                </form>
            </div>

            <div class="col-sm-1">
                <form action="/connect/linkedin" method="POST">
                    <input type="hidden" name="scope" value="r_basicprofile,r_emailaddress,w_share" />
                    <input type="image" value="submit" src="images/linkedinicon.jpeg"alt="submit Button" width="50" height="50" onMouseOver="this.src='images/linkedinicon.jpeg'">
                </form>
            </div>
        </div>
    </div>

</div>




<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</>

</html>
