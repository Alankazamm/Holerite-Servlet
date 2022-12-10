/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import VO.CargoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CargoDAO {
     public CargoVO setaCargo(int id) {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "select id_cargo , tx_nome_cargo, vlr_hr,vlr_hr_ext from tbl_cargos where id_cargo  = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                rs.next();
                //setar os valores dentro de um objeto (CargoVO)
                CargoVO c = new CargoVO();
                c.setId_cargo(rs.getInt("id_cargo"));
                c.setTx_nome_cargo(rs.getString("tx_nome_cargo"));
                c.setVlr_hr(rs.getDouble("vlr_hr"));
                c.setVlr_hr_ext(rs.getDouble("vlr_hr_ext"));
                con.close();
                return c;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados para alteração: " + erro.getMessage());
            return null;
        }
    }
     
     public ArrayList<CargoVO> buscaCargos() {
        PreparedStatement ps; // estrutura o sql
        ResultSet rs; //armazenará o resultado do bd
        Connection con; //conexão com o bd

        try {
            con = new Conexao().conectar();
            if (con != null) {
                String sql = "select id_cargo, tx_nome_cargo from tbl_cargos";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                ArrayList<CargoVO> list = new ArrayList<>();
                while (rs.next()) {
                    //setar os valores dentro de um objeto (FuncionarioVO)
                    //adicionar este objeto a uma list
                    CargoVO c = new CargoVO();
                    c.setId_cargo(rs.getInt("id_cargo"));
                    c.setTx_nome_cargo(rs.getString("tx_nome_cargo"));
                    
                    list.add(c); // adiciona o objeto no arraylist
                }
                con.close();
                return list;
            } else {
                return null;
            }
        } catch (SQLException erro) {
            System.err.print("Exceção gerada ao tentar buscar os dados: " + erro.getMessage());
            return null;
        }
    }
}
