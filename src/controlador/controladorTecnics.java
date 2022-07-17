package controlador;

import Utils.Campos;
import Utils.Fechas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.Tecnics;
import modelo.Vehicles;
import modelo.consultesTecnics;
import modelo.consultesVehicles;
import vista.vistaTecnic;
import vista.vistaVehicle;

public class controladorTecnics implements ActionListener, MouseListener, WindowListener, KeyListener, ItemListener {

    private Tecnics tecnic;
    private vistaTecnic entrad;
    private consultesTecnics modelo;
    Calendar fecha = Calendar.getInstance();
    

    public controladorTecnics(Tecnics tecnic, vistaTecnic entrad, consultesTecnics modelo) {
        this.tecnic = tecnic;
        this.entrad = entrad;
        this.modelo = modelo;
        entrad.txtId.setText("1");
        entrad.btnInsertar.addActionListener(this);
        entrad.btnSalir.addActionListener(this);
        entrad.taulaTecnics.addMouseListener(this);
        entrad.jTabbedPane1.addMouseListener(this);
        entrad.taulaTecnics.addKeyListener(this);
        entrad.addWindowListener(this);
        entrad.btnModificar.addActionListener(this);
        entrad.btnNuevo.addActionListener(this);
        entrad.btnBorrar.addActionListener(this);
        modelo.carregaTecnic(1, entrad);
        

    }

    public void iniciar() {
        entrad.setTitle("Tecnohome");
        
        
        

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == entrad.taulaTecnics) {
            int fila = entrad.taulaTecnics.getSelectedRow();
            String codigo = entrad.taulaTecnics.getValueAt(fila, 0).toString();
            entrad.txtId.setText(codigo);
            if (me.getClickCount() == 2) {
                entrad.jTabbedPane1.setSelectedIndex(1);
                modelo.carregaTecnic(Integer.parseInt(codigo), entrad);

            }

        }
        /*
        if (me.getSource() == entrad.jTabbedPane1) {
            if (entrad.jTabbedPane1.getSelectedIndex() == 1) {
                String codi = entrad.txtId.getText();
                modelo.carregaTecnic(Integer.parseInt(codi), entrad);
            }
            if (entrad.jTabbedPane1.getSelectedIndex() == 0) {
                entrad.btnModificar.setVisible(false);
            }
        }
        */
    }

    @Override
    public void mousePressed(MouseEvent me
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {

    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == entrad.btnModificar) {

            if (entrad.jTabbedPane1.getSelectedIndex() == 1) {

                tecnic.setCodi_Postal(Integer.parseInt(entrad.txtCodipostal.getText()));
                tecnic.setCodi_Tecnic(Integer.parseInt(entrad.txtCodi.getText()));
                tecnic.setAdreça(entrad.txtAdreca.getText());
                tecnic.setCognoms(entrad.txtCognoms.getText());
                tecnic.setExtensio(Integer.parseInt(entrad.txtExtensio.getText()));
                tecnic.setNIF(entrad.txtNif.getText());
                tecnic.setNom(entrad.txtNom.getText());
                tecnic.setPoblacio(entrad.txtPoblacio.getText());
                tecnic.setTel_Empresa(Integer.parseInt(entrad.txtTelefonEmpresa.getText()));
                tecnic.setTel_Particular(Integer.parseInt(entrad.txtTelefonParticular.getText()));
                tecnic.setId(Integer.parseInt(entrad.txtId.getText()));

                if (modelo.modificar(tecnic)) {
                    entrad.jTabbedPane1.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Modificado correctamente");
                    modelo.carregaTaula(entrad);

                } else {
                    JOptionPane.showMessageDialog(null, "No modificado");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccion técnic a modificar");
            }

        }

        if (ae.getSource() == entrad.btnNuevo) {

            entrad.jTabbedPane1.setSelectedIndex(1);
            entrad.btnInsertar.setVisible(true);
            entrad.btnNuevo.setVisible(false);
            Campos.limpiarCampos(entrad.jPanel2);
            if (entrad.txtId.getText().isEmpty()) {
                entrad.txtId.setText("1");
            }
            //consultes.mostrarVehicle();

        }
        if (ae.getSource() == entrad.btnInsertar) {

            tecnic.setCodi_Postal(Integer.parseInt(entrad.txtCodipostal.getText()));
            tecnic.setCodi_Tecnic(Integer.parseInt(entrad.txtCodi.getText()));
            tecnic.setAdreça(entrad.txtAdreca.getText());
            tecnic.setCognoms(entrad.txtCognoms.getText());
            tecnic.setExtensio(Integer.parseInt(entrad.txtExtensio.getText()));
            tecnic.setNIF(entrad.txtNif.getText());
            tecnic.setNom(entrad.txtNom.getText());
            tecnic.setPoblacio(entrad.txtPoblacio.getText());
            tecnic.setTel_Empresa(Integer.parseInt(entrad.txtTelefonEmpresa.getText()));
            tecnic.setTel_Particular(Integer.parseInt(entrad.txtTelefonParticular.getText()));
            
            if (modelo.insertar(tecnic)) {
                entrad.jTabbedPane1.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Insertado correctamente");
                entrad.btnNuevo.setVisible(true);
                modelo.carregaTaula(entrad);
                

            } else {
                JOptionPane.showMessageDialog(null, "No insertado");
                entrad.btnNuevo.setVisible(true);
            }

        }

        if (ae.getSource() == entrad.btnSalir) {
            entrad.setVisible(false);
            
        }
        if (ae.getSource() == entrad.btnBorrar) {

            tecnic.setId(Integer.parseInt(entrad.txtId.getText()));

            if (modelo.borrar(tecnic)) {
                entrad.jTabbedPane1.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Borrado correctamente");
                modelo.carregaTaula(entrad);

            } else {
                JOptionPane.showMessageDialog(null, "No borrado");
            }

        }
        
    }

    @Override
    public void windowOpened(WindowEvent we){

        entrad.txtId.setText("1");
    }

    @Override
        public void windowClosing(WindowEvent we
    ) {
    }

    @Override
        public void windowClosed(WindowEvent we
    ) {
    }

    @Override
        public void windowIconified(WindowEvent we
    ) {
    }

    @Override
        public void windowDeiconified(WindowEvent we
    ) {
    }

    @Override
        public void windowActivated(WindowEvent we) {
        entrad.btnModificar.setVisible(false);
        entrad.btnInsertar.setVisible(false);
        modelo.carregaTaula(entrad);
        entrad.txtId.setText("1");
        entrad.txtId.setVisible(false);

    }

    @Override
        public void windowDeactivated(WindowEvent we) {

    }

    @Override
        public void keyTyped(KeyEvent e) {

    }

    @Override
        public void keyPressed(KeyEvent e) {
        int fila = entrad.taulaTecnics.getSelectedRow();
        String codigo = entrad.taulaTecnics.getValueAt(fila, 0).toString();
        entrad.txtId.setText(codigo);
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            entrad.jTabbedPane1.setSelectedIndex(1);
            modelo.carregaTecnic(Integer.parseInt(codigo), entrad);
            //modelo.carregaVehicle(Integer.parseInt(codigo), entrad);

        }
        
    }

    @Override
        public void keyReleased(KeyEvent evt) {
        try {
            if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {

                int fila = entrad.taulaTecnics.getSelectedRow();
                String codigo = entrad.taulaTecnics.getValueAt(fila, 0).toString();
                entrad.txtId.setText(codigo);

            }

        } catch (Exception ex) {

        }

    }

    @Override
        public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {

            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            try {
                PreparedStatement ps = conexion.prepareStatement("select id from Vehicles");
                ResultSet rs;
                rs = ps.executeQuery();

                //entrad.txtIdVehicle.setText(rs.getString("id"));

            } catch (Exception ex) {
                System.out.println("Error " + ex);
            }
        }
    }
}
