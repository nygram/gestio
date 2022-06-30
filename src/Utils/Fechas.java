package Utils;

import java.text.SimpleDateFormat;
import java.sql.Date;
import vista.VistaVehicle;

public class Fechas {

    public static java.sql.Date dameFecha(com.toedter.calendar.JDateChooser entrada) {

        
         //date = entrada.getDate();
        
        java.util.Date date = entrada.getDate();
        long data = date.getTime(); //guardamos en un long
        java.sql.Date fecha = new java.sql.Date(data);// pasamos al formato del sql  
        return fecha;

    }

    public static Date dameFecha(Date data) {

        long date = data.getTime(); //guardamos en un long
        java.sql.Date fecha = new java.sql.Date(date);// pasamos al formato del sql 
        System.out.println("fecha es " + fecha);
        return fecha;

    }

    public static Date getFechaActual() {
        
        long millis = System.currentTimeMillis();
        java.sql.Date ahora = new java.sql.Date(millis);
        return ahora;
    }

    
}
