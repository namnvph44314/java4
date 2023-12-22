package com.example.asmht.repository;

import com.example.asmht.entity.GioHangChiTiet;
import com.example.asmht.entity.HoaDonChiTiet;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class HoaDonChiTietRepository {
    public ArrayList<HoaDonChiTiet> getList(){
        ArrayList<HoaDonChiTiet> lstHDCT=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstHDCT= (ArrayList<HoaDonChiTiet>) session.createQuery("from HoaDonChiTiet ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstHDCT;
    }

    public void add(HoaDonChiTiet hdct){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(HoaDonChiTiet hdct){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HoaDonChiTiet getById(String idHD, String idCTSP){
        HoaDonChiTiet hoaDonChiTiet=new HoaDonChiTiet();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from HoaDonChiTiet where hoaDon.id=:idHD and chiTietSanPham.id=:idCTSP");
            query.setString("idHD",idHD);
            query.setString("idCTSP",idCTSP);
            return hoaDonChiTiet= (HoaDonChiTiet) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(HoaDonChiTiet hdct){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
