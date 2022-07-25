<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp" > <jsp:param name="title" value="Compteur de mots" /></jsp:include>
    <body>
        <h1>Compteur de mots </h1>
        
        <form method="GET"  >
            <label>Inserez une phrase : </label><input type="texte" name="phrase">
            
            <input type="submit" value="Calcul">
            
             
        </form>
        <p>Le nombre de mots est de : ${mot}</p> 
    </body>
</html>
