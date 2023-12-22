package com.example.asmht.service;

import com.example.asmht.entity.NXS;
import com.example.asmht.repository.NXSRepository;

import java.util.ArrayList;

public class NXSService {
    NXSRepository nxsRepository=new NXSRepository();
    public ArrayList<NXS> getList(){
        return nxsRepository.getList();
    }
    public void add(NXS nxs){
        nxsRepository.add(nxs);
    }
    public void update(NXS nxs){
        nxsRepository.update(nxs);
    }

    public NXS getById(String id){
        return nxsRepository.getById(id);
    }

    public void delete(NXS nxs){
        nxsRepository.delete(nxs);
    }



}
