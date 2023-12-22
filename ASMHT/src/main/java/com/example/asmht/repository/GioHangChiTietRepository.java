package com.example.asmht.repository;

import com.example.asmht.entity.ChiTietSanPham;
import com.example.asmht.entity.GioHang;
import com.example.asmht.entity.GioHangChiTiet;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GioHangChiTietRepository {
    public ArrayList<GioHangChiTiet> getList(){
        ArrayList<GioHangChiTiet> lstGHCT=new ArrayList<>();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            lstGHCT= (ArrayList<GioHangChiTiet>) session.createQuery("from GioHangChiTiet ").list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstGHCT;
    }

    public void add(GioHangChiTiet ghct){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(ghct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(GioHangChiTiet ghct){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(ghct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(GioHangChiTiet gioHangChiTiet){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(gioHangChiTiet);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public GioHangChiTiet getById(String idGioHang, String idChiTietSP){
        GioHangChiTiet ghct=new GioHangChiTiet();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from GioHangChiTiet where gioHang.id =:idGioHang and chiTietSanPham.id=:idChiTietSP");
            query.setString("idGioHang",idGioHang);
            query.setString("idChiTietSP",idChiTietSP);
            ghct= (GioHangChiTiet) query.getSingleResult();
            return ghct;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<GioHangChiTiet> getByGioHang(String idGioHang){
        ArrayList<GioHangChiTiet> lstGHCT=new ArrayList<>();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from GioHangChiTiet where gioHang.id =:idGioHang");
            query.setString("idGioHang",idGioHang);
            lstGHCT= (ArrayList<GioHangChiTiet>) query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstGHCT;
    }

    public ArrayList<GioHangChiTiet> getGioHangChiTiet(String idGH){
        ArrayList<GioHangChiTiet> lstGHCT=new ArrayList<>();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from GioHangChiTiet where gioHang.id=:idGH and gioHang.tinhTrang=0");
            query.setString("idGH",idGH);
            lstGHCT= (ArrayList<GioHangChiTiet>) query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lstGHCT;
    }


    public GioHangChiTiet checkTrung(String idGH,String idCTSP){
        GioHangChiTiet gioHangChiTiet=new GioHangChiTiet();
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("from GioHangChiTiet where GioHang.id=:idGH and ChiTietSanPham.id=:idCTSP ");
            query.setString("idGH",idGH);
            query.setString("idCTSP",idCTSP);
            return gioHangChiTiet= (GioHangChiTiet) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateSoLuong(int soLuong,String idGH,String idCTSP){
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("update GioHangChiTiet set soLuong=soLuong-:soLuong where gioHang.id=:idGH and chiTietSanPham.id=:idCTSP");
            query.setInteger("soLuong",soLuong);
            query.setString("idGH",idGH);
            query.setString("idCTSP",idCTSP);
            query.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        GioHangChiTietRepository gioHangChiTietRepository=new GioHangChiTietRepository();
//        GioHangChiTiet ghct=gioHangChiTietRepository.getById("09C97ECE-26C9-4E1A-BE59-6B10D7244BEF","6CCB4BD3-A8EE-4206-B113-67CEFC6EA156");
//        String idGH="C62DD1EA-A78F-46CD-B9E8-4435EE8CB1F8";
//        GioHang gh=new GioHang();
//        gh.setId(idGH);
//        String idCTSP="7EA7DD96-7DC4-43D7-8AA8-2138F6B2583F";
//        ChiTietSanPham chiTietSanPham=new ChiTietSanPham();
//        chiTietSanPham.setId(idCTSP);
//        int soLuong=2;
//        BigDecimal donGia=new BigDecimal(2000000);
//        BigDecimal donGiaKhiGiam=donGia;
//        GioHangChiTiet gioHangChiTiet=new GioHangChiTiet(gh,chiTietSanPham,soLuong,donGia,donGiaKhiGiam);
//        gioHangChiTietRepository.add(gioHangChiTiet);
        for(GioHangChiTiet gioHangChiTiet: gioHangChiTietRepository.getGioHangChiTiet("C62DD1EA-A78F-46CD-B9E8-4435EE8CB1F8")){
            System.out.println(gioHangChiTiet.toString());
        }

    }
}
