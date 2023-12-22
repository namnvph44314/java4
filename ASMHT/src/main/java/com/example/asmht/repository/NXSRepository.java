package com.example.asmht.repository;

import com.example.asmht.entity.NXS;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NXSRepository {
    public ArrayList<NXS> getList(){
        ArrayList<NXS> lstNXS=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstNXS= (ArrayList<NXS>) session.createQuery("from NXS ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstNXS;
    }

    public void add(NXS nxs){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(nxs);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(NXS nxs){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(nxs);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public NXS getById(String id) {
        NXS nxs = new NXS();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NXS where id=:id");
            query.setString("id", id);
            nxs = (NXS) query.getSingleResult();
            return nxs;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(NXS nxs){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(nxs);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
