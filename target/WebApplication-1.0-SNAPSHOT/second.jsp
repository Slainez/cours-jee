

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp" ><jsp:param name="title" value="Second Page" /></jsp:include>
    <body>
        <h1>Ceci est ma seconde page JSP</h1>
        <div>Au revoir <%= request.getParameter("name") %> !</div>
    </body>
    <jsp:include page="include/footer.jsp"><jsp:param name="footer" value="This Second Page was realized by your maestro Sullyvan Lainez </br>
                                                      Copyright@ 2022 contact me at : sullyvan360@gmail.com" /></jsp:include>

</html>
