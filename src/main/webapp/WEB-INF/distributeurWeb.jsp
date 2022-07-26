
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp" ><jsp:param name="title" value="Distributeur Web" /></jsp:include>
   
    <body>
        <h1>Distributeur Web</h1>
        
        <h1>Crédit : <c:out value="${credit}" /></h1>
    
        <h2>Liste des produits</h2>
        <table>
            <tr>
                <th>Produit</th>
                <th>Nom</th>
                <th>Quantite</th>
                <th>Prix</th>
            </tr>
         <c:forEach items="${stockList}" var="produit" >
            <tr>
            <form method="POST" >
                <td>
                    <label>Appuyez sur le bouton pour acheter :</label>
                    <input type="submit" value="<c:out value="${produit.id}" />" name="idProduct" />                     
                </td>
                <td>
                    <c:out value="${produit.nom}" /> 
                </td>
                <td>
                    <c:out value="${produit.quantite}" /> 
                </td>
                <td>
                    <c:out value="${produit.prix}" /> 
                </td>
            </form>    
            </tr>            
        </c:forEach>            
        </table>
        
       
        
        <div class="formAjoutCredit">
             <form method="POST" >
                <input type="submit" value="Ajouter 1 credit" name="increaseOne">
                <input type="submit" value="Ajouter 2 credit" name="increaseTwo">
            </form>
        </div>
       
        
        
    </body>
</html>
