<%@page import="VO.FuncionarioVO"%>
<%@page import="java.util.List"%>

<%@page import= "VO.FuncionarioVO" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionarios</title>
    </head>
    <body>
        <table border="1" align="center" cellspacing="0" width="30%">
            <%
                List funcionarios = (List) request.getAttribute("lista");
                if (funcionarios != null) {
                    out.print("<center>Achados: " + funcionarios.size() + "</center><br><br><br>");
                    for (int cont = 0; cont < funcionarios.size(); cont++) {
                        out.print("<tr>");
                        FuncionarioVO p = new FuncionarioVO();
                        p = (FuncionarioVO) funcionarios.get(cont);
                        out.print("<td>" + p.getTx_nome_funcionario()+ "</td>");
                        out.print("<td>" + "Horas trabalhadas: " + p.getHrs_trabalhadas()+ "</td>");
                        out.print("<td>" + "Horas Extras trabalhadas: " + p.getHrs_ext_trabalhadas()+ "</td>");
                        out.print("<td>" + "Id do cargo: " + p.getCargo_id()+"</td>");
                        out.print("<td><a href=\"HoleriteController?operacao=2&id_funcionario="+p.getId_funcionario()+"\">Excluir</a></td>");
                        out.print("<td><a href=\"HoleriteController?operacao=3&id_funcionario="+p.getId_funcionario()+"\">Alterar</a></td>");
                        out.print("<td><a href=\"HoleriteController?operacao=5&id_funcionario="+p.getId_funcionario()+"&cargo_id="+p.getCargo_id()+"\">Calcular</a></td>");
                        out.print("</tr>");
                    }
                }
            %>
        </table>
    </body>
</html>

