<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Probleme de connexion" />
    </jsp:include>
    <body>
        <h1>Bonjour Inconnu , vous devriez vous connecter  ! </h1>
        
        <br />

        <a href="LoginServlet" >Connexion</a>
    </body>
</html>