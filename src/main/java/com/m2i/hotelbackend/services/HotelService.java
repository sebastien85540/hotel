package com.m2i.hotelbackend.services;

import com.m2i.hotelbackend.model.Client;
import com.m2i.hotelbackend.model.Hotel;
import com.m2i.hotelbackend.repositories.HotelRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private final HotelRepositories hotelRepositories;

    public HotelService(HotelRepositories hotelRepositories) {
        this.hotelRepositories = hotelRepositories;
    }

    public Iterable<Hotel> getList(String search){
        if (search == null || search.length() == 0){
            return hotelRepositories.findAll();
        } else {
            return hotelRepositories.findByNomContainsOrEmailContains( search , search );
        }
    }

    public Hotel find(int id) {
    }

    public Hotel addHotel(String nom, String etoiles, String adresse, String telephone, String email, String ville) {
    }

    public Hotel editHotel(int id, String nom, String etoiles, String adresse, String telephone, String email, String ville) {
    }

    public void delete(int id) {
    }
}
