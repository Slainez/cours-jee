

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show IP Adress </title>
    </head>
    <body>
        <h1>Bienvenue <%= request.getParameter("name") %> !</h1>
        <div> Votre adresse Ip est :  <%= request.getRemoteAddr() %>  </div>
        <div> Votre adresse Ip est :  <%= request.getAttribute("adressIP") %>  </div>
        
        
    </body>
</html>
