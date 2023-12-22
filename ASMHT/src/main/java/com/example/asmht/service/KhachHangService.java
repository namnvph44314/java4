package com.example.asmht.service;

import com.example.asmht.entity.KhachHang;
import com.example.asmht.repository.KhachHangRepository;

import java.util.ArrayList;

public class KhachHangService {
    KhachHangRepository khachHangRepository=new KhachHangRepository();

    public ArrayList<KhachHang> getList(){
        return khachHangRepository.getList();
    }

    public KhachHang getById(String id){
        return khachHangRepository.getById(id);
    }

    public void add(KhachHang kh){
        khachHangRepository.add(kh);
    }

    public void update(KhachHang kh){
        khachHangRepository.update(kh);
    }

    public void delete(KhachHang kh){
        if(kh!=null){
            khachHangRepository.delete(kh);
        }else{
            return;
        }
    }

    public KhachHang dangNhap(String sdt, String matKhau){
        return khachHangRepository.dangNhap(sdt,matKhau);
    }

    public KhachHang getKH(String sdt,String password){
        return khachHangRepository.getKH(sdt,password);
    }

}
