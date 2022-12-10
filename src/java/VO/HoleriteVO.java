/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VO;

/**
 *
 * @author User
 */
public class HoleriteVO {
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double calculaSalario(double hrs, double hrsexts, double slrhr, double slrhrext){
        
        salario = (hrs*slrhr) + (hrsexts * slrhrext);
        return salario;
    }
}
