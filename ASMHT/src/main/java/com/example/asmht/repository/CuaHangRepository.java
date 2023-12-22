package com.example.asmht.repository;

import com.example.asmht.entity.CuaHang;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class CuaHangRepository {
    public ArrayList<CuaHang> getList(){
        ArrayList<CuaHang> lstCH=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstCH= (ArrayList<CuaHang>) session.createQuery("from CuaHang ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstCH;
    }

    public void addNew(CuaHang ch){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(CuaHang ch){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public CuaHang getById(String id){
        CuaHang ch=new CuaHang();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from CuaHang where id=:id");
            query.setString("id",id);
            ch= (CuaHang) query.getSingleResult();
            return ch;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(CuaHang cuaHang){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
