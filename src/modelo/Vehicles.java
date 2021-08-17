package modelo;

import java.sql.Date;

public class Vehicles {

    private int Id;
    private String matricula;
    private String model;
    private String combustible;
    private Date data_entrada;
    private Date date_final;
    private boolean pany_seguretat;
    private boolean copia_claus;

    public Vehicles() {
    }

    public Vehicles(int Id, String matricula, String model, String combustible, Date data_entrada, Date date_final, boolean pany_seguretat, boolean copia_claus) {
        this.Id = Id;
        this.matricula = matricula;
        this.model = model;
        this.combustible = combustible;
        this.data_entrada = data_entrada;
        this.date_final = date_final;
        this.pany_seguretat = pany_seguretat;
        this.copia_claus = copia_claus;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getDate_final() {
        return date_final;
    }

    public void setDate_final(Date date_final) {
        this.date_final = date_final;
    }

    public boolean isPany_seguretat() {
        return pany_seguretat;
    }

    public void setPany_seguretat(boolean pany_seguretat) {
        this.pany_seguretat = pany_seguretat;
    }

    public boolean isCopia_claus() {
        return copia_claus;
    }

    public void setCopia_claus(boolean copia_claus) {
        this.copia_claus = copia_claus;
    }

}
