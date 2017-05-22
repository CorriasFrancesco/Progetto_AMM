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
                <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
            </c:if>
            <form>
                <label for="user">Username</label>
                <input type="text" name="user" id="user">
                <br />
                <label for="pswd">Password</label>
                <input type="password" name="pswd" id="pswd">
                <br /><br />
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
    
</html>