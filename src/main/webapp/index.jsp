<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">

        <h1>Control de acceso</h1>

        <form action="AccesoUsuarioServlet" method="get">
            <input type="text" name="usuario" placeholder="Usuario">
            <input type="password" name="contraseña" placeholder="Contraseña">
            <input type="submit" value="ACEPTAR">
        </form>

        <%
            if(request.getAttribute("error") != null){

        %><div class="error"><%
                    out.println((String)request.getAttribute("error"));
                %></div><%
            }
        %>
    </div>
</body>
</html>