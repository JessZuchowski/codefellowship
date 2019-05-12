package com.JessZuchowski.codefellowship.security;

import com.JessZuchowski.codefellowship.database.ApplicationUser;
import com.JessZuchowski.codefellowship.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//look up username from login form
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username);
    }
}
