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

        ${sessionScope.username}

        <c:forEach var="item" items="${sessionScope.list}">
            User: ${item.username}: <br>
            Role: ${item.role} <br>
            Balance: ${item.balance}<br>
            Shoppinglist ID: ${item.idShoppinglist}<br>
            <br>
        </c:forEach>

    </jsp:body>

</t:CupCakeLogo>
</html>