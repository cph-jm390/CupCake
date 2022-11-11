<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:CupCakeLogo>
    <jsp:attribute name="header">
         Olsker Cupcake
    </jsp:attribute>

    <jsp:body>

        <p>Log venligst på systemet først</p>
        <p>Derefter kan du shoppe løs</p>
        <p>Det kan du gøre her: <a href="login.jsp">Login</a></p>
        <p>Tryk her for at logge ind som admin: <a href="adminlogin.jsp">Her</a></p>


    </jsp:body>

</t:CupCakeLogo>