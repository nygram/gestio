package modelo;

import java.sql.Date;

public class VehicleDetalls {

    private int Id;
    private java.sql.Date data_trans;
    private int IdTecnic;
    private int IdVehicle;

    public VehicleDetalls(int Id, java.sql.Date data_trans, int IdTecnic, int IdVehicle) {
        this.Id = Id;
        this.data_trans = data_trans;
        this.IdTecnic = IdTecnic;
        this.IdVehicle = IdVehicle;
    }

    public VehicleDetalls() {
        
    }
    
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public java.sql.Date getData_trans() {
        return data_trans;
    }

    public void setData_trans(java.sql.Date data_trans) {
        this.data_trans = data_trans;
    }

    public int getIdTecnic() {
        return IdTecnic;
    }

    public void setIdTecnic(int IdTecnic) {
        this.IdTecnic = IdTecnic;
    }

    public int getIdVehicle() {
        return IdVehicle;
    }

    public void setIdVehicle(int IdVehicle) {
        this.IdVehicle = IdVehicle;
    }

}
