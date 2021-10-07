package com.m2i.hotelbackend.services;


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
            return hotelRepositories.findByNomContainsOrVilleContains( search , search );
        }
    }

    private void checkHotel(String nom, String etoiles, String adresse, String telephone, String email, String ville) throws Exception {
        if (nom.length() < 2){
            throw new Exception("Le nom doit être supèrieur à 2 caractères");
        }
        if (etoiles.length() < 0 || etoiles.length() > 2){
            throw new Exception("Le chiffre doit être entre 0 et 5");
        }
        if (adresse.length() < 2){
            throw new Exception("L'adresse doit comporter plus de 2 caractères");
        }
        if (telephone.length() < 10 || telephone.length() > 15){
            throw new Exception("Le telephone doit comporter 10 chiffres avec ou sans espaces ou tirets");
        }
        if (email.length() < 2){
            throw new Exception("L'email doit comporter plus de 2 caractères");
        }
        if (ville.length() < 2){
            throw new Exception("La ville doit être supèrieure à 2 caractères");
        }
    }

    public Hotel find(int id) {
        return hotelRepositories.findById(id).get();
    }

    public Hotel addHotel(String nom, String etoiles, String adresse, String telephone, String email, String ville) {
        Hotel h = new Hotel();
        h.setNom(nom);
        h.setEtoiles(etoiles);
        h.setAdresse(adresse);
        h.setTelephone(telephone);
        h.setEmail(email);
        h.setVille(ville);
        hotelRepositories.save(h);
        return h;
    }

    public Hotel editHotel(int id, String nom, String etoiles, String adresse, String telephone, String email, String ville) {
        Hotel h = hotelRepositories.findById(id).get();
        h.setNom(nom);
        h.setEtoiles(etoiles);
        h.setAdresse(adresse);
        h.setTelephone(telephone);
        h.setEmail(email);
        h.setVille(ville);
        hotelRepositories.save(h);
        return h;
    }

    public void delete(int id) {
        hotelRepositories.deleteById(id);
    }

    public Hotel findByVille(String ville){
        try {
            return hotelRepositories.findByVille(ville);
        } catch (Exception e){
            return null;
        }
    }
}
