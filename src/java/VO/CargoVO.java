/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VO;

/**
 *
 * @author User
 */
public class CargoVO {

    private int id_cargo;
    private String tx_nome_cargo;
    private double vlr_hr_ext, vlr_hr;

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getTx_nome_cargo() {
        return tx_nome_cargo;
    }

    public void setTx_nome_cargo(String tx_nome_cargo) {
        this.tx_nome_cargo = tx_nome_cargo;
    }

    public double getVlr_hr_ext() {
        return vlr_hr_ext;
    }

    public void setVlr_hr_ext(double vlr_hr_ext) {
        this.vlr_hr_ext = vlr_hr_ext;
    }

    public double getVlr_hr() {
        return vlr_hr;
    }

    public void setVlr_hr(double vlr_hr) {
        this.vlr_hr = vlr_hr;
    }
    
}
