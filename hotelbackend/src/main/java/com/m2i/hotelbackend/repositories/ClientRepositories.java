package com.m2i.hotelbackend.repositories;

import com.m2i.hotelbackend.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepositories extends CrudRepository<Client, Integer> {
    Iterable<Client> findByNomCompletContainsOrEmailContains(String search, String search1);

    Client findByEmail(String email);
}
