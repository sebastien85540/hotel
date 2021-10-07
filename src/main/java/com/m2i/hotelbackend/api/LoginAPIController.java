package com.m2i.hotelbackend.api;

import com.m2i.hotelbackend.model.Admin;
import com.m2i.hotelbackend.repositories.AdminRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/login")
public class LoginAPIController {

    @Autowired
    AdminRepositories adminRepositories;

    @PostMapping(path = "", produces = "application/json")
    ResponseEntity<Admin> checkLogin(@RequestBody Admin user){

        try {
            Admin admin = adminRepositories.findByUsername(user.getUserName());
            admin.setPassword("");
            return ResponseEntity.ok()
                    .body(admin);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
