package com.example.asmht.service;

import com.example.asmht.entity.ChucVu;
import com.example.asmht.repository.ChucVuRepository;

import java.util.ArrayList;

public class ChucVuService {
    ChucVuRepository chucVuRepository=new ChucVuRepository();

    public ArrayList<ChucVu> getList(){
        return chucVuRepository.getList();
    }

    public void addNew(ChucVu cv){
        chucVuRepository.addNew(cv);
    }

    public void update(ChucVu cv){
        chucVuRepository.update(cv);
    }

    public ChucVu getById(String id){
        return chucVuRepository.getById(id);
    }

    public void delete(ChucVu chucVu){
        chucVuRepository.delete(chucVu);
    }

}
