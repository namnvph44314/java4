package com.example.asmht.repository;

import com.example.asmht.entity.KhachHang;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class KhachHangRepository {
    public ArrayList<KhachHang> getList(){
        ArrayList<KhachHang> lstKH=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstKH= (ArrayList<KhachHang>) session.createQuery("from KhachHang ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstKH;
    }

    public KhachHang getById(String id){
        KhachHang kh=new KhachHang();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from KhachHang where id=:id");
            query.setString("id",id);
            kh= (KhachHang) query.getSingleResult();
            return kh;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void add(KhachHang kh){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(KhachHang kh){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(KhachHang kh){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public KhachHang dangNhap(String sdt, String matKhau){
        KhachHang khachHang=new KhachHang();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query= session.createQuery("from KhachHang where sDT like :sdt and matKhau like :matKhau");
            query.setString("sdt",sdt);
            query.setString("matKhau",matKhau);
            khachHang= (KhachHang) query.getSingleResult();
            return khachHang;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKH(String sdt,String password){
        KhachHang khachHang=new KhachHang();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from KhachHang where sDT like :sdt and matKhau like :matKhau");
            query.setString("sdt",sdt);
            query.setString("matKhau",password);
            return  khachHang= (KhachHang) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
