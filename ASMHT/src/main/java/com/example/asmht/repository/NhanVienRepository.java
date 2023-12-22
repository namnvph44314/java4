package com.example.asmht.repository;

import com.example.asmht.entity.NhanVien;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NhanVienRepository {
    public ArrayList<NhanVien> getList(){
        ArrayList<NhanVien> lstNV=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstNV= (ArrayList<NhanVien>) session.createQuery("from NhanVien ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstNV;
    }

    public void add(NhanVien nv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction =session.beginTransaction();
            session.save(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(NhanVien nv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction =session.beginTransaction();
            session.update(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public NhanVien getById(String id){
        NhanVien nv=new NhanVien();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from NhanVien where id=:id");
            query.setString("id",id);
            nv= (NhanVien) query.getSingleResult();
            return nv;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(NhanVien nhanVien){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction =session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
