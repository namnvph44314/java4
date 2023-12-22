package com.example.asmht.service;

import com.example.asmht.entity.GioHangChiTiet;
import com.example.asmht.repository.GioHangChiTietRepository;

import java.util.ArrayList;

public class GioHangChiTietService {
    GioHangChiTietRepository gioHangChiTietRepository=new GioHangChiTietRepository();

    public ArrayList<GioHangChiTiet> getList(){
        return gioHangChiTietRepository.getList();
    }

    public void add(GioHangChiTiet gioHangChiTiet){
        gioHangChiTietRepository.add(gioHangChiTiet);
    }

    public void update(GioHangChiTiet gioHangChiTiet){

        gioHangChiTietRepository.update(gioHangChiTiet);
    }

    public GioHangChiTiet getById(String idGioHang,String idChiTietSP){
        return gioHangChiTietRepository.getById(idGioHang,idChiTietSP);
    }

    public ArrayList<GioHangChiTiet> getGioHangChiTiet(String idGH){
        return gioHangChiTietRepository.getGioHangChiTiet(idGH);
    }

    public void delete(GioHangChiTiet gioHangChiTiet){
        gioHangChiTietRepository.delete(gioHangChiTiet);
    }

    public GioHangChiTiet checkTrung(String idGH,String idCTSP){
        return gioHangChiTietRepository.checkTrung(idGH,idCTSP);
    }

    public void updateSoLuong(int soLuong,String idGH,String idCTSP){
        gioHangChiTietRepository.updateSoLuong(soLuong,idGH,idCTSP);
    }

    public ArrayList<GioHangChiTiet> getByGioHang(String idGH){
        return gioHangChiTietRepository.getByGioHang(idGH);
    }

    public static void main(String[] args) {
        GioHangChiTietService gioHangChiTietServicene=new GioHangChiTietService();
        for(GioHangChiTiet ghct: gioHangChiTietServicene.getList()){
            System.out.println(ghct.toString());
        }
    }


}
