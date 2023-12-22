package com.example.asmht.repository;

import com.example.asmht.entity.GioHang;
import com.example.asmht.entity.HoaDon;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class HoaDonRepository {
    public ArrayList<HoaDon> getList(){
        ArrayList<HoaDon> lstHD=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstHD= (ArrayList<HoaDon>) session.createQuery("from HoaDon ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstHD;
    }

    public ArrayList<HoaDon> getListHD(){
        ArrayList<HoaDon> lstHD=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstHD= (ArrayList<HoaDon>) session.createQuery("from HoaDon where tinhTrang=1 or tinhTrang=2 or tinhTrang=3 ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstHD;
    }

    public HoaDon getById(String id){
        HoaDon hd=new HoaDon();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from HoaDon where id=:id");
            query.setString("id",id);
            hd= (HoaDon) query.getSingleResult();
            return hd;
        }catch (Exception e){
            e.printStackTrace();
        }
        return hd;
    }

    public void add(HoaDon hd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(HoaDon hd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(HoaDon hd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HoaDon getHoaDonByTrangThai(String idKH){
        HoaDon hoaDon=new HoaDon();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from HoaDon where khachHang.id=:idKH and tinhTrang=0");
            query.setString("idKH",idKH);
            hoaDon= (HoaDon) query.getSingleResult();
            return hoaDon;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateTrangThai(String idGH){
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("update HoaDon set tinhTrang=1 where tinhTrang=0");
            query.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<HoaDon> loc(int tingTrang){
        ArrayList<HoaDon> lstHD=new ArrayList<>();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from HoaDon where tinhTrang=:tinhTrang");
            query.setInteger("tinhTrang",tingTrang);
            lstHD= (ArrayList<HoaDon>) query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstHD;
    }


}
