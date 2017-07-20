<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="author" content="Francesco Corrias">
        <link rel="stylesheet" type="text/css" href="style.css" media="all">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
                <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Profilo" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="profilo" scope="request"/>
        <jsp:include page="navbar.jsp"/>
        
        <jsp:include page="sidebar.jsp"/>
        
        <div id="content">
            <c:if test="${update == true}">
                <div id="updateMessage">Dati aggiornati correttamente</div>
            </c:if>
            
            <c:choose>
                <c:when test="${confirm==true}">
                    <div id="deleteMessage">Vuoi davvero elimanre il profilo?</div>
                    <form action="Profilo" method="post">
                        <button type="submit">No</button>
                        <button type="Delete"><a href="Profilo?elimina=2">Si</button>
                    </form>
                </c:when>
            </c:choose> 
            <div id='dati'>
                <form action="Profilo" method="post">
                    <label for='nome'>Nome</label>
                    <input type="text" name='nome' id='nome' value="${userNome}" required>
                    <label for='cognome'>Cognome</label>
                    <input type='text' name='cognome' id='cognome' value="${userCognome}" required>
                    <label for='img_profilo'>URL dell' immagine profilo</label>
                    <input type='url' name='img_profilo' id='img_profilo' value="${userUrlFotoProfilo}" required>
                    <label for='presentazione'>Frase di presentazione</label>
                    <textarea rows='1' cols='20' name='presentazione' id='presentazione' value="${userFrasePresentazione}" required></textarea>
                    <label for='data'>Data di nascita</label>
                    <input type="date" name='data' id='data' value="${userDataDiNascita}" required>
                    <label for='pwd'>Password</label>
                    <input type="password" name='pwd' id='pwd' value${userPassword} required>
                    <label for='conferma_pwd'>Conferma password</label>
                    <input type='password' name='conferma_pwd' id='conferma_pwd' value="${userPassword}" required>
                    <br /><br />
                    <button type="submit">Update</button>
                    <button type="Delete"><a href="Profilo?elimina=1">Elimina Profilo</button>
                </form>
            </div>
        </div>
    </body>
</html>