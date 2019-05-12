package com.JessZuchowski.codefellowship.controllers;

import com.JessZuchowski.codefellowship.UserNotFoundException;
import com.JessZuchowski.codefellowship.database.ApplicationUser;
import com.JessZuchowski.codefellowship.database.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/signup")
    public String getSignup() {

        return "signup";
    }
//    POST, save to DB
    @PostMapping("/signup")
    public RedirectView postSignup(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dateOfBirth,
            @RequestParam String bio
    ) {
        ApplicationUser user = new ApplicationUser();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirth(dateOfBirth);
        user.setBio(bio);

        repo.save(user);

        //to auto login
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user,
                null,
                user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(token);

        return new RedirectView("/myprofile");
    }

//    login
    @GetMapping("/login")
    public String getLogin() {

        return "login";
    }

    @GetMapping("/login-error")
    @ResponseBody
    public String getLoginError() {

        return "Incorrect Username or Password";
    }

    //view single user details
    @GetMapping("/users/{id}")
    public String getUser(
            Model model,
            @PathVariable Long id
    ) {
        Optional<ApplicationUser> user = this.repo.findById(id);
        if (user.isPresent()) {
            model.addAttribute("users" , user.get());
            return "users";
        } else {
            throw new UserNotFoundException();
        }
    }

    //view profile page
    @GetMapping("/myprofile/{id}")
    public String myProfile(
            Model model1,
            @PathVariable Long id
    ) {
        Optional<ApplicationUser> user = this.repo.findById(id);
        if (user.isPresent()) {
            model1.addAttribute("myProfile" , user.get());
            return "myProfile";
        } else {
            throw new UserNotFoundException();
        }
    }
    //Stretch: Allow user to edit ApplicationUser


}
