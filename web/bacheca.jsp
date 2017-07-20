<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Bacheca</title>
        <meta charset="UTF-8">
        <meta name="author" content="Francesco Corrias">
        <link rel="stylesheet" type="text/css" href="style.css" media="all">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
                <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="navbar.jsp"/>
        
        <jsp:include page="sidebar.jsp"/>
        
        <div id="content">
            <c:choose>
                <c:when test="${empty newpost}">
                    <div id="formNewPost" class="post">
                        <form action="NuovoPost" method="post">
                            <div id="postType">
                                <div>
                                    <label for="textType">Post di Testo</label>
                                    <input type="radio" name="postType" value="textType" id="textType" checked="checked">
                                </div>
                                <div>
                                    <label for="imgType">Post con Foto</label>
                                    <input type="radio" name="postType" value="imgType" id="imgType">
                                </div>
                            </div>
                            <div id="postContent">
                                <div>
                                    <label for="textPost">Contenuto</label>
                                    <textarea name="textPost" id="textPost" rows='10' cols='60'></textarea>
                                </div>
                            </div>
                            <button type="submit" name="thereIsPost" value="needConfirm">Invia</button>
                        </form>     
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="formNewPost">
                        
                        <form action="NuovoPost" method="post">
                            <c:if test="${typePost == 'textType'}">
                                <p>${content}</p>
                            </c:if>
                            <c:if test="${typePost == 'imgType'}">
                                <img src="${content}" alt="downloadedImage">
                            </c:if>
                            <input type="text" hidden name="textPost" value="${content}">
                            <input type="text" hidden name="postType" value="${typePost}">
                            <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
            <c:forEach var="post" items="${post}">
                <div class="post">
                    <c:if test="${post.getPostType == 'TEXT'}">
                        <p>${post.getUser.getNome} ${post.getUser.getCognome}</p>
                        <img class="profile_img" title="fotoProfilo" width="75" height="100" alt="Foto profilo ${post.getUser.getNome} ${post.getUser.getcognome}" src="${post.getUser.getUrlFotoProfilo}">
                        <p>${post.getContent}</p>
                    </c:if>
                    <c:if test="${post.postType == 'IMAGE'}">
                        <p>${post.getUser.getNome} ${post.getUser.getCognome}</p>
                        <img class="profile_img" title="fotoProfilo" width="75" height="100" alt="Foto profilo ${post.getUser.getNome} ${post.getUser.getcognome}" src="${post.getUser.getUrlFotoProfilo}">
                        <img alt="Post con foto" src="${post.getContent}">
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </body>
</html>