package com.m2i.hotelbackend.repositories;

import com.m2i.hotelbackend.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepositories extends CrudRepository<Hotel, Integer> {
    Iterable<Hotel> findByNomContainsOrVilleContains(String search, String search1);

    Hotel findByVille(String ville);
}
