<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp" ><jsp:param name="title" value="Comptes des mots dans une phrase" /></jsp:include>
    <body>
        <h1>Methode de compte de mot</h1>
        
        <form method="GET" action="CountWordsServlet">
            <input type="text" name="sentence" value="">
            <input type="submit" name="Nombre de mots">
        </form>
    <c:if test="${count != null}">
        <p>Le nombre de mots est de : <c:out value="${count}"  /></p>
    </c:if>    
    </body>
</html>
