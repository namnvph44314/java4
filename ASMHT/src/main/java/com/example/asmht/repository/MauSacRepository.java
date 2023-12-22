package com.example.asmht.repository;

import com.example.asmht.entity.MauSac;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class MauSacRepository {
    public ArrayList<MauSac> getList(){
        ArrayList<MauSac> lstMS=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstMS= (ArrayList<MauSac>) session.createQuery("from MauSac ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstMS;
    }

    public void add(MauSac ms){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(MauSac ms){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MauSac getById(String id){
        MauSac ms=new MauSac();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from MauSac where id=:id");
            query.setString("id",id);
            ms= (MauSac) query.getSingleResult();
            return ms;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(MauSac mauSac){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
