<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp" ><jsp:param name="title" value="Welcome" /></jsp:include>
    <body>
        <h1>Welcome <c:out value="${sessionScope.user.email}" /> </h1>
    <h2>Vous êtes un <c:out value="${sessionScope.user.role}" /> </h2>
    
    <a href="LogoutServlet">Deconnexion</a>
    
    </body>
</html>
