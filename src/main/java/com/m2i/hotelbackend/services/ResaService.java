package com.m2i.hotelbackend.services;

import com.m2i.hotelbackend.model.Hotel;
import com.m2i.hotelbackend.model.Resa;
import com.m2i.hotelbackend.repositories.ResaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Service
public class ResaService {

    @Autowired
    private final ResaRepositories resaRepositories;

    public ResaService(ResaRepositories resaRepositories) {
        this.resaRepositories = resaRepositories;
    }

    public Iterable<Resa> getList(String search){
        if (search == null || search.length() == 0){
            return resaRepositories.findAll();
        } else {
            return resaRepositories.findByNomContainsOrEmailContains( search , search );
        }
    }


    public Resa find(int id) {
    }

    public Resa addResa(Integer id, Integer id1, Date dateDebut, Date dateFin, int numChambre) {
    }

    public Resa edit(int id, Integer id1, Integer id2, Date dateDebut, Date dateFin, int numChambre) {
    }

    public void delete(int id) {
    }
}
