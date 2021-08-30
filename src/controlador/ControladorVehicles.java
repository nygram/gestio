package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.Vehicles;
import modelo.ConsultesVehicles;
import vista.VistaVehicle;
import Utils.Fechas;


public class ControladorVehicles implements ActionListener, MouseListener, WindowListener, KeyListener {

    private Vehicles vehicle;
    //private vistaTecnic vista;
    private VistaVehicle vistavehicle;
    private ConsultesVehicles consvehicle;
    java.util.Date date = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 


    public ControladorVehicles(Vehicles vehicle, VistaVehicle vistavehicle, ConsultesVehicles consvehicle) {
        this.vehicle = vehicle;
        this.vistavehicle = vistavehicle;
        this.consvehicle = consvehicle;

        vistavehicle.btnInsertar.addActionListener(this);
        vistavehicle.taulaVehicles.addMouseListener(this);
        vistavehicle.taulaVehicles.addKeyListener(this);
        vistavehicle.jTabbedPane1.addMouseListener(this);
        vistavehicle.btnInsertar.addMouseListener(this);
        vistavehicle.addWindowListener(this);
        
    }

    public void iniciar() {
        vistavehicle.setLocationRelativeTo(null);
        System.out.println("hola");
        consvehicle.carregaTaula(vistavehicle);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistavehicle.btnInsertar){
            
            
                vehicle.setModel(vistavehicle.txtModel.getText());
                vehicle.setMatricula((vistavehicle.txtMatricula.getText()));
                vehicle.setMarca(vistavehicle.txtMarca.getText());
                vehicle.setRenting(vistavehicle.txtRenting.getText());
                vehicle.setData_entrada(Fechas.dameFecha(vistavehicle.txtDataEntrada));
                vehicle.setDate_final(Fechas.dameFecha(vistavehicle.txtDataFinal));
                vehicle.setCombustible(vistavehicle.txtCombustible.getText());
                vehicle.setPany_seguretat(Boolean.getBoolean(vistavehicle.txtPany.getText()));
                vehicle.setPropera_revisio(Fechas.dameFecha(vistavehicle.txtPropRevisio));
                vehicle.setCopia_claus(Boolean.getBoolean(vistavehicle.txtCopiaClaus.getText()));
                
                
                if (consvehicle.insertar(vehicle)){
                    vistavehicle.jTabbedPane1.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Insertado correctamente");
                    //vistavehicle.btnNuevo.setVisible(true);
                    consvehicle.carregaTaula(vistavehicle);
                    
                    
                }else {
                    JOptionPane.showMessageDialog(null, "No insertado");
                }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vistavehicle.taulaVehicles) {
            int fila = vistavehicle.taulaVehicles.getSelectedRow();
            String codigo = vistavehicle.taulaVehicles.getValueAt(fila, 0).toString();
            vistavehicle.txtId.setText(codigo);
            if (me.getClickCount() == 2) {
                vistavehicle.jTabbedPane1.setSelectedIndex(1);
                consvehicle.carregaVehicle(Integer.parseInt(codigo), vistavehicle);

            }

        }
        if (me.getSource() == vistavehicle.jTabbedPane1) {
            if (vistavehicle.jTabbedPane1.getSelectedIndex() == 1) {
                String codi = vistavehicle.txtId.getText();
                consvehicle.carregaVehicle(Integer.parseInt(codi), vistavehicle);
            }
           // if (vistavehicle.jTabbedPane1.getSelectedIndex() == 0) {
           //     vistavehicle.btnModificar.setVisible(false);
           // }
        }

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
        consvehicle.carregaTaula(vistavehicle);
        
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
