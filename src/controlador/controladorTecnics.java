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
import modelo.VehicleDetalls;
import modelo.Vehicles;
import modelo.consultesTecnics;
import modelo.consultesVehicles;
import vista.vistaEntrada;
import vista.vistaVehicle;
//import vista.vistaTecnic;

public class controladorTecnics implements ActionListener, MouseListener, WindowListener, KeyListener, ItemListener {

    private Tecnics tecnic;
    private Vehicles vehicle;
    private VehicleDetalls detalls;
    private vistaEntrada entrad;
    private consultesTecnics modelo;
    private consultesVehicles consultes;
    private vistaVehicle vehicles;
    Calendar fecha = Calendar.getInstance();

    public controladorTecnics(Tecnics tecnic, vistaEntrada entrad, consultesTecnics modelo, VehicleDetalls detalls) {
        this.tecnic = tecnic;
        this.detalls = detalls;
        this.entrad = entrad;
        this.modelo = modelo;
        entrad.btnInsertar.addActionListener(this);
        entrad.btnSalir.addActionListener(this);
        entrad.taulaTecnics.addMouseListener(this);
        entrad.jTabbedPane1.addMouseListener(this);
        entrad.taulaTecnics.addKeyListener(this);
        entrad.addWindowListener(this);
        entrad.btnModificar.addActionListener(this);
        entrad.btnNuevo.addActionListener(this);
        entrad.btnBorrar.addActionListener(this);
        entrad.btnVehicles.addActionListener(this);
        entrad.cbVehicle.addActionListener(this);

    }

    public void iniciar() {
        entrad.setLocationRelativeTo(null);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == entrad.taulaTecnics) {
            int fila = entrad.taulaTecnics.getSelectedRow();
            String codigo = entrad.taulaTecnics.getValueAt(fila, 0).toString();
            entrad.txtId.setText(codigo);
            if (me.getClickCount() == 2) {
                entrad.jTabbedPane1.setSelectedIndex(1);
                carregaTecnic(Integer.parseInt(codigo));

            }

        }
        if (me.getSource() == entrad.jTabbedPane1) {
            if (entrad.jTabbedPane1.getSelectedIndex() == 1) {
                String codi = entrad.txtId.getText();
                carregaTecnic(Integer.parseInt(codi));
            }
            if (entrad.jTabbedPane1.getSelectedIndex() == 0) {
                entrad.btnModificar.setVisible(false);
            }
        }

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
                    carregaTaula();

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
            consultes.mostrarVehicle();

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
            detalls.setData_trans((Fechas.getFechaActual()));
            detalls.setIdTecnic(Integer.parseInt(entrad.txtId.getText()));
            detalls.setIdVehicle(Integer.parseInt(entrad.txtIdVehicle.getText()));

            if (modelo.insertar(tecnic, detalls)) {
                entrad.jTabbedPane1.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Insertado correctamente");
                entrad.btnNuevo.setVisible(true);
                carregaTaula();

            } else {
                JOptionPane.showMessageDialog(null, "No insertado");
            }

        }
        if (ae.getSource() == entrad.btnSalir) {
            System.exit(0);
        }
        if (ae.getSource() == entrad.btnBorrar) {

            tecnic.setId(Integer.parseInt(entrad.txtId.getText()));

            if (modelo.borrar(tecnic)) {
                entrad.jTabbedPane1.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Borrado correctamente");
                carregaTaula();

            } else {
                JOptionPane.showMessageDialog(null, "No borrado");
            }

        }
        if (ae.getSource() == entrad.btnVehicles) {

            consultesVehicles consultavehicle = new consultesVehicles();
            Vehicles vehicle = new Vehicles();
            vistaVehicle vista = new vistaVehicle();
            controladorVehicles controlavehicles = new controladorVehicles(vehicle, vista, consultavehicle);
            vista.setVisible(true);

        }
        if (ae.getSource() == entrad.cbVehicle) {

            entrad.txtIdVehicle.setText(Integer.toString(entrad.cbVehicle.getSelectedIndex()));
        }

    }

    @Override
    public void windowOpened(WindowEvent we
    ) {
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
        carregaTaula();

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
            carregaTecnic(Integer.parseInt(codigo));

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

    public void carregaTecnic(int codigo) {

        PreparedStatement ps, ps2;
        ResultSet rs, rs2;
        entrad.btnModificar.setVisible(true);
        consultesVehicles vehicle = new consultesVehicles();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel((Vector) vehicle.mostrarVehicle());
        entrad.cbVehicle.setModel(modeloCombo);
        

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select t.Id, t.codi_tecnic, t.nom, t.cognoms, t.nif, t.adreça, t.tel_particular, t.tel_empresa, t.extensio, t.codi_postal, t.poblacio, v.matricula from tecnics t, vehicles v, detallsvehicle d where t.Id = ? AND t.id = d.idtecnic AND v.id=d.idvehicle");
            //ps2 = conexion.prepareStatement("Select d.id, v.matricula from vehicles v, detallsVehicle d where d.idtecnic=? AND v.id = d.idvehicle");
            ps.setInt(1, ((codigo)));
            //ps2.setInt(1, ((codigo)));
            rs = ps.executeQuery();
            //rs2 = ps2.executeQuery();

            while (rs.next()) {
                entrad.txtNif.setText(rs.getString("Nif"));
                entrad.txtAdreca.setText(rs.getString("Adreça"));
                entrad.txtNom.setText(rs.getString("Nom"));
                entrad.txtCodipostal.setText(rs.getString("Codi_Postal"));
                entrad.txtCognoms.setText(rs.getString("Cognoms"));
                entrad.txtPoblacio.setText(rs.getString("poblacio"));
                entrad.txtCodi.setText(rs.getString("codi_tecnic"));
                entrad.txtTelefonParticular.setText(rs.getString("tel_particular"));
                entrad.txtTelefonEmpresa.setText(rs.getString("tel_empresa"));
                entrad.txtExtensio.setText(rs.getString("extensio"));
                entrad.txtId.setText(rs.getString("Id"));
                entrad.txtVehicle.setText(rs.getString("matricula"));

            }

           //while (rs2.next()) {
           //     entrad.txtIdVehicle.setText(rs2.getString("id"));
           //     entrad.cbVehicle.addItem("matricula");
           // }
            rs.close();
            //rs2.close();
            //habilitarCampos(entrad.jPanel2, false);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error " + ex);
        }

    }

    public void carregaTaula() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

        };
        entrad.taulaTecnics.setModel(modeloTabla);
        entrad.taulaTecnics.setRowSorter(new TableRowSorter<DefaultTableModel>(modeloTabla));
        entrad.taulaTecnics.setAutoCreateRowSorter(true);
        entrad.taulaTecnics.setBackground(Color.white);
        entrad.taulaTecnics.setSelectionBackground(new Color(250, 201, 104));

        entrad.txtId.setText(null);
        //taulaTecnics.setEnabled(false);
        entrad.btnModificar.setVisible(false);
        entrad.jTabbedPane1.setSelectedIndex(0);

        PreparedStatement ps;
        ResultSet rs;

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select Id, codi_tecnic, nom, cognoms, nif, poblacio from tecnics order by id");
            rs = ps.executeQuery();
            modeloTabla.addColumn("Id");
            modeloTabla.addColumn("Codi");
            modeloTabla.addColumn("nom");
            modeloTabla.addColumn("cognoms");
            modeloTabla.addColumn("nif");
            modeloTabla.addColumn("poblacio");

            while (rs.next()) {
                Object fila[] = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);

                }
                modeloTabla.addRow(fila);
            }
            rs.close();
            entrad.txtId.setText("1");

        } catch (Exception e) {
            System.err.println("Error " + e);

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Vehicles vehicle = (Vehicles) entrad.cbVehicle.getSelectedItem();

            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            try {
                PreparedStatement ps = conexion.prepareStatement("select id from Vehicles");
                ResultSet rs;
                rs = ps.executeQuery();

                entrad.txtIdVehicle.setText(rs.getString("id"));

            } catch (Exception ex) {
                System.out.println("Error " + ex);
            }
        }
    }
}
