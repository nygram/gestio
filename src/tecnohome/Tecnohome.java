package tecnohome;

import controlador.ControladorTecnics;
import controlador.ControladorVehicles;
import modelo.Tecnics;
import modelo.VehicleDetalls;
import modelo.Vehicles;
import modelo.ConsultesTecnics;
import modelo.ConsultesVehicles;
import vista.VistaTecnic;
import vista.VistaVehicle;


public class Tecnohome {

    public static void main(String[] args) {
        
        Tecnics tecnic = new Tecnics();
        ConsultesTecnics modelo = new ConsultesTecnics();
        VistaTecnic entrada = new VistaTecnic();
        VehicleDetalls detalls = new VehicleDetalls();
        ControladorTecnics controlador = new ControladorTecnics(tecnic, entrada, modelo, detalls);
        
        controlador.iniciar();
        entrada.setVisible(true);
        entrada.jTabbedPane1.setSelectedIndex(0);
        

    }
}
