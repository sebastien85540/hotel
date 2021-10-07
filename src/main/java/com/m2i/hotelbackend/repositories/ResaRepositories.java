package com.m2i.hotelbackend.repositories;

import com.m2i.hotelbackend.model.Resa;
import org.springframework.data.repository.CrudRepository;

public interface ResaRepositories extends CrudRepository<Resa, Integer> {
    Iterable<Resa> findByNomContainsOrEmailContains(String search, String search1);
}
