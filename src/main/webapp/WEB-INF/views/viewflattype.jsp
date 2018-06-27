<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Apartment Details</title>
</head>

<body>
Here are the list of Flats:
<table>
    <tr>
        <th>Flat number</th>
        <th>Details</th>
        <th>Type</th>
        <th>Price</th>
        <th>Availability</th>
        <th>Actions</th>

    </tr>

    <c:forEach items="${flats}" var="flat" >
        <tr>
            <td><a href="viewflatdetails">${flat.flatName}</a></td>
            <td>${flat.details}</td>
            <td>${flat.type}</td>
            <td>${flat.price}</td>
            <td>${flat.availability}</td>
            <td><input type="checkbox" name="isavailable" value=checked /><td>
            <td><button type="button" onclick="rentThisApartment">Rent this Appartment</button></td>

        </tr>
    </c:forEach>
</table>
</body>

</html>