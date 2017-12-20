/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.House;
import Model.Personal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import static java.lang.Math.toIntExact;
import org.hibernate.SQLQuery;

/**
 *
 * @author procc
 */
public class PersonalDAO {
    private final SessionFactory sf =  HibernateUtil.getSessionFactory();
    public List<Personal> list(){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        return sf.getCurrentSession().createCriteria(Personal.class).list();
        }catch(Exception e){
            return null;
        }
    }
    public Personal search(Long code){
        try{
        if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
        return (Personal) sf.getCurrentSession().get(Personal.class, code);
        }catch(Exception e){
            return null;
        }
    }
    public boolean delete(Personal ps){
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
    public boolean edit(Personal ps){
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
    public boolean save(Personal ps){
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
    public int countPerson(String houseId){
        try {
            
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            String hql = "Select count( houseId) from Personal log where houseId='"+houseId+"'";      
            Query query = sf.getCurrentSession().createQuery(hql);
            Long gt = (Long) query.uniqueResult();
            return toIntExact(gt);
            
        } catch (Exception e) {
            return 0;
        }
    }
    public List<Personal> findSeiJinPeoPle(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Personal.class).add(Restrictions.between("age", 18, 25)).add(Restrictions.eq("career","")).list();
        }catch(Exception e){
            return null;
        }
    }
    public List<Personal> findJiDouPeoPle(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Personal.class).add(Restrictions.between("age", 1, 17)).list();
        }catch(Exception e){
            return null;
        }
    }
    public List<Personal> findDanQuanPeoPle(){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            return sf.getCurrentSession().createCriteria(Personal.class).add(Restrictions.like("career","%Dân quân%")).list();
        }catch(Exception e){
            return null;
        }
    }
    public List<Personal> searchByProperty(String name,String career,Integer birthYear,String houseId,Integer dien){
        try{
            if(sf.getCurrentSession().getTransaction().isActive()==false) sf.getCurrentSession().beginTransaction();
            String hql = "Select * from Personal  where 1=1";
            if(name != null && name.length()>0) hql+=" and name like '%"+name+"%'";
            if(career != null && career.length()>0 ) hql+=" and career like '%"+career+"%'";
            if(birthYear != null ) hql+=" and birthYear="+birthYear+"";
            if(houseId != null && houseId.length()>0) hql+=" and houseId='"+houseId+"'";
            if(dien != null ) hql+=" and diendacbiet = "+dien+"";
            SQLQuery query = sf.getCurrentSession().createSQLQuery(hql);
            query.addEntity(Personal.class);
            List list = query.list();
            return list;
        }catch(Exception e){
            return null;
        }
    }
   
}
