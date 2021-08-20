package tecnohome;

import controlador.controladorTecnics;
import controlador.controladorVehicles;
import modelo.Tecnics;
import modelo.Vehicles;
import modelo.consultesTecnics;
import modelo.consultesVehicles;
import vista.vistaEntrada;
import vista.vistaVehicle;


public class Tecnohome {

    public static void main(String[] args) {
        
        //vistaTecnic vista = new vistaTecnic();
        Tecnics tecnic = new Tecnics();
        consultesTecnics modelo = new consultesTecnics();
        vistaEntrada entrada = new vistaEntrada();
        controladorTecnics controlador = new controladorTecnics(tecnic, entrada, modelo);
        
        controlador.iniciar();
        entrada.setVisible(true);
        entrada.jTabbedPane1.setSelectedIndex(0);
        

    }
}
