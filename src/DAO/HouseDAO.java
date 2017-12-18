/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.House;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author procc
 */
public class HouseDAO {
        private final SessionFactory sf= HibernateUtil.getSessionFactory();
    public List<House> list(){
        try{    
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(House.class).list();
        }catch(Exception e ){
            return null;
        }
        
    }
    public House search(String code){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        return (House) sf.getCurrentSession().get(House.class, code);
        }catch(Exception e){
            return null;
        }
    }
    public boolean delete(House ps){
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
    public boolean edit(House ps){
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
    public boolean save(House ps){
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
