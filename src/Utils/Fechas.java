package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import vista.vistaVehicle;

public class Fechas {

    public static Date dameFecha(com.toedter.calendar.JDateChooser entrada) {

        Date date = entrada.getDate();
        long data = date.getTime(); //guardamos en un long
        java.sql.Date fecha = new java.sql.Date(data);// pasamos al formato del sql  
        return fecha;

    }

    public static Date dameFecha(Date data) {

        //Date date = data.getDate();
        long date = data.getTime(); //guardamos en un long
        java.sql.Date fecha = new java.sql.Date(date);// pasamos al formato del sql 
        System.out.println("fecha es " + fecha);
        return fecha;

    }

    public static Date getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return ahora;
    }
}
