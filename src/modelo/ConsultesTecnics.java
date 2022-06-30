package modelo;

import Utils.Fechas;
import static Utils.Fechas.dameFecha;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Tecnics;
import modelo.Vehicles;
import vista.VistaEntrada;

public class ConsultesTecnics extends Conexion {

    PreparedStatement ps, ps2;
    ResultSet rs;
    private int codigo;
    private VistaEntrada entrad;
    Date fecha;

    public boolean insertar(Tecnics tecnics, DetallVehicle vehicle) {

        Connection conexio = getConnection();

        try {
            
            ps2 = conexio.prepareStatement("insert into detallsvehicle (data_trans, idTecnic, IdVehicle) values (?,?,?) ");
            ps = conexio.prepareStatement("insert into Tecnics (Codi_Tecnic, Nom, Cognoms, NIF, Adreça, Poblacio, Codi_Postal, Tel_Particular, Tel_Empresa, Extensio) values (?,?,?,?,?,?,?,?,?,?)");
           
            
            ps2.setDate(1, vehicle.getData_trans());
            System.out.println("lelo");
            ps2.setInt(2, vehicle.getIdTecnic());
            int tecnic = vehicle.getIdTecnic();
            System.out.println("tecnic "+tecnic);
            ps2.setInt(3, vehicle.getIdVehicle());
            int vehiclenum = vehicle.getIdVehicle();
            System.out.println("vehicle "+vehiclenum);
            ps.setInt(1, tecnics.getCodi_Tecnic());
            ps.setString(2, tecnics.getNom());
            ps.setString(3, tecnics.getCognoms());
            ps.setString(4, tecnics.getNIF());
            ps.setString(5, tecnics.getAdreça());
            ps.setString(6, tecnics.getPoblacio());
            ps.setInt(7, tecnics.getCodi_Postal());
            ps.setInt(8, tecnics.getTel_Particular());
            ps.setInt(9, tecnics.getTel_Particular());
            ps.setInt(10, tecnics.getExtensio());
            
            
            int result = ps.executeUpdate();
            int result2 = ps2.executeUpdate();

            if (result > 0 && result2 > 0) {
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

    public boolean modificar(Tecnics tecnics) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("update Tecnics set Codi_Tecnic=?, Nom=?, Cognoms=?, NIF=?, Adreça=?, Poblacio=?, Codi_Postal=?, Tel_Particular=?, Tel_Empresa=?, Extensio=? where Id=?");
            ps.setInt(1, tecnics.getCodi_Tecnic());
            ps.setString(2, tecnics.getNom());
            ps.setString(3, tecnics.getCognoms());
            ps.setString(4, tecnics.getNIF());
            ps.setString(5, tecnics.getAdreça());
            ps.setString(6, tecnics.getPoblacio());
            ps.setInt(7, tecnics.getCodi_Postal());
            ps.setInt(8, tecnics.getTel_Particular());
            ps.setInt(9, tecnics.getTel_Particular());
            ps.setInt(10, tecnics.getExtensio());
            ps.setInt(11, tecnics.getId());

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

    public boolean borrar(Tecnics tecnics) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("delete from Tecnics where Id=?");
            ps.setInt(1, tecnics.getId());

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
