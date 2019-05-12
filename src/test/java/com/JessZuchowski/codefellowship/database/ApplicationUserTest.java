package com.JessZuchowski.codefellowship.database;

import com.JessZuchowski.codefellowship.security.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationUserTest {

    @Autowired
    UserDetailsServiceImpl service;

    @Autowired
    UserRepository repo;


    @Test
    public void getId() {
        fail();
    }

    @Test
    public void getAuthorities() {
        fail();
    }

    @Test
    public void setUsername() {
        fail();
    }

    @Test
    public void getUsername() {
        fail();
    }

    @Test
    public void setPassword() {
        fail();
    }

    @Test
    public void getPassword() {
        fail();
    }

    @Test
    public void setFirstName() {
        fail();
    }

    @Test
    public void getFirstName() {
        fail();
    }

    @Test
    public void setLastName() {
        fail();
    }

    @Test
    public void getLastName() {
        fail();
    }

    @Test
    public void setDateOfBirth() {
        fail();
    }

    @Test
    public void getDateOfBirth() {
        fail();
    }

    @Test
    public void setBio() {
        fail();
    }

    @Test
    public void getBio() {
        fail();
    }
}