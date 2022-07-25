<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <jsp:include page="include/header.jsp" ><jsp:param name="title" value="Page list nombre pair" /></jsp:include>
    <body>
        <h1>Liste des nombres pairs entre 1 et 30</h1>
        
    
    <c:forEach var="i" begin="2" end="30" step="2">
        <p><c:out value="${ i }" /></p>
    </c:forEach>
        
    </body>
</html>
