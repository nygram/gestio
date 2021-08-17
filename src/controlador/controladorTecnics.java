package controlador;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.LinkedList;
import javax.naming.InterruptedNamingException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Tecnics;
import modelo.consultesTecnics;
import vista.vistaEntrada;
//import vista.vistaTecnic;

public class controladorTecnics implements ActionListener, MouseListener, WindowListener {

    private Tecnics tecnic;
    //private vistaTecnic vista;
    private vistaEntrada entrad;
    private consultesTecnics modelo;

    public controladorTecnics(Tecnics tecnic, vistaEntrada entrad, consultesTecnics modelo) {
        this.tecnic = tecnic;
        //this.vista = vista;
        this.entrad = entrad;
        this.modelo = modelo;
        entrad.cargarButton.addActionListener(this);
        entrad.tornarButton.addActionListener(this);
        entrad.taulaTecnics.addMouseListener(this);
        entrad.addWindowListener(this);
        //vista.afegirButton.addActionListener(this);
        //vista.llistaButton.addActionListener(this);
        
    }

    public void iniciar() {
       // entrad.setTitle("Tecnohome");
        entrad.setLocationRelativeTo(null);
        
        
        

    }
/*
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.afegirButton) {
            tecnic.setCodi_Tecnic(Integer.parseInt(vista.txtCodi.getText()));
            tecnic.setNom(vista.txtNom.getText());
            tecnic.setCognoms(vista.txtCognoms.getText());
            tecnic.setNIF(vista.txtNif.getText());
            tecnic.setAdreça(vista.txtAdreca.getText());
            tecnic.setPoblacio(vista.txtPoblacio.getText());
            tecnic.setCodi_Postal(Integer.parseInt(vista.txtCodipostal.getText()));
            tecnic.setTel_Particular(Integer.parseInt(vista.txtTelefonParticular.getText()));
            tecnic.setTel_Empresa(Integer.parseInt(vista.txtTelefonEmpresa.getText()));
            tecnic.setExtensio(Integer.parseInt(vista.txtExtensio.getText()));
            //tecnic.setAnalitzador_Combustio(vista.Analitzador_Combustio.getText());
            //tecnic.setTargetes(vista.Targetes.getText());
            //tecnic.setVehicle(vista.Vehicle.getText());
            

            if (modelo.insertar(tecnic)) {
                JOptionPane.showMessageDialog(null, "correcto");
                limpiar();
                

            }
            
            
            else {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }if (e.getSource() == vista.llistaButton) {
            vistaEntrada entrada = new vistaEntrada();
            entrada.setVisible(true);
            //vista.setVisible(false);
        }
         {
            
        }
    }
    
    
    public void limpiar(){
        vista.txtCodi.setText(null);
        vista.txtNom.setText(null);
        vista.txtCognoms.setText(null);
        vista.txtNif.setText(null);
        vista.txtCodipostal.setText(null);
        vista.txtAdreca.setText(null);
        vista.txtPoblacio.setText(null);
        vista.txtTelefonEmpresa.setText(null);
        vista.txtTelefonParticular.setText(null);
        vista.txtExtensio.setText(null);
    }

*/
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == entrad.taulaTecnics){
        int fila = entrad.taulaTecnics.getSelectedRow();
        String codigo = entrad.taulaTecnics.getValueAt(fila, 0).toString();
        entrad.txtId.setText(codigo);
                
                
                }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
         DefaultTableModel modeloTabla = new DefaultTableModel(){
          public boolean isCellEditable(int rowIndex,int columnIndex){
          return false;}
         };
        entrad.taulaTecnics.setModel(modeloTabla);
        //taulaTecnics.setEnabled(false);
        
        entrad.jTabbedPane1.setSelectedIndex(0);
        
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            
            Conexion con = new Conexion();
            
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("Select Id, nom, cognoms, nif, poblacio from tecnics");
            rs = ps.executeQuery();
            modeloTabla.addColumn("Id");
            modeloTabla.addColumn("nom");
            modeloTabla.addColumn("cognoms");
            modeloTabla.addColumn("nif");
            modeloTabla.addColumn("poblacio");
            
            while(rs.next()){
                Object fila [] = new Object [5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i+1);
                    
                    
                }
                modeloTabla.addRow(fila);
            }
            
            
            
            
            
            
        }catch (Exception e){
            System.err.println("Error " +e);
            
        }
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

}
