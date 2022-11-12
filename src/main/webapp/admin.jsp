<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<html>
<t:CupCakeLogo>
<jsp:attribute name="header">
         Admin Side
    </jsp:attribute>

    <jsp:body>

        <h1>Welcome to the Admin Page</h1>

        <table>
            <c:forEach var="item" items="${requestScope.userList}">
                <tr>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.role}</td>
                    <td>${item.created}</td>
                    <td>${item.idShoppinglist}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>

</t:CupCakeLogo>
</html>