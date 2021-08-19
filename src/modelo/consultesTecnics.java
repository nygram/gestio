package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Tecnics;
import vista.vistaEntrada;

public class consultesTecnics extends Conexion {

    PreparedStatement ps;
    ResultSet rs;
    private int codigo;
    private vistaEntrada entrad;

    public boolean insertar(Tecnics tecnics) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("insert into Tecnics (Codi_Tecnic, Nom, Cognoms, NIF, Adreça, Poblacio, Codi_Postal, Tel_Particular, Tel_Empresa, Extensio) values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, tecnics.getCodi_Tecnic());
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
    
  
    public boolean modificar (Tecnics tecnics){
        
        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("update Tecnics set Codi_Tecnic=?, Nom=?, Cognoms=?, NIF=?, Adreça=?, Poblacio=?, Codi_Postal=?, Tel_Particular=?, Tel_Empresa=?, Extensio=? where Id=?");
            ps.setString(1, tecnics.getCodi_Tecnic());
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
            } catch (Exception ex){
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
            } catch (Exception ex){
                System.err.println("Error " + ex);
                return false;
            }

        }
    }
    
   
   
    
    
}
