package modelo;

import java.sql.Date;

public class Instruments {
    
    private int Id;
    private int codi_instrument;
    private String tipus;
    private String marca;
    private String model;
    private String num_serie;
    private Date data_compra;
    private Date ult_calibració;

    public Instruments(int Id, int codi_instrument, String tipus, String marca, String model, String num_serie, Date data_compra, Date ult_calibració) {
        this.Id = Id;
        this.codi_instrument = codi_instrument;
        this.tipus = tipus;
        this.marca = marca;
        this.model = model;
        this.num_serie = num_serie;
        this.data_compra = data_compra;
        this.ult_calibració = ult_calibració;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCodi_instrument() {
        return codi_instrument;
    }

    public void setCodi_instrument(int codi_instrument) {
        this.codi_instrument = codi_instrument;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public Date getUlt_calibració() {
        return ult_calibració;
    }

    public void setUlt_calibració(Date ult_calibració) {
        this.ult_calibració = ult_calibració;
    }
    
    
    
    
}
