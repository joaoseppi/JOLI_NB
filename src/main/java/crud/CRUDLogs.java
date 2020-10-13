/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import model.Error_logs;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JGSS
 */
public class CRUDLogs {
    
    public static void logsSave(Error_logs log){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            sessao.save(log);
            transacao.commit();
            System.out.println("SUCCESS - CRUD.save.logs");
        } catch(HibernateException hEx) {
            hEx.printStackTrace();
            System.out.println("ERROR - CRUD.save.logs");
        } finally {
            sessao.close();
        }
    }
    
    public static List<Error_logs> logsDateSearch(String date){
        List<Error_logs> resultado = new ArrayList();
        String sql = "FROM Error_logs "
        + "WHERE time = " + date + " "
        + "ORDER BY time";
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            System.out.println("SUCCESS - CRUD.search.dateLog");
        } catch (HibernateException hibEx) {
            System.out.println("ERROR - CRUD.search.dateLog");
            hibEx.printStackTrace();
        }
        return resultado;
    }
    
    public static List<Error_logs> logsErrorSearch(String error){
        List<Error_logs> resultado = new ArrayList();
        String sql = "FROM Error_logs "
        + "WHERE error = " + error + " "
        + "ORDER BY time";
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            System.out.println("SUCCESS - CRUD.search.errorLog");
        } catch (HibernateException hibEx) {
            System.out.println("ERROR - CRUD.search.errorLog");
            hibEx.printStackTrace();
        }
        return resultado;
    }
    
}
