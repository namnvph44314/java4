package com.example.asmht.repository;

import com.example.asmht.entity.ChiTietSanPham;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ChiTietSPRepositoRy {
    public ArrayList<ChiTietSanPham> getList(){
        ArrayList<ChiTietSanPham> lstCTSP=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstCTSP= (ArrayList<ChiTietSanPham>) session.createQuery("from ChiTietSanPham ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstCTSP;
    }

    public void add(ChiTietSanPham ctsp){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(ChiTietSanPham ctsp){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ChiTietSanPham getById(String id){
        ChiTietSanPham ctsp=new ChiTietSanPham();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query= session.createQuery("from ChiTietSanPham where id=:id");
            query.setString("id",id);
            ctsp= (ChiTietSanPham) query.getSingleResult();
            return ctsp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(ChiTietSanPham chiTietSanPham){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(chiTietSanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
