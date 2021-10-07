package com.m2i.hotelbackend.services;

import com.m2i.hotelbackend.model.Client;
import com.m2i.hotelbackend.model.Hotel;
import com.m2i.hotelbackend.model.Resa;
import com.m2i.hotelbackend.repositories.ClientRepositories;
import com.m2i.hotelbackend.repositories.HotelRepositories;
import com.m2i.hotelbackend.repositories.ResaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResaService {

    @Autowired
    private final ResaRepositories resaRepositories;
    @Autowired
    private final ClientRepositories clientRepositories;

    @Autowired
    private final HotelRepositories hotelRepositories;


    public ResaService(ResaRepositories resaRepositories, ClientRepositories clientRepositories, HotelRepositories hotelRepositories) {
        this.resaRepositories = resaRepositories;
        this.clientRepositories = clientRepositories;
        this.hotelRepositories = hotelRepositories;
    }

    public Iterable<Resa> getList(String search){
        if (search == null || search.length() == 0){
            return resaRepositories.findAll();
        } else {
            return resaRepositories.findByClientContains(search);
        }
    }

    private void checkResa(int idClient, int idHotel, Date dateDebut, Date dateFin, int numChambre) throws Exception {
        List<Resa> reservations = new ArrayList<>();
        reservations = (List<Resa>) resaRepositories.findAll();
        for (Resa r : reservations) {
            if (r.getClient().getId().equals(idClient) && r.getHotel().getId().equals(idHotel) && r.getDateDebut().equals(dateDebut) && r.getDateFin().equals(dateFin) && r.getNumChambre() == numChambre){
                throw new Exception("Ce client a déjà réservé à cette date");
            }
           if (r.getHotel().getId().equals(idHotel) && r.getNumChambre() == numChambre && r.getDateDebut().equals(dateDebut) && r.getDateFin().equals(dateFin)){
               throw new Exception("La chambre " + numChambre + " est déjà louée");
           }
        }
        if (dateDebut.equals(dateFin) && dateDebut.after(dateFin)){
            throw new Exception("La date de début doit se situer avant la date de fin");
        }
    }


    public Resa find(int id) {
        return resaRepositories.findById(id).get();
    }

    public Resa addResa(Integer clientId, Integer hotelId, Date dateDebut, Date dateFin, int numChambre) {
        Resa createResa = new Resa();

        Client c = clientRepositories.findById(clientId).get();
        c.setId(clientId);
        createResa.setClient(c);

        Hotel h = hotelRepositories.findById(hotelId).get();
        h.setId(hotelId);
        createResa.setHotel(h);

        createResa.setDateDebut(dateDebut);
        createResa.setDateFin(dateFin);
        createResa.setNumChambre(numChambre);
        resaRepositories.save(createResa);
        return createResa;

    }

    public Resa edit(int id, Integer clientId, Integer hotelId, Date dateDebut, Date dateFin, int numChambre) {

        Resa editResa = resaRepositories.findById(id).get();

        Client c = clientRepositories.findById(clientId).get();
        c.setId(clientId);
        editResa.setClient(c);

        Hotel h = hotelRepositories.findById(hotelId).get();
        h.setId(hotelId);
        editResa.setHotel(h);

        editResa.setDateDebut(dateDebut);
        editResa.setDateFin(dateFin);
        editResa.setNumChambre(numChambre);
        resaRepositories.save(editResa);
        return editResa;
    }

    public void delete(int id) {
        resaRepositories.deleteById(id);
    }

    public Resa findByClient(String nomClient){
        try {
            return resaRepositories.findByClient(nomClient).get();
        } catch (Exception e){
            return null;
        }
    }
}
