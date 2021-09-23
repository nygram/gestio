/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Tecnics;
import modelo.Vehicles;
import modelo.consultesTecnics;
import modelo.consultesVehicles;
import vista.Entrada;
import vista.vistaTecnic;
import vista.vistaVehicle;

/**
 *
 * @author JavierFernándezDíaz
 */
public class ControladorEntrada implements ActionListener, MouseListener {

    private Entrada vista;

    public ControladorEntrada(Entrada vista) {
        this.vista = vista;
        vista.btnTecnics.addActionListener(this);
        vista.btnTecnics.addMouseListener(this);
        vista.btnVehicles.addActionListener(this);
        vista.btnVehicles.addMouseListener(this);
    }

    public void iniciar() {
        vista.setTitle("Entrada");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnTecnics) {
            Tecnics tecnic = new Tecnics();
            vistaTecnic v = new vistaTecnic();
            consultesTecnics modelo = new consultesTecnics();
            controladorTecnics controlatecnics = new controladorTecnics(tecnic, v, modelo);
            v.setVisible(true);
            v.txtId.setVisible(false);
        }
        if (e.getSource() == vista.btnVehicles) {
            Vehicles vehicle = new Vehicles();
            vistaVehicle v = new vistaVehicle();
            consultesVehicles modelo = new consultesVehicles();
            controladorVehicles controlavehicles = new controladorVehicles(vehicle, v, modelo);
            v.setVisible(true);
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       /*
        if (e.getSource() == vista.btnTecnics) {
            Tecnics tecnic = new Tecnics();
            vistaTecnic v = new vistaTecnic();
            consultesTecnics modelo = new consultesTecnics();
            controladorTecnics controlatecnics = new controladorTecnics(tecnic, v, modelo);
            v.setVisible(true);
        }
        if (e.getSource() == vista.btnVehicles){
            Vehicles vehicle = new Vehicles();
            vistaVehicle v = new vistaVehicle();
            consultesVehicles modelo = new consultesVehicles();
            controladorVehicles controlavehicles = new controladorVehicles(vehicle, v, modelo);
            v.setVisible(true);
        }
*/
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

}