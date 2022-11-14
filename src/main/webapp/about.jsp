<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:CupCakeLogo>
    <jsp:attribute name="header">
       Profile
    </jsp:attribute>

    <jsp:body>

        <h2>Your Profile Page:</h2>
        <p>Your email is: ${sessionScope.user.username} </p>
        <p>Your balance is: ${sessionScope.user.balance}</p>

    </jsp:body>

</t:CupCakeLogo>