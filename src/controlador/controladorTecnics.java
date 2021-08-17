package controlador;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
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

public class controladorTecnics implements ActionListener, MouseListener, WindowListener, KeyListener {

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
        entrad.taulaTecnics.addKeyListener(this);
        entrad.addWindowListener(this);
        //vista.afegirButton.addActionListener(this);
        //vista.llistaButton.addActionListener(this);

    }

    public void iniciar() {
        // entrad.setTitle("Tecnohome");
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
    public void actionPerformed(ActionEvent ae
    ) {
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
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        entrad.taulaTecnics.setModel(modeloTabla);
        //taulaTecnics.setEnabled(false);

        entrad.jTabbedPane1.setSelectedIndex(0);

        PreparedStatement ps;
        ResultSet rs;

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select Id, nom, cognoms, nif, poblacio from tecnics");
            rs = ps.executeQuery();
            modeloTabla.addColumn("Codi");
            modeloTabla.addColumn("nom");
            modeloTabla.addColumn("cognoms");
            modeloTabla.addColumn("nif");
            modeloTabla.addColumn("poblacio");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);

                }
                modeloTabla.addRow(fila);
            }

        } catch (Exception e) {
            System.err.println("Error " + e);

        }
    }

    @Override
    public void windowDeactivated(WindowEvent we
    ) {
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

        PreparedStatement ps;
        ResultSet rs;

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select Id, codi_tecnic, nom, cognoms, nif, adreça, tel_particular, tel_empresa, extensio, codi_postal, poblacio from tecnics where Id = ?");
            ps.setInt(1, (codigo));
            System.out.println("codigo es " + codigo);
            rs = ps.executeQuery();

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

            }

        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Error " + ex);
        }

    }

}
