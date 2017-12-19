/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Gift;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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
    public List<Gift> findJiDouDayGift(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Gift.class).add(Restrictions.like("event","%1/6%")).list();
        }catch(Exception e){
            return null;
        }
    }
    public List<Gift> findMidAutumnGift(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Gift.class).add(Restrictions.like("event","%Trung%")).list();
        }catch(Exception e){
            return null;
        }
    }
    public List<Gift> findHsgGift(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Gift.class).add(Restrictions.like("event","%Hoc sinh%")).list();
        }catch(Exception e){
            return null;
        }
    }
    public List<Gift> findDien1Gift(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Gift.class).add(Restrictions.eq("dien",1)).list();
        }catch(Exception e){
            return null;
        }
    }
    public List<Gift> findDien2Gift(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Gift.class).add(Restrictions.eq("dien",2)).list();
        }catch(Exception e){
            return null;
        }
    }
}
