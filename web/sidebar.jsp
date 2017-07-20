<%-- 
    Document   : sidebar
    Created on : 16-mag-2017, 17.49.05
    Author     : francesco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="sidebar">
    <div id="ricerca">
        <input type="text" id="ricerca" name="ricerca" onkeyup= "aggiorna()"/>
        <button id="filter">Cerca</button>     
    </div>
    
    <div id="persone">
        <c:forEach var="user" items="${users}">
            <p class="personName"><a href="Bacheca?user=${user.id}">${user.nome} ${user.cognome}</a></p>
        </c:forEach>
    </div>

    <div id="gruppi">
        <h2>Gruppi:</h2>
        <c:forEach var="group" items="${groups}">
            <p class="groupName"><a href="Bacheca?group=${group.id}">${group.nome}</a></p>
        </c:forEach>
    </div>
</div>
