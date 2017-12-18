/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Gift;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author procc
 */
public class GiftDAO {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    public List<Gift> list(){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        return sf.getCurrentSession().createCriteria(Gift.class).list();
        }catch(Exception e){
            return null;
        }
    }
    public Gift search(Long code){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        return (Gift) sf.getCurrentSession().get(Gift.class, code);
        }catch(Exception e){
            return null;
        }
    }
    public boolean delete(Gift gf){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        sf.getCurrentSession().delete(gf);
        sf.getCurrentSession().getTransaction().commit();
        return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    public boolean edit(Gift gf){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().update(gf);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    } 
    public boolean save(Gift gf){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(gf);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    public boolean saveOrUpdate(Gift gf){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(gf);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        }catch(Exception e){
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    } 
}
