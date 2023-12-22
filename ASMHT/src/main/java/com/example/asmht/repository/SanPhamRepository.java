package com.example.asmht.repository;

import com.example.asmht.entity.SanPham;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class SanPhamRepository {
    public ArrayList<SanPham> getList(){
        ArrayList<SanPham> lstSP=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstSP= (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstSP;
    }

    public void add(SanPham sanPham){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(SanPham sanPham){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public SanPham getById(String id){
        SanPham sanPham=new SanPham();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from SanPham where id=:id");
            query.setString("id",id);
            sanPham= (SanPham) query.getSingleResult();
            return sanPham;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(SanPham sanPham){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
