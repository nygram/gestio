package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consultesTecnics extends Conexion {

    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(Tecnics tecnics) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("insert into Tecnics (Codi_Tecnic, Nom, Cognoms, NIF, Adreça, Poblacio, Codi_Postal, Tel_Particular, Tel_Empresa, Extensio, Analitzador_Combustio, Targetes, Vehicle) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            ps.setString(11, tecnics.getAnalitzador_Combustio());
            ps.setString(12, tecnics.getTargetes());
            ps.setString(13, tecnics.getVehicle());

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
            } catch (Exception ex){
                System.err.println("Error " + ex);
                return false;
            }

        }
    }
    
    
    
    
}
