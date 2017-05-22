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
            <div id='dati'>
                <form>
                    <label for='nome'>Nome</label>
                    <input type="text" name='nome' id='nome' value="${user.getNome}">
                    <label for='cognome'>Cognome</label>
                    <input type='text' name='cognome' id='cognome' value="${user.getCognome}">
                    <label for='img_profilo'>URL dell' immagine profilo</label>
                    <input type='url' name='img_profilo' id='img_profilo' value="${user.getUrlFotoProfilo}">
                    <label for='presentazione'>Frase di presentazione</label>
                    <textarea rows='1' cols='20' name='presentazione' id='presentazione' value="${user.getFrasePresentazione}"></textarea>
                    <label for='data'>Data di nascita</label>
                    <input type="date" name='data' id='data' value="${user.getDataDiNascita}">
                    <label for='pwd'>Password</label>
                    <input type="password" name='pwd' id='pwd'>
                    <label for='conferma_pwd'>Conferma password</label>
                    <input type='password' name='conferma_pwd' id='conferma_pwd'>
                    <br /><br />
                    <button type="submit">Update</button>
                </form>
            </div>
        </div>
    </body>
</html>