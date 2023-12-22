package com.example.asmht.service;

import com.example.asmht.entity.ChiTietSanPham;
import com.example.asmht.repository.ChiTietSPRepositoRy;

import java.util.ArrayList;

public class ChiTietSPService {
    ChiTietSPRepositoRy chiTietSPRepositoRy=new ChiTietSPRepositoRy();

    public ArrayList<ChiTietSanPham> getList(){
        return chiTietSPRepositoRy.getList();
    }

    public void add(ChiTietSanPham ctsp){
        chiTietSPRepositoRy.add(ctsp);
    }

    public void update(ChiTietSanPham ctsp){
        chiTietSPRepositoRy.update(ctsp);
    }

    public ChiTietSanPham getById(String id){
        return chiTietSPRepositoRy.getById(id);
    }

    public void delete(ChiTietSanPham chiTietSanPham){
        chiTietSPRepositoRy.delete(chiTietSanPham);
    }
}
