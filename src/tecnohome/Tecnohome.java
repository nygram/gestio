package tecnohome;

import controlador.ControladorEntrada;
import controlador.controladorTecnics;
import controlador.controladorVehicles;
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
