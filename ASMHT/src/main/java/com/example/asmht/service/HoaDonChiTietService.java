package com.example.asmht.service;

import com.example.asmht.entity.HoaDon;
import com.example.asmht.entity.HoaDonChiTiet;
import com.example.asmht.repository.HoaDonChiTietRepository;

import java.util.ArrayList;

public class HoaDonChiTietService {
    HoaDonChiTietRepository hoaDonChiTietRepository=new HoaDonChiTietRepository();

    public ArrayList<HoaDonChiTiet> getList(){
        return hoaDonChiTietRepository.getList();
    }

    public void add(HoaDonChiTiet hoaDonChiTiet){
        hoaDonChiTietRepository.add(hoaDonChiTiet);
    }
    public void update(HoaDonChiTiet hoaDonChiTiet){
        hoaDonChiTietRepository.update(hoaDonChiTiet);
    }
    public void delete(HoaDonChiTiet hoaDonChiTiet){
        hoaDonChiTietRepository.delete(hoaDonChiTiet);
    }
    public HoaDonChiTiet getById(String idHD,String idCTSP){
        return hoaDonChiTietRepository.getById(idHD,idCTSP);
    }
}
