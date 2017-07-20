<%-- 
    Document   : navbar
    Created on : 16-mag-2017, 17.38.19
    Author     : francesco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav id="navbar">
    <ol>
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a href="Bacheca">Bacheca</a></li>
        <li <c:if test="${page=='descrizione'}">class="active"</c:if>><a href="descrizione.jsp">Descrizione</a></li>
        <li <c:if test="${page=='profilo'}">class="active"</c:if>><a href="Profilo">Profilo</a></li>
        <li <c:if test="${page=='login'}">class="active"</c:if>><a href="Login">Login</a></li>
        <li <c:if test="${not empty loggedUserID}"><p id="logOutLink"><a href="Login?logout=1">Logout</a></p></c:if></li>
    </ol>
</nav>
