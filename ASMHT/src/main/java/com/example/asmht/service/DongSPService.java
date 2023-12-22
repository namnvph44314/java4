package com.example.asmht.service;

import com.example.asmht.entity.DongSP;
import com.example.asmht.repository.DongSPRepository;

import java.util.ArrayList;

public class DongSPService {
    DongSPRepository dongSPRepository=new DongSPRepository();

    public ArrayList<DongSP> getList(){
        return dongSPRepository.getList();
    }

    public void addNew(DongSP dsp){
        dongSPRepository.addNew(dsp);
    }

    public void update(DongSP dsp){
        dongSPRepository.update(dsp);
    }
    public DongSP getById(String id){
        return dongSPRepository.getById(id);
    }

    public void delete(DongSP dongSP){
        dongSPRepository.delete(dongSP);
    }

}
