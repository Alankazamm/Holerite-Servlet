/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CargoDAO;
import DAO.FuncionarioDAO;
import VO.FuncionarioVO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alan
 */
public class HoleriteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     HoleriteController
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        FuncionarioDAO f = new FuncionarioDAO();
        CargoDAO c = new CargoDAO();
        
        int operacao = Integer.parseInt(request.getParameter("operacao"));
        int id;
        switch(operacao){
            case 1: // listagem
                request.setAttribute("lista", f.buscaFuncionarios());
                RequestDispatcher rd = request.getRequestDispatcher("/listagem.jsp");
                rd.forward(request, response);
                break;
            case 2: // exclusão
                id = Integer.parseInt(request.getParameter("id_funcionario"));
                if(f.excluir(id)){
                     response.sendRedirect("resultado.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultado.jsp?operacao=2");                
                }
                break;
            case 3: // solicitação de alteraração de registro
                id = Integer.parseInt(request.getParameter("id_funcionario"));
                request.setAttribute("cargos", c.buscaCargos());
                request.setAttribute("funcionario", f.localizarRegistro(id));
                RequestDispatcher r = request.getRequestDispatcher("/alteracao.jsp");
                r.forward(request, response);
            case 4: // efetuar a modificação em BD (recebe os dados atualizados e modifica em banco)
                String nome = request.getParameter("tx_nome_funcionario");
                String horas = (request.getParameter("hrs_trabalhadas"));
                String horasExtras = (request.getParameter("hrs_ext_trabalhadas"));
                int codigo = Integer.parseInt(request.getParameter("id_funcionario"));
                String cargoId = (request.getParameter("cargo_id"));
                FuncionarioVO funcionario = new FuncionarioVO();
                funcionario.setId_funcionario(codigo);
                int cargoIdInt = Integer.parseInt(cargoId);
                funcionario.setCargo_id(cargoIdInt);
                funcionario.setTx_nome_funcionario(nome);
                double horasD = Double.parseDouble(horas);
                funcionario.setHrs_trabalhadas(horasD);
                double horasExtrasD = Double.parseDouble(horasExtras);
                funcionario.setHrs_ext_trabalhadas(horasExtrasD);
                if(f.alterar(funcionario)){
                     response.sendRedirect("resultado.jsp?operacao=1");
                }else{
                    response.sendRedirect("resultado.jsp?operacao=2");                
                }     
                break;
            case 5: // solicitação de calculo de salario
                id = Integer.parseInt(request.getParameter("id_funcionario"));
                int idCargo = Integer.parseInt(request.getParameter("cargo_id"));
                request.setAttribute("funcionario", f.localizarRegistro(id));
                request.setAttribute("cargosetado", c.setaCargo(idCargo));
                RequestDispatcher ra = request.getRequestDispatcher("/calcular.jsp");
                ra.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
