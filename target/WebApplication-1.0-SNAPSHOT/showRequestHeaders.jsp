<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp" > <jsp:param name="title" value="Contenu des headers" /></jsp:include>
    <body>
        <table>
            <tr>
                <th>Nom</th>
                <th>Valeur</th>
            </tr>
            <% 
                List<String> headerName = (List) request.getAttribute("headersName");
                List<String> headerValue = (List) request.getAttribute("headersValue");
                
                for(int i =0 ;i< headerName.size();i++){
                out.println("<tr><td>" + headerName.get(i) +"</td>");
                out.println("<td>" + headerValue.get(i) +"</td></tr>");
                }
             %>
        </table>
    </body>
</html>
