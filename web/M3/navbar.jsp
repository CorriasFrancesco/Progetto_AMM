<%-- 
    Document   : navbar
    Created on : 16-mag-2017, 17.38.19
    Author     : francesco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav id="navbar">
    <ol>
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a href="bacheca.jsp">Bacheca</a></li>
        <li <c:if test="${page=='descrizione'}">class="active"</c:if>><a href="descrizione.jsp">Descrizione</a></li>
        <li <c:if test="${page=='profilo'}">class="active"</c:if>><a href="profilo.jsp">Profilo</a></li>
        <li <c:if test="${page=='login'}">class="active"</c:if>><a href="login.jsp">Login</a></li>
    </ol>
</nav>
