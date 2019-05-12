package com.JessZuchowski.codefellowship.controllers;

import com.JessZuchowski.codefellowship.UserNotFoundException;
import com.JessZuchowski.codefellowship.database.ApplicationUser;
import com.JessZuchowski.codefellowship.database.PostRepository;
import com.JessZuchowski.codefellowship.database.UserPost;
import com.JessZuchowski.codefellowship.database.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    PostRepository postRepo;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping
    public String getIndex(@AuthenticationPrincipal ApplicationUser user) {
        if (user != null) {
            return "redirect:/myprofile/" + user.getId();
        }
        return "index";
    }

    @GetMapping("/")
    public String getLanding() {
        return "index";
    }

    @GetMapping("/signup")
    public String getSignup(
            @AuthenticationPrincipal ApplicationUser user) {

        if (user != null) {
        }
        return "signup";
    }

    @GetMapping("/addPost")
    public String getAddPost(
            @AuthenticationPrincipal ApplicationUser user) {

        if (user != null) {
        }
        return "signup";
    }

    @GetMapping("/addPost")
    public String addPost(
            Model model2,
            @PathVariable long id
    ) {
        Optional<UserPost> post = this.postRepo.findById(id);
        if (post.isPresent()) {
            model2.addAttribute("addPost", post.get());
        }
            return "addPost";
    }


//    POST, save to DB
    @PostMapping("/addPost")
    public RedirectView addPost(
            @RequestParam String addAPost,
            @AuthenticationPrincipal ApplicationUser applicationUser
    ) {
        UserPost post = new UserPost();
        post.setAddAPost(addAPost);
        post.setApplicationUser(applicationUser);

        post.setPostedAt(new Date());
        post = postRepo.save(post);

        return new RedirectView("/myprofile/");
    }

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

        userRepo.save(user);

        //to auto login
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user,
                null,
                user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(token);

        return new RedirectView("/myprofile/" + user.getId());
    }

//    login
    @GetMapping("/login")
    public String getLogin(
            @RequestParam(required = false, defaultValue = "false") boolean isErrored,
            Model model
    ) {
        model.addAttribute("errored", isErrored);
        return "/login";
    }

    @GetMapping("/login-error")
    @ResponseBody
    public String getLoginError(Model model) {

        model.addAttribute("errored", true);

        return "login";
    }

    //view single user details
    @GetMapping("/users/{id}")
    public String getUser(
            Model model,
            @PathVariable Long id
    ) {
        Optional<ApplicationUser> user = this.userRepo.findById(id);
        if (user.isPresent()) {
            model.addAttribute("users" , user.get());
            return "users";
        } else {
            throw new UserNotFoundException();
        }
    }

    //view profile page
    @GetMapping("/myprofile")
    public String myProfile(
            Model model1,
            @PathVariable Long id
    ) {
        Optional<ApplicationUser> user = this.userRepo.findById(id);
        if (user.isPresent()) {
            model1.addAttribute("myProfile" , user.get());
            return "myProfile";
        } else {
            throw new UserNotFoundException();
        }
    }
    //Stretch: Allow user to edit ApplicationUser


}
