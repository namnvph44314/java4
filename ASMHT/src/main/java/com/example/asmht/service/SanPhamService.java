package com.example.asmht.service;

import com.example.asmht.entity.SanPham;
import com.example.asmht.repository.SanPhamRepository;

import java.util.ArrayList;

public class SanPhamService {
    SanPhamRepository sanPhamRepository=new SanPhamRepository();

    public ArrayList<SanPham> getList(){
        return sanPhamRepository.getList();
    }

    public void add(SanPham sanPham){
        sanPhamRepository.add(sanPham);
    }

    public void update(SanPham sanPham){
        sanPhamRepository.update(sanPham);
    }

    public SanPham getById(String id){
        return sanPhamRepository.getById(id);
    }

    public void delete(SanPham sanPham){
        sanPhamRepository.delete(sanPham);
    }
}
