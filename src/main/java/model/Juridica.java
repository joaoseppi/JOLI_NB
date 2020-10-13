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
@Table(name = "juridica")

public class Juridica implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;
    
    @Column(name = "cnpj")
    private String cnpj;
    
    @Column(name = "natureza_jur")
    private String natureza_jur;
    
    @Column(name = "abertura")
    private Calendar abertura; 
    
    @Column(name = "cnae")
    private String cnae;

    public Juridica() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNatureza_jur() {
        return natureza_jur;
    }

    public void setNatureza_jur(String natureza_jur) {
        this.natureza_jur = natureza_jur;
    }

    public Calendar getAbertura() {
        return abertura;
    }

    public void setAbertura(Calendar abertura) {
        this.abertura = abertura;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }
    
}
