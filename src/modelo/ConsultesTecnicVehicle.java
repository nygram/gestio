/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import vista.VistaTecnicVehicle;
import vista.vistaTecnic;

/**
 *
 * @author JavierFernándezDíaz
 */
public class ConsultesTecnicVehicle extends Conexion {
    
    PreparedStatement ps, ps2;
    ResultSet rs;
    private int codigo;
    private VistaTecnicVehicle entrad;
    Date fecha;
    


   public void carregaTaula(VistaTecnicVehicle entrad) {
         
         this.entrad = entrad;
         
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
        
        

        PreparedStatement ps;
        ResultSet rs;

        try {

            Conexion con = new Conexion();

            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("Select d.Id, t.nom, v.matricula, d.data_trans from detallsvehicle d "
                    + "INNER JOIN tecnics t ON  t.id = d.idtecnic "
                    + "INNER JOIN vehicles v ON v.id = d.idvehicle ");
            rs = ps.executeQuery();
            modeloTabla.addColumn("Id");
            modeloTabla.addColumn("nom");
            modeloTabla.addColumn("matricula");
            modeloTabla.addColumn("data");

            while (rs.next()) {
                Object fila[] = new Object[4];
                for (int i = 0; i < 4; i++) {
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
}