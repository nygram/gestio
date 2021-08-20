/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vista.vistaVehicle;
import modelo.Conexion;

/**
 *
 * @author JavierFernándezDíaz
 */
public class consultesVehicles extends Conexion{

    PreparedStatement ps;
    ResultSet rs;
    private int codigo;
    private Vehicles vehicles;

    public boolean insertar(Vehicles vehicles) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("insert into vehicles (matricula, marca, model, combustible, renting, date_entrada, data_final, pany_seguretat, copiaclaus, propera_revisio) values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vehicles.getMatricula());
            ps.setString(2, vehicles.getMarca());
            ps.setString(3, vehicles.getModel());
            ps.setString(4, vehicles.getCombustible());
            ps.setString(5, vehicles.getRenting());
            ps.setDate(6, vehicles.getData_entrada());
            ps.setDate(7, vehicles.getDate_final());
            ps.setBoolean(8, vehicles.isPany_seguretat());
            ps.setBoolean(9, vehicles.isCopia_claus());
            ps.setDate(10, vehicles.getPropera_revisio());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;

            } else {
                return false;
            }

        } catch (Exception ex) {
            System.err.println("Error " + ex);

            return false;
        } finally {
            try {
                conexio.close();
            } catch (Exception ex) {
                System.err.println("Error " + ex);
                return false;
            }

        }
    }

}
