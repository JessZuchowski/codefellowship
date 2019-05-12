package com.JessZuchowski.codefellowship;

import com.JessZuchowski.codefellowship.database.ApplicationUser;
import com.JessZuchowski.codefellowship.database.UserRepository;
import com.JessZuchowski.codefellowship.security.UserDetailsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodefellowshipApplicationTests {

    @Autowired
    UserDetailsServiceImpl service;

    @Autowired
    UserRepository userRepo;

//    @Test
//    public void testAppUsers() {
//        ApplicationUser user = new ApplicationUser();
//        user.setUsername("Yew");
//
//        userRepo.save(user);
//
//        UserDetails results = service.loadUserByUsername("Yew");
//        assertEquals("Yew", results.getUsername());
//
//    }

}
