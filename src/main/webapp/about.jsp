<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:CupCakeLogo>
    <jsp:attribute name="header">
       Profile
    </jsp:attribute>

    <jsp:body>

        <h3>Your email is: ${sessionScope.user.username} </h3>
        <p>Bottom text.</p>

    </jsp:body>

</t:CupCakeLogo>