<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Prog.kiev.ua</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>age</td>
            </tr>
                <c:forEach var="user" items="${list}">
                    <tr>
            <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
        </tr>

        </c:forEach>
        </table>
    <a href="/">To Start page</a>
    </body>
</html>
