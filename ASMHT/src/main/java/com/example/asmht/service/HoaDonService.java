package com.example.asmht.service;

import com.example.asmht.entity.GioHang;
import com.example.asmht.entity.HoaDon;
import com.example.asmht.repository.HoaDonRepository;
import com.example.asmht.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class HoaDonService {
    HoaDonRepository hoaDonRepository=new HoaDonRepository();

    public ArrayList<HoaDon> getList(){
        return  hoaDonRepository.getList();
    }

    public ArrayList<HoaDon> getListHD(){
        return  hoaDonRepository.getListHD();
    }

    public HoaDon getById(String id){
        return hoaDonRepository.getById(id);
    }

    public void add(HoaDon hd){
        hoaDonRepository.add(hd);
    }

    public void update(HoaDon hd){
        hoaDonRepository.update(hd);
    }

    public void delete(HoaDon hd){
        hoaDonRepository.delete(hd);
    }

    public HoaDon getHoaDonByTrangThai(String idKH){
        return hoaDonRepository.getHoaDonByTrangThai(idKH);
    }

    public void updateTrangThai(String idHD){
        hoaDonRepository.updateTrangThai(idHD);
    }

    public ArrayList<HoaDon> loc(int tinhTrang){
        return hoaDonRepository.loc(tinhTrang);
    }


}
