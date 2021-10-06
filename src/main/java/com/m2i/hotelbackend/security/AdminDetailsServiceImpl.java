package com.m2i.hotelbackend.security;

import com.m2i.hotelbackend.model.Admin;
import com.m2i.hotelbackend.repositories.AdminRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepositories adminRepositories;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminRepositories.findByUsername(s);
        if (admin == null){
            throw new UsernameNotFoundException("No User named " + s);
        } else {
            return new AdminDetailsImpl(admin);
        }
    }
}
