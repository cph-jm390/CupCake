<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:CupCakeLogo>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:body>

        <h3>You can log in here:</h3>

        <form action="login" method="post">
            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
            <input type="submit" value="Log in"/>
        </form>

        <h3>You can also create a user here:</h3>

        <form action="createuser" method="post">
            <label for="username">Username: </label>
            <input type="text" id="newUsername" name="username"/>
            <label for="password">Password: </label>
            <input type="password" id="newPassword" name="password"/>
            <input type="submit" value="Create User"/>

        </form>


    </jsp:body>
</t:CupCakeLogo>