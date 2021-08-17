
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static final String URL = "jdbc:postgresql://localhost:5432/Tecnohome";
    public static final String Usuari = "nygram";
    public static final String Contrasenya = "wolsimjonar";
    
    
    
    public Connection getConnection(){
        Connection connexio = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            connexio = (Connection) DriverManager.getConnection(URL, Usuari, Contrasenya);
            //JOptionPane.showMessageDialog(null, "Connexión correcta");
        }catch(Exception ex){
            System.err.println("Error, "+ex);
                 
        }
        return connexio;
    }
    
}
