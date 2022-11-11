<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:CupCakeLogo>
    <jsp:attribute name="header">
             Admin Login side
    </jsp:attribute>

    <jsp:body>

        <title>Admin login side TMP</title>

        <h3>You can log in here</h3>

        <form action="admin" method="post">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <input type="submit" value="Log in"/>
        </form>
    </jsp:body>
</t:CupCakeLogo>
