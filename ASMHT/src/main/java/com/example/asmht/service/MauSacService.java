package com.example.asmht.service;

import com.example.asmht.entity.MauSac;
import com.example.asmht.repository.MauSacRepository;

import java.util.ArrayList;

public class MauSacService {
    MauSacRepository mauSacRepository=new MauSacRepository();

    public ArrayList<MauSac> getList(){
        return mauSacRepository.getList();
    }

    public void add(MauSac ms){
        mauSacRepository.add(ms);
    }

    public void update(MauSac ms){
        mauSacRepository.update(ms);
    }

    public MauSac getById(String id){
        return mauSacRepository.getById(id);
    }

    public void delete(MauSac mauSac){
        mauSacRepository.delete(mauSac);
    }



}
