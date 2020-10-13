/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import util.Apoio;

@Entity
@Table(name = "error_logs")
public class Error_logs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private long codigo;
    
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar time;
    
    @Column(name = "log")
    private String local;
    
    @Column(name = "error")
    private String error;
    
    private File log;
    
    public Error_logs() {
        this.time = Calendar.getInstance();
        this.local = "C:\\error_logs\\" + Apoio.getTimestamp(time) +".txt";
    }
    
    public Error_logs(String log, String erro) {
        this.time = Calendar.getInstance();
        this.local = "C:\\error_logs\\" + Apoio.getTimestamp(time) +".txt";
        local = log;
        error = erro;
    }
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public File getLog() {
        return log;
    }
    
    

    public void setLog(String log) {
        try {
            File myObj = new File(local);
            if (myObj.createNewFile()) {
                System.out.println("SUCESS: create.error_log");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("ERROR: create.error_log");
            e.printStackTrace();
        }
        
        try {
            FileWriter myWriter = new FileWriter(local);
            myWriter.write("At " + Apoio.getTimestamp(time) + " ocurred error: " + log);
            myWriter.close();
            System.out.println("SUCESS: write.error_log");
        } catch (IOException e) {
            System.out.println("ERROR: write.error_log");
            e.printStackTrace();
        }
    }
    
    /*
    public void setLog(String log){
        this.local = log;
    }
    */

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
