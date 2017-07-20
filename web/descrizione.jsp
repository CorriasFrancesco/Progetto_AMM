<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
    <head>
        <title>Descrizione</title>
        <meta charset="UTF-8">
        <meta name="author" content="Francesco Corrias">
        <link rel="stylesheet" type="text/css" href="style.css" media="all">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
                <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Descrizione" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="descrizione" scope="request"/>
        <jsp:include page="navbar.jsp"/>
         
  
        <div id="content">
            <div id='sommario'>
                <h2>Sommario:</h2>
                <a href='#faq'>FAQ</a>
                <br/>
                <a href='#cosa'>Cos'è nerdbook?</a>
                <br/>
                <a href='#gratis'>E' gratis?</a>
                <br/>
                <br/>
                <a href='#tipologie_utenti'>Tipologie di utenti</a>
                <br/>
                <a href='#registrati'>Utenti registrati</a>
                <br/>
                <a href='#admin'>Amministratori</a>
            </div>
            
            <div id="descrizione">
                <a id='faq'>
                    <h2>FAQ</h2>
                    <a id='cosa'>
                    <h3>Cos'è Nerdbook?</h3>
                    <p>Nerdbook è un social network che permette agli utenti 
                        di stringere amicizie, creare gruppi e gestirli.
                    </p>
                    </a>
                    <a id='gratis'>
                    <h3>E' gratis?</h3>
                    <p>Si, Nerdbook è gratis e lo sarà  sempre.
                    </p>
                    </a>
                </a>

                <a id='tipologie_utenti'>
                    <h2>Tipologie di utenti</h2>
                    <a id='registrati'>
                    <h3>Utenti registrati</h3>
                    <p>Un utente registrato ha associati una serie di dati personali
                        e una frase di presentazione. L'utente registrato può 
                        gestire la propria bacheca e condividere nei gruppi di
                        cui fa parte.
                    </p>
                    </a>
                    
                    <a id='admin'>
                    <h3>Amministratori</h3>
                    <p>L'amministratore è un utente speciale che può cancellare 
                        post di qualsiasi utente e qualsiasi gruppo ritenuti 
                        poco appropriati.
                    </p>
                    </a>
                </a>
            </div>
        </div>
    </body>
    
</html>
