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

        <form action="admin" method="post">
                ${sessionScope.list}
        </form>

        ${sessionScope.username}

        <c:forEach var="item" items="${sessionScope.list}">
            ${item.role}

        </c:forEach>

    </jsp:body>

</t:CupCakeLogo>
</html>