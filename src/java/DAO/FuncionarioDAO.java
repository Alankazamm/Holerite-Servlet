package DAO;

import Conexao.Conexao;
import VO.CargoVO;
import VO.FuncionarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    public ArrayList<FuncionarioVO> buscaFuncionarios() {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "select id_funcionario, tx_nome_funcionario, hrs_trabalhadas,hrs_ext_trabalhadas,cargo_id from tbl_funcionarios";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ArrayList<FuncionarioVO> lista = new ArrayList<>();
                while (rs.next()) {
                    //setar os valores dentro de um objeto (FuncionarioVO)
                    //adicionar este objeto a uma list
                    FuncionarioVO f = new FuncionarioVO();
                    f.setId_funcionario(rs.getInt("id_funcionario"));
                    f.setTx_nome_funcionario(rs.getString("tx_nome_funcionario"));
                    f.setHrs_trabalhadas(rs.getDouble("hrs_trabalhadas"));
                    f.setHrs_ext_trabalhadas(rs.getDouble("hrs_ext_trabalhadas"));
                    f.setCargo_id(rs.getInt("cargo_id"));
                    lista.add(f); // adiciona o objeto no arraylist
                }
                con.close();
                return lista;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados: " + erro.getMessage());
            return null;
        }
    }
    

    public boolean excluir(int id) {
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "delete from tbl_funcionarios where id_funcionario = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                if (ps.executeUpdate() != 0) {
                    con.close();
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }

    public FuncionarioVO localizarRegistro(int id) {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "select id_funcionario, tx_nome_funcionario, hrs_trabalhadas,hrs_ext_trabalhadas,cargo_id from tbl_funcionarios where id_funcionario = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                rs.next();
                //setar os valores dentro de um objeto (FuncionarioVO)
                FuncionarioVO f = new FuncionarioVO();
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setTx_nome_funcionario(rs.getString("tx_nome_funcionario"));
                f.setHrs_trabalhadas(rs.getDouble("hrs_trabalhadas"));
                f.setHrs_ext_trabalhadas(rs.getDouble("hrs_ext_trabalhadas"));
                f.setCargo_id(rs.getInt("cargo_id"));
                con.close();
                return f;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados para alteração: " + erro.getMessage());
            return null;
        }
    }
    
   
    
    
    

    public boolean alterar(FuncionarioVO p) {
        Connection con = new Conexao().conectar();
        if (con != null) {
            try {
                PreparedStatement ps;
                String sql = "update tbl_funcionarios set tx_nome_funcionario=?, hrs_trabalhadas=?, hrs_ext_trabalhadas=?,cargo_id=? where id_funcionario=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getTx_nome_funcionario());
                ps.setDouble(2, p.getHrs_trabalhadas());
                ps.setDouble(3, p.getHrs_ext_trabalhadas());
                ps.setInt(4, p.getCargo_id());
                ps.setInt(5, p.getId_funcionario());
                if (ps.executeUpdate() != 0) {
                    con.close();
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException erro) {
                return false;
            }
        } else {
            return false;
        }
    }

}
