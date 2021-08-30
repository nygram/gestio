package tecnohome;

import controlador.controladorTecnics;
import controlador.controladorVehicles;
import modelo.Tecnics;
import modelo.VehicleDetalls;
import modelo.Vehicles;
import modelo.consultesTecnics;
import modelo.consultesVehicles;
import vista.vistaTecnic;
import vista.vistaVehicle;


public class Tecnohome {

    public static void main(String[] args) {
        
        Tecnics tecnic = new Tecnics();
        consultesTecnics modelo = new consultesTecnics();
        vistaTecnic entrada = new vistaTecnic();
        VehicleDetalls detalls = new VehicleDetalls();
        controladorTecnics controlador = new controladorTecnics(tecnic, entrada, modelo, detalls);
        
        controlador.iniciar();
        entrada.setVisible(true);
        entrada.jTabbedPane1.setSelectedIndex(0);
        

    }
}
