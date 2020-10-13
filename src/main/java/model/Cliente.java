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

@Entity
@Table(name = "pessoa")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private long codigo;
    
    @Column(name = "cod_pessoa")
    private long cod_pessoa;
    
    @Column(name = "cod_juridica")
    private long cod_juridica;
    
    @Column(name = "cod_fisica")
    private long cod_fisica;

    public long getCodigo() {
        return codigo;
    }

    public Cliente() {
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(long cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public long getCod_juridica() {
        return cod_juridica;
    }

    public void setCod_juridica(long cod_juridica) {
        this.cod_juridica = cod_juridica;
    }

    public long getCod_fisica() {
        return cod_fisica;
    }

    public void setCod_fisica(long cod_fisica) {
        this.cod_fisica = cod_fisica;
    }
    
}
