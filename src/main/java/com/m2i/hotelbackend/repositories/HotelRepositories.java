package com.m2i.hotelbackend.repositories;

import com.m2i.hotelbackend.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepositories extends CrudRepository<Hotel, Integer> {
    Iterable<Hotel> findByNomContainsOrEmailContains(String search, String search1);
}
