package com.example.asmht.repository;

import com.example.asmht.entity.GioHang;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class GioHangRepository {
    public ArrayList<GioHang> getList(){
        ArrayList<GioHang> lstGH=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstGH= (ArrayList<GioHang>) session.createQuery("from GioHang ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstGH;
    }


    public void addNew(GioHang gh){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(gh);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(GioHang gioHang){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.update(gioHang);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public GioHang getById(String id){
        GioHang gh=new GioHang();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from GioHang where id=:id");
            query.setString("id",id);
            gh= (GioHang) query.getSingleResult();
            return gh;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GioHang getGioHangByTrangThai(String idKH){
        GioHang gh=new GioHang();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from GioHang where khachHang.id=:idKH and tinhTrang=0");
            query.setString("idKH",idKH);
            gh= (GioHang) query.getSingleResult();
            return gh;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateTrangThai(String idGH){
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("update GioHang  set tinhTrang=1 where tinhTrang=0");
            query.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GioHangRepository gioHangRepository=new GioHangRepository();
//        System.out.println(gioHangRepository.getById("79A719F5-E050-4C2A-8AE0-CF315F0880CC"));
        System.out.println(gioHangRepository.getGioHangByTrangThai("94CD3AD3-61A6-4F28-A9F3-607C17DB4CEB"));
    }
}
