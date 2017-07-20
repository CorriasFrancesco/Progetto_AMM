<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="author" content="Francesco Corrias">
        <link rel="stylesheet" type="text/css" href="style.css" media="all">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        
        <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Login" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="login" scope="request"/>
        <jsp:include page="navbar.jsp"/>
       
        
        <div id="login_form">
            
            <c:if test="${invalidData == true}">
                <div id="invalidDataWarning">I dati inseriti non sono corretti: ${loggedUserID}</div>
                 <div id="invalidDataWarning">I dati inseriti non sono corretti: ${path}</div>
            </c:if>
            <c:if test="${accessDenieded == true}">
                <div id="invalidDataWarning">Devi fare il login</div>
            </c:if>
            <c:if test="${loggedUserID == 40000}">
                <div id="invalidDataWarning">Porcoddio </div>
            </c:if>
            
            <form action="Login" method="post">
                <label for="user">Username</label>
                <input type="text" name="user" id="user" required>
                <br />
                <label for="pswd">Password</label>
                <input type="password" name="pswd" id="pswd" required>
                <br /><br />
                <button type="submit">Login</button>
            </form>
                
        </div>
    </body>
    
</html>