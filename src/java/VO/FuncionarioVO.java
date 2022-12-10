package VO;


public class FuncionarioVO {
    private int id_funcionario, cargo_id;
    private String tx_nome_funcionario;
    private double hrs_trabalhadas,hrs_ext_trabalhadas;
    
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getTx_nome_funcionario() {
        return tx_nome_funcionario;
    }

    public void setTx_nome_funcionario(String tx_nome_funcionario) {
        this.tx_nome_funcionario = tx_nome_funcionario;
    }

    public double getHrs_trabalhadas() {
        return hrs_trabalhadas;
    }

    public void setHrs_trabalhadas(double hrs_trabalhadas) {
        this.hrs_trabalhadas = hrs_trabalhadas;
    }

    public double getHrs_ext_trabalhadas() {
        return hrs_ext_trabalhadas;
    }

    public void setHrs_ext_trabalhadas(double hrs_ext_trabalhadas) {
        this.hrs_ext_trabalhadas = hrs_ext_trabalhadas;
    }
}
