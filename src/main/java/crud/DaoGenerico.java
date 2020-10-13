/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.ArrayList;
import java.util.List;
import model.Acesso;
import model.Error_logs;
import model.Pessoa;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author JGSS
 */
public class DaoGenerico {
    public static DaoGenerico daoGenerico = null;
    
    private SessionFactory factory;
    private Transaction transaction;
    private Acesso acc;
    
    public DaoGenerico(int cod, String ip){
        factory = HibernateUtil.getSessionFactory();
        acc.setCod_func(cod);
        acc.setIp(ip);
    }
    
    public DaoGenerico(){
        factory = HibernateUtil.getSessionFactory();
    }
    
    public static DaoGenerico getInstance(){
        if(daoGenerico == null){
            daoGenerico = new DaoGenerico();
        }
        return daoGenerico;
    }
    
    public boolean insert(Object obj){
        boolean retorno = false;
        Session sessao = factory.openSession();
        try{
            transaction = sessao.beginTransaction();
            sessao.save(obj);
            transaction.commit();
            retorno = true;
            String er = "Inserted: " + obj.toString();
            acc.setFeito(er);
            new DaoGenerico().insert(acc);
        } catch (HibernateException e){
            transaction.rollback();
            retorno = false;
            e.printStackTrace();
            String er = "crud.DaoGenerico.insert";
            new DaoGenerico().insert(new Error_logs(er, e.toString()));
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public boolean update(Object obj){
        boolean retorno = false;
        Session sessao = factory.openSession();
        try{
            transaction = sessao.beginTransaction();
            sessao.update(obj);
            transaction.commit();
            retorno = true;
            String er = "Updated: " + obj.toString();
            acc.setFeito(er);
            new DaoGenerico().insert(acc);
        } catch (HibernateException e){
            transaction.rollback();
            retorno = false;
            e.printStackTrace();
            String er = "crud.DaoGenerico.update";
            new DaoGenerico().insert(new Error_logs(er, e.toString()));
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public boolean delete(Object obj){
        boolean retorno = false;
        Session sessao = factory.openSession();
        try{
            transaction = sessao.beginTransaction();
            sessao.delete(obj);
            transaction.commit();
            retorno = true;
            String er = "Deleted: " + obj.toString();
            acc.setFeito(er);
            new DaoGenerico().insert(acc);
        } catch (HibernateException e){
            transaction.rollback();
            retorno = false;
            e.printStackTrace();
            String er = "crud.DaoGenerico.delete";
            new DaoGenerico().insert(new Error_logs(er, e.toString()));
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public List<Pessoa> selectAllPessoa(){
        List<Pessoa> resultado = new ArrayList();
        String sql = "FROM pessoa ORDER BY nome";
        try{
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            String er = "crud.DaoGenerico.selectAllPessoa";
            new DaoGenerico().insert(new Error_logs(er, hibEx.toString()));
        }
        return resultado;
    }
    
    public List<Pessoa> selectPessoa(String nome){
        List<Pessoa> resultado = new ArrayList();
        String sql = "FROM pessoa WHERE name = '" + nome + "' "
                   + "ORDER BY nome";
        try{
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            String er = "crud.DaoGenerico.selectPessoa{nome}";
            new DaoGenerico().insert(new Error_logs(er, hibEx.toString()));
        }
        return resultado;
    }
    
    public Pessoa selectPessoa(Long codigo){
        List<Pessoa> resultado = new ArrayList();
        String sql = "FROM pessoa WHERE codigo = " + codigo;
        try{
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            String er = "crud.DaoGenerico.selectPessoa{codigo}";
            new DaoGenerico().insert(new Error_logs(er, hibEx.toString()));
        }
        return resultado.get(0);
    }
    
    public Query selectPessoa(char tipo, String nome){
        Query query = null;
        String pes = "";
        String c = "c.cod_fisica";
        if(tipo == 'f') pes = "fisica f, cliente c ";
        else if(tipo == 'j'){
            pes = "juridica f, cliente c ";
            c = "c.cod_juridica ";
        }
        else if(tipo == 'u') pes = "fisica f, funcionario c ";
        
        String sql = "FROM pessoa p " + pes
                + "WHERE p.nome LIKE '%" + nome + "%' "
                + "AND p.codigo = f.cod_pessoa "
                + "AND f.cod_pessoa = " + c + " "
                + "ORDER BY p.nome ";
        sql = "SELECT p.codigo, p.nome, p.email " + sql;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            query = session.createSQLQuery(sql);
            String er = "Selected all pessoa with name '" + nome + "'";
            acc.setFeito(er);
            new DaoGenerico().insert(acc);
        } catch (HibernateException hibEx){
            hibEx.printStackTrace();
            String er = "crud.DaoGenerico.selectPessoa";
            new DaoGenerico().insert(new Error_logs(er, hibEx.toString()));
        }
        return query;
    }
}
