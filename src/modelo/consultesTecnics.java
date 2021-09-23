package modelo;

import Utils.Fechas;
import static Utils.Fechas.dameFecha;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;
import modelo.Tecnics;
import modelo.Vehicles;
import vista.vistaTecnic;

public class consultesTecnics extends Conexion {

    PreparedStatement ps, ps2;
    ResultSet rs;
    private int codigo;
    private vistaTecnic entrad;
    Date fecha;

    public boolean insertar(Tecnics tecnics) {

        Connection conexio = getConnection();

        try {

            ps = conexio.prepareStatement("insert into Tecnics (Codi_Tecnic, Nom, Cognoms, NIF, Adreça, Poblacio, Codi_Postal, Tel_Particular, Tel_Empresa, Extensio) values (?,?,?,?,?,?,?,?,?,?)");

           
            ps.setInt(1, tecnics.getCodi_Tecnic());
            ps.setString(2, tecnics.getNom());
            ps.setString(3, tecnics.getCognoms());
            ps.setString(4, tecnics.getNIF());
            ps.setString(5, tecnics.getAdreça());
            ps.setString(6, tecnics.getPoblacio());
            ps.setInt(7, tecnics.getCodi_Postal());
            ps.setInt(8, tecnics.getTel_Particular());
            ps.setInt(9, tecnics.getTel_Particular());
            ps.setInt(10, tecnics.getExtensio());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;

            } else {
                
                return false;
            }
            
        } catch (Exception ex) {
            System.err.println("Error " + ex);
            return false;
            
        } finally {
            try {
                conexio.close();
            } catch (Exception ex) {
                System.err.println("Error " + ex);
                return false;
            }

        }
    }

    public boolean modificar(Tecnics tecnics) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("update Tecnics set Codi_Tecnic=?, Nom=?, Cognoms=?, NIF=?, Adreça=?, Poblacio=?, Codi_Postal=?, Tel_Particular=?, Tel_Empresa=?, Extensio=? where Id=?");
            ps.setInt(1, tecnics.getCodi_Tecnic());
            ps.setString(2, tecnics.getNom());
            ps.setString(3, tecnics.getCognoms());
            ps.setString(4, tecnics.getNIF());
            ps.setString(5, tecnics.getAdreça());
            ps.setString(6, tecnics.getPoblacio());
            ps.setInt(7, tecnics.getCodi_Postal());
            ps.setInt(8, tecnics.getTel_Particular());
            ps.setInt(9, tecnics.getTel_Particular());
            ps.setInt(10, tecnics.getExtensio());
            ps.setInt(11, tecnics.getId());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;

            } else {
                return false;
            }

        } catch (Exception ex) {
            System.err.println("Error " + ex);

            return false;
        } finally {
            try {
                conexio.close();
            } catch (Exception ex) {
                System.err.println("Error " + ex);
                return false;
            }

        }

    }

    public boolean borrar(Tecnics tecnics) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("delete from Tecnics where Id=?");
            ps.setInt(1, tecnics.getId());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;

            } else {
                return false;
            }

        } catch (Exception ex) {
            System.err.println("Error " + ex);

            return false;
        } finally {
            try {
                conexio.close();
            } catch (Exception ex) {
                System.err.println("Error " + ex);
                return false;
            }

        }
    }

    public void carregaVehicle(int codigo, vistaTecnic entrad) {
        this.entrad = entrad;
        PreparedStatement ps;
        ResultSet rs;
        entrad.btnModificar.setVisible(true);
        
        try{
            
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("Select matricula from detallsvehicle d "
                    + "inner join vehicles v ON v.id = d.idvehicle "
                    + "inner join tecnics t ON ? = d.idtecnic "
                    + "GROUP BY matricula");
            ps.setInt(1, ((codigo)));
            
            rs = ps.executeQuery();
            
            rs.close();
            
            
        }catch(Exception ex){
            System.out.println("Excepcion "+ex);
        }

    }


    public void carregaTecnic(int codigo, vistaTecnic entrad) {

        this.entrad = entrad;
        this.codigo = codigo;
        PreparedStatement ps;
        ResultSet rs;
        entrad.btnModificar.setVisible(true);

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select * from tecnics where Id = ?");
            
            ps.setInt(1, ((codigo)));
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

            
            rs.close();
            

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error " + ex);
        }

    }

    public void carregaTaula(vistaTecnic entrad) {

        this.entrad = entrad;

        DefaultTableModel modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        entrad.taulaTecnics.setModel(modeloTabla);
        entrad.taulaTecnics.setRowSorter(new TableRowSorter<DefaultTableModel>(modeloTabla));
        entrad.taulaTecnics.setAutoCreateRowSorter(true);
        entrad.taulaTecnics.setBackground(Color.WHITE);
        entrad.taulaTecnics.setSelectionBackground(new Color(250, 201, 104));
        entrad.taulaTecnics.setOpaque(true);
        
        entrad.txtId.setText(null);
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

        } catch (Exception e) {
            System.err.println("Error " + e);

        }
    }
     
}
