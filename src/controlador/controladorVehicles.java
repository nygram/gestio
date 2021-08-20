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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.Vehicles;
import modelo.consultesVehicles;
import vista.vistaVehicle;


public class controladorVehicles implements ActionListener, MouseListener, WindowListener, KeyListener {

    private Vehicles vehicle;
    //private vistaTecnic vista;
    private vistaVehicle vistavehicle;
    private consultesVehicles consvehicle;

    public controladorVehicles(Vehicles vehicle, vistaVehicle vistavehicle, consultesVehicles consvehicle) {
        this.vehicle = vehicle;
        this.vistavehicle = vistavehicle;
        this.consvehicle = consvehicle;

        vistavehicle.btnInsertar.addActionListener(this);
        vistavehicle.taulaVehicles.addMouseListener(this);
        vistavehicle.taulaVehicles.addKeyListener(this);
        vistavehicle.jTabbedPane1.addMouseListener(this);
        vistavehicle.btnInsertar.addMouseListener(this);
        //vistavehicle.addWindowListener(this);
        
        /*  
        
        vistavehicle.btnSalir.addActionListener(this);
        vistavehicle.btnModificar.addActionListener(this);
        vistavehicle.btnNuevo.addActionListener(this);
        vistavehicle.btnBorrar.addActionListener(this);
         */
    }

    public void iniciar() {
        //vistavehicle.setTitle("Tecnohome");
        vistavehicle.setLocationRelativeTo(null);
        System.out.println("hola");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistavehicle.btnInsertar){
            
            
                vehicle.setModel(vistavehicle.txtModel.getText());
                vehicle.setMatricula((vistavehicle.txtMatricula.getText()));
                vehicle.setMarca(vistavehicle.txtMarca.getText());
                vehicle.setRenting(vistavehicle.txtRenting.getText());
                vehicle.setData_entrada(Date.valueOf(vistavehicle.txtDataEntrada.getText()));
                vehicle.setDate_final(Date.valueOf(vistavehicle.txtDataFinal.getText()));
                vehicle.setPany_seguretat(Boolean.getBoolean(vistavehicle.txtPany.getText()));
                vehicle.setPropera_revisio(Date.valueOf(vistavehicle.txtPropRevisio.getText()));
                vehicle.setCopia_claus(Boolean.getBoolean(vistavehicle.txtCopiaClaus.getText()));
                
                if (consvehicle.insertar(vehicle)){
                    vistavehicle.jTabbedPane1.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Insertado correctamente");
                    //vistavehicle.btnNuevo.setVisible(true);
                    carregaTaula();
                    
                    
                }else {
                    JOptionPane.showMessageDialog(null, "No insertado");
                }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vistavehicle.btnInsertar){
            System.out.println("hola");
            
            
                vehicle.setModel(vistavehicle.txtModel.getText());
                vehicle.setMatricula((vistavehicle.txtMatricula.getText()));
                vehicle.setMarca(vistavehicle.txtMarca.getText());
                vehicle.setRenting(vistavehicle.txtRenting.getText());
                vehicle.setData_entrada(Date.valueOf(vistavehicle.txtDataEntrada.getText()));
                vehicle.setDate_final(Date.valueOf(vistavehicle.txtDataFinal.getText()));
                vehicle.setPany_seguretat(Boolean.getBoolean(vistavehicle.txtPany.getText()));
                vehicle.setPropera_revisio(Date.valueOf(vistavehicle.txtPropRevisio.getText()));
                vehicle.setCopia_claus(Boolean.getBoolean(vistavehicle.txtCopiaClaus.getText()));
                
                if (consvehicle.insertar(vehicle)){
                    vistavehicle.jTabbedPane1.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Insertado correctamente");
                    //vistavehicle.btnNuevo.setVisible(true);
                    carregaTaula();
                    
                    
                }else {
                    JOptionPane.showMessageDialog(null, "No insertado");
                }
            
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
    
    public void carregaTaula() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

        };
        vistavehicle.taulaVehicles.setModel(modeloTabla);
        vistavehicle.taulaVehicles.setRowSorter(new TableRowSorter<DefaultTableModel>(modeloTabla));
        vistavehicle.taulaVehicles.setAutoCreateRowSorter(true);
        vistavehicle.taulaVehicles.setBackground(Color.white);
        vistavehicle.taulaVehicles.setSelectionBackground(new Color(250, 201, 104));

        vistavehicle.txtId.setText(null);
        //taulaVehicles.setEnabled(false);
        //vistavehicle.btnModificar.setVisible(false);
        vistavehicle.jTabbedPane1.setSelectedIndex(0);

        PreparedStatement ps;
        ResultSet rs;

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select Id, matricula, model from vehicles order by id");
            rs = ps.executeQuery();
            modeloTabla.addColumn("Id");
            modeloTabla.addColumn("Matricula");
            modeloTabla.addColumn("model");

            while (rs.next()) {
                Object fila[] = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i+1);

                }
                modeloTabla.addRow(fila);
            }
            rs.close();
            vistavehicle.txtId.setText("1");

        } catch (Exception e) {
            System.err.println("Error " + e);

        }
    }

}
