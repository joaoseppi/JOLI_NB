/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Error_logs;
import model.Pessoa;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author JGSS
 */
public class Apoio {
    private int codigo;

    public int getCodigo() {
        return codigo;
    }
    
    public static String getCurrentTimestamp(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return sdf.format(c.getTime());
    }
    
    public static String getTimestamp(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return sdf.format(c.getTime());
    }
    
    public static String getLogsTimestamp(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        return sdf.format(c.getTime());
    }
    
    public static String getDate(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(c.getTime());
    }
    
    public static String getDate(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(c.getTime());
    }
    
    public static String getTime(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(c.getTime());
    }
    
    public static String getWeekBefore(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        c.add(Calendar.DAY_OF_MONTH, -7);
        return sdf.format(c.getTime());
    }

    public static String getLastWeek(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        c.add(Calendar.DAY_OF_MONTH, -7);
        return sdf.format(c.getTime());
    }
    
    public static String getMonthBefore(Calendar c){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        c.add(Calendar.MONTH, -1);
        return sdf.format(c.getTime());
    }

    public static String getLastMonth(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        c.add(Calendar.MONTH, -7);
        return sdf.format(c.getTime());
    }
    
}
