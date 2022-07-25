<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
   <jsp:include page="include/header.jsp" ><jsp:param name="title" value="Liste de nombres premiers" /></jsp:include> 
    <body>
        <h1>Liste de nombres premiers</h1>
        <div id="etape1">        
            <c:forEach var="i" begin="2" end="30" step="1">        
                <c:if test="${(i % i != 0) || (i % 1 != 0)}" > 
                    <p><c:out value="${i} n'est pas un nombre premier" /></p>
                </c:if>
                <c:if test="${(i % 1 == 0) && (i % i == 0)}">
                    <p><c:out value="${i} est un nombre premier" /></p>
                </c:if>               
            </c:forEach>
        </div>
         <div id="etape2">        
             <form method="GET">
                 <label>Entrez un nombre :</label>
                 <input type="number" name="inputNumber" />
                 <input type="submit" name="Calcul"/>
             </form>
             
         <c:if test="${(number % 1 == 0) && (number % number == 0)}" ><c:out value="${number} est un nombre premier"/></c:if>
         <c:if test="${(number % 1 != 0) || (number % number != 0)}" ><c:out value="${number} n'est pas un nombre premier"/></c:if>
                      
        </div>
         
         <div id="etape3">
             
             <form method="GET">
                 <label>Entrez un nombre de début et de fin:</label>
                 <input type="number" name="inputBeginNumber" />
                 <input type="number" name="inputEndNumber" />
                 <input type="submit" name="Calcul"/>
             </form>
             
             
            <c:forEach var="i" begin="inputBeginNumber" end="inputEndNumber" step="1">        
                <c:if test="${(i % i != 0) || (i % 1 != 0)}" > 
                    <p><c:out value="${i} n'est pas un nombre premier" /></p>
                </c:if>
                <c:if test="${(i % 1 == 0) && (i % i == 0)}">
                    <p><c:out value="${i} est un nombre premier" /></p>
                </c:if>               
            </c:forEach>
        </div>
        
        
    </body>
</html>
