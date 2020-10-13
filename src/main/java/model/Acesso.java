/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.Apoio;

@Entity
@Table(name = "acesso")
public class Acesso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private long codigo;
    
    @Column(name = "time")
    private String time;
    
    @Column(name = "ip")
    private String ip;
    
    @Column(name = "feito")
    private String feito;
    
    @Column(name = "cod_funcionario")
    private long cod_func;

    public Acesso(long cod, String ip) {
        cod_func = cod;
        this.ip = ip;
        time = Apoio.getCurrentTimestamp();
    }
    
    public Acesso() {
    }
    
    public long getCodigo() {
        return codigo;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFeito() {
        return feito;
    }

    public void setFeito(String feito) {
        this.feito = feito;
    }

    public long getCod_func() {
        return cod_func;
    }

    public void setCod_func(int cod_func) {
        this.cod_func = cod_func;
    }

}
