package com.example.asmht.service;

import com.example.asmht.entity.CuaHang;
import com.example.asmht.repository.CuaHangRepository;

import java.util.ArrayList;

public class CuaHangService {
    CuaHangRepository cuaHangRepository=new CuaHangRepository();
    public ArrayList<CuaHang> getList(){
        return cuaHangRepository.getList();
    }

    public void addNew(CuaHang ch){
        cuaHangRepository.addNew(ch);
    }

    public void update(CuaHang ch){
        cuaHangRepository.update(ch);
    }

    public CuaHang getById(String id){
        return cuaHangRepository.getById(id);
    }

    public void delete(CuaHang cuaHang){
        cuaHangRepository.delete(cuaHang);
    }

}
