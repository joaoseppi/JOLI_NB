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
        name = "auditoria",
        procedureName = "auditoria",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "ip_"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = int.class, name = "func_cod"),
            @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "feito")
        }
)
    
public class DaoAuditoria {
    EntityManager em;
    String ip = "000.000.000.000";
    long cod = 0;
    
    public DaoAuditoria(String ip, long cod) {
        em = HibernateUtil.getSessionFactory().createEntityManager();
        this.cod = cod;
        this.ip = ip;
    }
    
    public void insert(String ip, int cod, String feito){
        StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("auditoria");
        query.setParameter("ip_", ip);
        query.setParameter("func_cod", cod);
        query.setParameter("feito", feito);
        try{
            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
            String er = "crud.DaoAuditoria.insert";
            DaoLogs dl = new DaoLogs();
            dl.insert(er, e.toString());
        } finally {
            em.close();
        }
    }
}
