<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp" ><jsp:param name="title" value="Login" /></jsp:include>
    <body>
        <h1>Connectez-vous grace au magnifique formulaire ci-dessous </h1>
        
        <form method="POST">
            <label>Email :</label>
            <input type="text" name="email">
            
            <label>Password :</label>
            <input type="password" name="password">
            <input type="submit" value="Valider">
            
        <c:if test="${errMsg != null }">
            <p><c:out value="${errMsg}" /></p>
        </c:if>
        </form>
    </body>
</html>
