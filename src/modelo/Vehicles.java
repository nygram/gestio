package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Vehicles {

    private int Id;
    private String matricula;
    private String marca;
    private String model;
    private String combustible;
    private String renting;
    private Date data_entrada;
    private Date date_final;
    private String pany_seguretat;
    private String copia_claus;
    private Date propera_revisio;

    public Vehicles() {
    }

    public Vehicles(int Id, String matricula, String model, String combustible, Date data_entrada, Date date_final, String pany_seguretat, String copia_claus, Date propera_revisio) {
        this.Id = Id;
        this.matricula = matricula;
        this.model = model;
        this.combustible = combustible;
        this.data_entrada = data_entrada;
        this.date_final = date_final;
        this.pany_seguretat = pany_seguretat;
        this.copia_claus = copia_claus;
        this.propera_revisio = propera_revisio;
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

    public String getPany_seguretat() {
        return pany_seguretat;
    }

    public void setPany_seguretat(String pany_seguretat) {
        this.pany_seguretat = pany_seguretat;
    }

    public String getCopia_claus() {
        return copia_claus;
    }

    public void setCopia_claus(String copia_claus) {
        this.copia_claus = copia_claus;
    }
     public Date getPropera_revisio() {
        return propera_revisio;
    }

    public void setPropera_revisio(Date propera_revisio) {
        this.propera_revisio = propera_revisio;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getRenting() {
        return renting;
    }

    public void setRenting(String renting) {
        this.renting = renting;
    }
    
    public String toString(){
        return this.matricula;
    }
    
   
    
}
    
    


