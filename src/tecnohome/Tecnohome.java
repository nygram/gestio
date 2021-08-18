package tecnohome;

import controlador.controladorTecnics;
import modelo.Tecnics;
import modelo.consultesTecnics;
import vista.vistaEntrada;


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
