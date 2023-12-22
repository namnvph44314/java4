package com.example.asmht.repository;

import com.example.asmht.entity.ChucVu;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ChucVuRepository {
    public ArrayList<ChucVu> getList(){
        ArrayList<ChucVu> lstCV=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstCV= (ArrayList<ChucVu>) session.createQuery("from ChucVu").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstCV;
    }

    public void addNew(ChucVu cv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(ChucVu cv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ChucVu getById(String id){
        ChucVu cv=new ChucVu();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query= session.createQuery("from ChucVu where id=:id");
            query.setString("id",id);
            cv= (ChucVu) query.getSingleResult();
            return cv;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(ChucVu chucVu){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
