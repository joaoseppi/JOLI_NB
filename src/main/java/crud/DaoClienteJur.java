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
        name = "create_cliente_jur",
        procedureName = "create_cliente_jur",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "nome"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "email"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "endereco"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "telefone"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "cidade_"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "cnpj"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "cnae"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "abertura"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "natureza_jur")
        }
)
public class DaoClienteJur {
    EntityManager em = null;

    public DaoClienteJur() {
        em = HibernateUtil.getSessionFactory().createEntityManager();
    }
    
    public void insert(String nome, String email, String endereco, String telefone, 
        String cidade, String cnpj, String cnae, String abertura, String natureza_jur){
        if(em == null) em = HibernateUtil.getSessionFactory().createEntityManager();
        StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("create_cliente_jur");
        query.setParameter("nome", nome);
        query.setParameter("email", email);
        query.setParameter("endereco", endereco);
        query.setParameter("telefone", telefone);
        query.setParameter("cidade_", cidade);
        query.setParameter("cnpj", cnpj);
        query.setParameter("cnae", cnae);
        query.setParameter("abertura", abertura);
        query.setParameter("natureza_jur", natureza_jur);
        try{
            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
            String er = "crud.DaoClienteJur.insert";
            DaoLogs dl = new DaoLogs();
            dl.insert(er, e.toString());
        } finally {
            em.close();
        }
    }
}
