/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processo")
public class Processo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private long codigo;
    
    @Column(name = "cod_cliente")
    private long cod_cliente;
    
    @Column(name = "cod_funcionario")
    private long cod_funcionario;
    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "processo_tipo")
    private String processo_tipo;
    
    @Column(name = "abertura")
    private Calendar abertura;

    public Processo() {
    }
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(long cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public long getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(long cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProcesso_tipo() {
        return processo_tipo;
    }

    public void setProcesso_tipo(String processo_tipo) {
        this.processo_tipo = processo_tipo;
    }

    public Calendar getAbertura() {
        return abertura;
    }

    public void setAbertura(Calendar abertura) {
        this.abertura = abertura;
    }

    
}
