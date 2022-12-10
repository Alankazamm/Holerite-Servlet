<%@page import="VO.CargoVO"%>
<%@page import="java.util.List"%>
<%@page import="VO.FuncionarioVO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração de dados</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <%
            FuncionarioVO f = (FuncionarioVO) request.getAttribute("funcionario");

        %>

        <form name="frm" method="post" action="HoleriteController?operacao=4">
            <input type="hidden" name="id_funcionario" value="<%=f.getId_funcionario()%>">
            Nome <input type="text" name="tx_nome_funcionario" value="<%=f.getTx_nome_funcionario()%>">
            <br><br>


            ID do Cargo <br>
            <select name="cargo_id">
                <%
                    List cargos = (List) request.getAttribute("cargos");
                    if (cargos != null) {

                        for (int cont = 0; cont < cargos.size(); cont++) {
                            CargoVO p = new CargoVO();
                            p = (CargoVO) cargos.get(cont);
                            if (f.getCargo_id() == p.getId_cargo()) {
                                out.print("<option value=" + p.getId_cargo() + " selected>" + p.getId_cargo() + "-" + p.getTx_nome_cargo() + "</option>");
                            } else {
                                out.print("<option value=" + p.getId_cargo() + ">" + p.getId_cargo() + "-" + p.getTx_nome_cargo() + "</option>");
                            }
                            
                        }
                    }
                %>

            </select>
            <br>




            <br><br>
            Horas semanais trabalhadas <input type="text" name="hrs_trabalhadas" value="<%=f.getHrs_trabalhadas()%>">
            <br><br>
            Horas <b>extras</b> semanais trabalhadas <input type="text" name="hrs_ext_trabalhadas" value="<%=f.getHrs_ext_trabalhadas()%>">
            <br><br>
            <input type="submit" value="Alterar">
        </form>
    </body>
</html>
