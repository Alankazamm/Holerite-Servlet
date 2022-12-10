

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
    <center>
        <%
            int op = Integer.parseInt(request.getParameter("operacao"));

            if (op == 1) {
                out.print("<h1>Sucesso!</h1>");
            } else {
                out.print("<h1>Erro!</h1>");
            }
        %>        
        
        <br><br><br>
        <a href="HoleriteController?operacao=1">Listagem</a>
    </center>
</body>
</html>
