/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Phi;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author procc
 */
public class PhiDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    public List<Phi> list(){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        return sf.getCurrentSession().createCriteria(Phi.class).list();
        }catch(Exception e){
            return null;
        }   
    }
    public Phi search(String code){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        return (Phi) sf.getCurrentSession().get(Phi.class, code);
        }catch(Exception e){
            return null;
        }
    }
    public boolean delete(Phi ps){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        sf.getCurrentSession().delete(ps);
        sf.getCurrentSession().getTransaction().commit();
        return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    public boolean edit(Phi ps){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().update(ps);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    } 
    public boolean save(Phi ps){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(ps);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    } 
}
