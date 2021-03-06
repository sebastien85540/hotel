package com.m2i.hotelbackend.repositories;

import com.m2i.hotelbackend.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepositories extends CrudRepository<Admin, Integer> {

    Admin findByUserName(String s);

}
