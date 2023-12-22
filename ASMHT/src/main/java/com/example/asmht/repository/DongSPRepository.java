package com.example.asmht.repository;

import com.example.asmht.entity.CuaHang;
import com.example.asmht.entity.DongSP;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class DongSPRepository {
    public ArrayList<DongSP> getList(){
        ArrayList<DongSP> lstDSP=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstDSP= (ArrayList<DongSP>) session.createQuery("from DongSP ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstDSP;
    }

    public static void main(String[] args) {
        DongSPRepository dongSPRepository=new DongSPRepository();
        for(DongSP dsp: dongSPRepository.getList()){
            System.out.println(dsp.toString());
        }
    }

    public void addNew(DongSP dsp){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(DongSP dsp){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DongSP getById(String id){
        DongSP dsp=new DongSP();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from DongSP where id=:id");
            query.setString("id",id);
            dsp= (DongSP) query.getSingleResult();
            return dsp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(DongSP dongSP){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
