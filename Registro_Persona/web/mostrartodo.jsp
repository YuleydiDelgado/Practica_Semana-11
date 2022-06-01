<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : mostrartodo
    Created on : 06-01-2022, 04:55:41 PM
    Author     : MINEDUCYT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head><c:forEach var="listaTotal" items="${sessecionScope.personas}">
    </c:forEach>
    <body>
        <h1>Todos los Registros</h1>
        <c:forEach var="listTotal" items="${sessionScope.persona}">
            DUI:${listTotal.dui}<br>
            Apellidos:${listTotal.apellido}<br>
            Nombres:${listTotal.nombre}<br>
            <br>
            <br>
        </c:forEach>
    </body>
</html>
