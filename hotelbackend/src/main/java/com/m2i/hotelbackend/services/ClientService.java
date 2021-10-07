package com.m2i.hotelbackend.services;

import com.m2i.hotelbackend.model.Client;
import com.m2i.hotelbackend.repositories.ClientRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private final ClientRepositories clientRepositories;

    public ClientService(ClientRepositories clientRepositories) {
        this.clientRepositories = clientRepositories;
    }


    public Iterable<Client> getList(String search){
        if (search == null || search.length() == 0){
            return clientRepositories.findAll();
        } else {
            return clientRepositories.findByNomCompletContainsOrEmailContains( search , search );
        }
    }

    private void checkClient(String nom, String telephone, String email, String ville) throws Exception {
        // vérification du nom complet qui ne peut pas être infèrieur à 2 caractères
        if (nom.length() < 2){
            throw new Exception("nom complet invalide");
        }

        // telephone supèrieur à 9 et infèrieur à 16 caractères
        if (telephone.length() > 9 && telephone.length() < 15){
            throw new Exception("Le numéro doit contenir 10 chiffres avec espaces ou tirets");
        }

        // l'email doit être supèrieur à 2 caractères
        if (email.length() < 2){
            throw new Exception("Votre email est invalide");
        }

        // la ville doit être supèrieur à 2 caractères
        if (ville.length() < 2){
            throw new Exception("Votre ville est invalide");
        }
    }

    public Client find(int id) {
        return clientRepositories.findById(id).get();
    }

    public Client addClient(String nomComplet, String telephone, String email, String adresse) {
        Client c = new Client();
        c.setNomComplet(nomComplet);
        c.setTelephone(telephone);
        c.setEmail(email);
        c.setAdresse(adresse);
        clientRepositories.save(c);
        return c;
    }

    public Client editClient(int id, String nomComplet, String telephone, String email, String adresse) {
        Client c = clientRepositories.findById(id).get();
        c.setNomComplet(nomComplet);
        c.setTelephone(telephone);
        c.setEmail(email);
        c.setAdresse(adresse);
        clientRepositories.save(c);
        return c;
    }

    public void delete(int id) {
        clientRepositories.deleteById(id);
    }

    public Client findByEmail(String email){
        try {
            return clientRepositories.findByEmail(email);
        } catch (Exception e){
            return null;
        }
    }
}
