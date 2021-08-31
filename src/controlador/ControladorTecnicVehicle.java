
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import modelo.ConsultesTecnicVehicle;
import modelo.Tecnics;
import modelo.VehicleDetalls;
import modelo.Vehicles;
import modelo.consultesTecnics;
import modelo.consultesVehicles;
import vista.vistaTecnic;
import vista.vistaVehicle;
import vista.VistaTecnicVehicle;


    
    public class ControladorTecnicVehicle implements ActionListener, MouseListener, WindowListener, KeyListener, ItemListener {

    private Tecnics tecnic;
    private Vehicles vehicle;
    private VehicleDetalls detalls;
    private VistaTecnicVehicle entrad;
    private ConsultesTecnicVehicle modelo;
    private consultesVehicles consultes;
    private vistaVehicle vehicles;
    Calendar fecha = Calendar.getInstance();

    public ControladorTecnicVehicle(Tecnics tecnic, VistaTecnicVehicle entrad, ConsultesTecnicVehicle modelo, VehicleDetalls detalls, Vehicles vehicle) {
        this.tecnic = tecnic;
        this.detalls = detalls;
        this.entrad = entrad;
        this.modelo = modelo;
        this.vehicle = vehicle;
        
        
        
        entrad.addWindowListener(this);
        
       

    }

    public void iniciar() {
        entrad.setLocationRelativeTo(null);
        modelo.carregaTaula(entrad);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
         modelo.carregaTaula(entrad);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
    
}
