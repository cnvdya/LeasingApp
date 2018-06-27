<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello Facebook</title>
</head>
<body>
<h3>Hello, ${facebookProfile.name}</h3>

<h4>Here is your feed:</h4>

<div>
    <c:forEach items="${feed}" var ="post">
    ${post.from.name} <b>from</b>  wrote:
    ${post.message} <p> message text</p>
    </c:forEach>
</div>
</body>
</html>