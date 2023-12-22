package com.example.asmht.service;

import com.example.asmht.entity.GioHang;
import com.example.asmht.repository.GioHangRepository;

import java.util.ArrayList;

public class GioHangService {
    GioHangRepository gioHangRepository=new GioHangRepository();

    public ArrayList<GioHang> getList(){
        return gioHangRepository.getList();
    }

    public void addnew(GioHang gh){
        gioHangRepository.addNew(gh);
    }

    public void update(GioHang gioHang){
        gioHangRepository.update(gioHang);
    }

    public GioHang getById(String id){
        return gioHangRepository.getById(id);
    }

    public GioHang getGioHangByTrangThai(String idKH){
        return gioHangRepository.getGioHangByTrangThai(idKH);
    }

    public void updateTrangThai(String idGH){
        gioHangRepository.updateTrangThai(idGH);
    }
}
