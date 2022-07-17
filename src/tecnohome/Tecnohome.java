package tecnohome;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import controlador.ControladorEntrada;
import controlador.controladorTecnics;
import controlador.controladorVehicles;
import javax.swing.UIManager;
import modelo.Tecnics;
//import modelo.VehicleDetalls;
import modelo.Vehicles;
import modelo.consultesTecnics;
import modelo.consultesVehicles;
import vista.Entrada;
import vista.vistaTecnic;
import vista.vistaVehicle;


public class Tecnohome {

    public static void main(String[] args) {
        
        try{
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Tecnics tecnic = new Tecnics();
        //consultesTecnics modelo = new consultesTecnics();
        Entrada vista = new Entrada();
        //vistaTecnic entrada = new vistaTecnic();
        ControladorEntrada controlador = new ControladorEntrada(vista);
        
        //controlador.iniciar();
        vista.setVisible(true);
        //entrada.jTabbedPane1.setSelectedIndex(0);
        
        

    }
}
