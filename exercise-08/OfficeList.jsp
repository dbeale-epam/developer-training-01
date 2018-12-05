<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <title>Office List</title>
    <body>
        <h1>Office List</h1>
     <ul>
     <c:forEach var="office" items="${offices}">
        <li><a href="./offices/${office.code}">${office.name}</a></li>
      </c:forEach>
      </ul>
    </body>
</html>