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

        <form action="admin" method="get">
            <button name="showAllUsers">Show all Users</button>
            <br>
            <c:forEach var="item" items="${sessionScope.list}">
                User: ${item.username}: <br>
                Role: ${item.role} <br>
                Balance: ${item.balance}<br>
                <br>
            </c:forEach>
        </form>

        <form action="addtocart" method="get">
            <button onclick ="getAllOrders">Show all orders</button>
            <br>
            <c:forEach var="item" items="${sessionScope.cupcakeList}">
                Shoppingcart ID: ${item.idShoppingcart}: <br>
                Topping ID: ${item.idTopping}
                Bottom ID: ${item.idBottom}
                Quantity: ${item.quantity}
                Total Price: ${item.cupcakeprice}<br>
                <br>
            </c:forEach>
        </form>

    </jsp:body>

</t:CupCakeLogo>
</html>