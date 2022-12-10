<%-- 
    Document   : cadastrar
    Created on : 5 de dez. de 2022, 14:57:55
    Author     : User
--%>

<%@page import="VO.HoleriteVO"%>
<%@page import="VO.CargoVO"%>
<%@page import="VO.FuncionarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
            FuncionarioVO f = (FuncionarioVO) request.getAttribute("funcionario");
            CargoVO c = (CargoVO) request.getAttribute("cargosetado");
            HoleriteVO holerite = new HoleriteVO();
            holerite.calculaSalario(f.getHrs_trabalhadas(), f.getHrs_ext_trabalhadas(), c.getVlr_hr(), c.getVlr_hr_ext());
            out.print("Total:  <span>" + holerite.getSalario()+ "</span>");
        %>
        
        
        <br><br><br>
        <a href="HoleriteController?operacao=1">Listagem</a>
        
    </body>
</html>
