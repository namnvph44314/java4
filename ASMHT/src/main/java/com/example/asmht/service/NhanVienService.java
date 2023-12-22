package com.example.asmht.service;

import com.example.asmht.entity.NhanVien;
import com.example.asmht.repository.NhanVienRepository;

import java.util.ArrayList;

public class NhanVienService {
    NhanVienRepository nhanVienRepository=new NhanVienRepository();

    public ArrayList<NhanVien> getList(){
        return nhanVienRepository.getList();
    }

    public void add(NhanVien nv){
        nhanVienRepository.add(nv);
    }

    public void update(NhanVien nv){
        nhanVienRepository.update(nv);
    }

    public NhanVien getById(String id){
        return nhanVienRepository.getById(id);
    }

    public void delete(NhanVien nhanVien){
        if(nhanVien!=null){
            nhanVienRepository.delete(nhanVien);
        }else{
            return;
        }

    }

}
