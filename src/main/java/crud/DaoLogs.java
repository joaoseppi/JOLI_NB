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
	name = "error_log", 
	procedureName = "error_log", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "log_"), 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "error_")
	}
)
public class DaoLogs {
    EntityManager em;

    public DaoLogs() {
        em = HibernateUtil.getSessionFactory().createEntityManager();
    }
    
    public void insert(String log, String error){
        StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("auditoria");
        query.setParameter("log_", log);
        query.setParameter("error_", error);
        try{
            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
}
