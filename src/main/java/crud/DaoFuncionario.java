/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import javax.persistence.EntityManager;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import util.HibernateUtil;

/**
 *
 * @author JGSS
 */

@NamedStoredProcedureQuery(
        name = "create_funcionario",
        procedureName = "create_funcionario",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "nome"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "email"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "endereco"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "telefone"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "cidade_"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "cpf"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "rg"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "nascimento"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "cargo"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "senha")
        }
)
public class DaoFuncionario {
    EntityManager em;

    public DaoFuncionario() {
        em = HibernateUtil.getSessionFactory().createEntityManager();
    }
    
    public void insert(String nome, String email, String endereco, String telefone, 
            String cidade, String cpf, String rg, String nascimento, String cargo, String senha){
        StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("create_funcionario");
        query.setParameter("nome", nome);
        query.setParameter("email", email);
        query.setParameter("endereco", endereco);
        query.setParameter("telefone", telefone);
        query.setParameter("cidade_", cidade);
        query.setParameter("cpf", cpf);
        query.setParameter("rg", rg);
        query.setParameter("nascimento", nascimento);
        query.setParameter("cargo", cargo);
        query.setParameter("senha", senha);
        try{
            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
            String er = "crud.DaoFuncionario.insert";
            DaoLogs dl = new DaoLogs();
            dl.insert(er, e.toString());
        } finally {
            em.close();
        }
    }
    
}
