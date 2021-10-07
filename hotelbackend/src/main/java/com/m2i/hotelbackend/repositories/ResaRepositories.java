package com.m2i.hotelbackend.repositories;

import com.m2i.hotelbackend.model.Resa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResaRepositories extends CrudRepository<Resa, Integer> {

    Iterable<Resa> findByClientContains(String search);

    Optional<Resa> findByClient(String nomClient);
}
