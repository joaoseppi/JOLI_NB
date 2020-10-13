/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.Apoio;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private long codigo;
    
    @Column(name = "cod_pessoa")
    private long cod_pessoa;
    
    @Column(name = "cod_fisica")
    private long cod_fisica;
    
    @Column(name = "cargo")
    private String cargo;
    
    @Column(name = "data_contrato")
    private String data_contrato;
    
    @Column(name = "senha")
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String cargo, Calendar data_contrato, String senha) {
        this.cargo = cargo;
        this.data_contrato = Apoio.getDate(data_contrato);
        this.senha = senha;
    }
    
    public Funcionario(String cargo, String data_contrato, String senha) {
        this.cargo = cargo;
        this.data_contrato = data_contrato;
        this.senha = senha;
    }

    public long getCodigo() {
        return codigo;
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

    public long getCod_fisica() {
        return cod_fisica;
    }

    public void setCod_fisica(long cod_fisica) {
        this.cod_fisica = cod_fisica;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData_contrato() {
        return data_contrato;
    }

    public void setData_contrato(String data_contrato) {
        this.data_contrato = data_contrato;
    }
    
    public void setData_contrato(Calendar data_contrato) {
        this.data_contrato = Apoio.getDate(data_contrato);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Funcionario)) return false;
        Funcionario func = (Funcionario) o;
        return  Objects.equals(this.codigo, func.codigo) &&
                Objects.equals(this.senha, func.senha) && 
                Objects.equals(this.cod_fisica, func.cod_fisica) &&
                Objects.equals(this.cod_pessoa, func.cod_pessoa) && 
                Objects.equals(this.data_contrato, func.data_contrato) &&
                Objects.equals(this.cargo, func.cargo) ;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.cargo, this.cod_fisica, this.cod_pessoa, 
                            this.codigo, this.data_contrato, this.senha);
    }
    
    @Override
    public String toString(){
        return "Funcionario{" + "id=" +this.codigo + ", senha'" + this.senha + 
               '\'' + ", data_contrato=" + this.data_contrato + ", cargo='" + 
               this.cargo + '\'' + '}';
    }
    
}
