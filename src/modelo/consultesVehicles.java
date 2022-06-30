
package modelo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import vista.vistaVehicle;
import modelo.Conexion;
import vista.vistaTecnic;

public class consultesVehicles extends Conexion {

    PreparedStatement ps;
    ResultSet rs;
    private int codigo;
    private Vehicles vehicles;
    private vistaVehicle vista;

    public boolean insertar(Vehicles vehicles) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("insert into vehicles (matricula, marca, model, combustible, renting, data_entrada, data_final, pany_seguretat, copiaclaus, propera_revisio) values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vehicles.getMatricula());
            ps.setString(2, vehicles.getMarca());
            ps.setString(3, vehicles.getModel());
            ps.setString(4, vehicles.getCombustible());
            ps.setString(5, vehicles.getRenting());
            ps.setDate(6, vehicles.getData_entrada());
            ps.setDate(7, vehicles.getDate_final());
            ps.setBoolean(8, vehicles.getPany_seguretat());
            ps.setBoolean(9, vehicles.getCopia_claus());
            ps.setDate(10, vehicles.getPropera_revisio());

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
    
    public boolean borrar(Vehicles vehicles) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("delete from vehicles where Id=?");
            ps.setInt(1, vehicles.getId());

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
    
    public boolean modificar(Vehicles vehicles) {

        Connection conexio = getConnection();

        try {
            ps = conexio.prepareStatement("update vehicles set matricula=?, marca=?, model=?, combustible=?, renting=?, data_entrada=?, data_final=?, pany_seguretat=?, copiaclaus=?, propera_revisio=? where id = ?");
            ps.setString(1, vehicles.getMatricula());
            ps.setString(2, vehicles.getMarca());
            ps.setString(3, vehicles.getModel());
            ps.setString(4, vehicles.getCombustible());
            ps.setString(5, vehicles.getRenting());
            ps.setDate(6, vehicles.getData_entrada());
            ps.setDate(7, vehicles.getDate_final());
            ps.setBoolean(8, vehicles.getPany_seguretat());
            ps.setBoolean(9, vehicles.getCopia_claus());
            ps.setDate(10, vehicles.getPropera_revisio());
            ps.setInt(11, vehicles.getId());

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

    public List<Vehicles> mostrarVehicle() {

        Vector<Vehicles> listVehicles = new Vector<Vehicles>();
        Vehicles vehicle = new Vehicles();

        try {
            Connection conexio = getConnection();

            ps = conexio.prepareStatement("select * from vehicles");
            rs = ps.executeQuery();

            vehicle.setId(0);
            vehicle.setMatricula("Selecciona un vehicle");
            listVehicles.add(vehicle);

            while (rs.next()) {
                vehicle = new Vehicles();
                vehicle.setId(rs.getInt("id"));
                vehicle.setMatricula(rs.getString("matricula"));
                vehicle.setMarca(rs.getString("marca"));
                listVehicles.add(vehicle);
            }
            rs.close();

        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
        return listVehicles;
    }

    public void carregaTaula(vistaVehicle vista) {
        this.vista = vista;
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

        };

        vista.taulaVehicles.setModel(modeloTabla);
        vista.taulaVehicles.setRowSorter(new TableRowSorter<DefaultTableModel>(modeloTabla));
        vista.taulaVehicles.setAutoCreateRowSorter(true);
        vista.taulaVehicles.setBackground(Color.white);
        vista.taulaVehicles.setSelectionBackground(new Color(250, 201, 104));
        vista.txtId.setText(null);
        vista.jTabbedPane1.setSelectedIndex(0);

        PreparedStatement ps;
        ResultSet rs;

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select Id, matricula, model from vehicles order by id");
            rs = ps.executeQuery();
            modeloTabla.addColumn("Id");
            modeloTabla.addColumn("matricula");
            modeloTabla.addColumn("model");

            while (rs.next()) {
                Object fila[] = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
            rs.close();
            vista.txtId.setText("1");

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
    }

    public void carregaVehicle(int codigo, vistaVehicle vista) {

        this.vista = vista;
        PreparedStatement ps;
        ResultSet rs;

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select * from vehicles where Id = ?");
            ps.setInt(1, ((codigo)));
            rs = ps.executeQuery();

            while (rs.next()) {
                vista.txtMatricula.setText(rs.getString("matricula"));
                vista.txtMarca.setText(rs.getString("marca"));
                vista.txtModel.setText(rs.getString("model"));
                vista.txtCombustible.setText(rs.getString("combustible"));
                vista.txtRenting.setText(rs.getString("renting"));
                vista.txtDataEntrada.setDate(rs.getDate("data_entrada"));
                vista.txtDataFinal.setDate(rs.getDate("data_final"));
                vista.txtPany.setText(rs.getString("pany_seguretat"));
                vista.txtCopiaClaus.setText(rs.getString("copiaclaus"));
                vista.txtPropRevisio.setDate(rs.getDate("propera_revisio"));

            }

            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error " + ex);
        }

    }

}