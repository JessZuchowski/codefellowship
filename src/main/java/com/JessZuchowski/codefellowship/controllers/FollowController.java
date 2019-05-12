package com.JessZuchowski.codefellowship.controllers;

import com.JessZuchowski.codefellowship.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/feed")
public class FollowController {

    @Autowired
    PostRepository postRepo;

    @Autowired
    FollowRepository followRepo;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/test")
    public String test() {
        ApplicationUser user1 = new ApplicationUser("Yew");
        userRepo.save(user1);

        ApplicationUser user2 = new ApplicationUser("Uma");
        userRepo.save(user2);

        UserFollow follow = new UserFollow(user1, user2, new Date());
        followRepo.save(follow);

        return "redirect:/feed/";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("feed", postRepo.findAll());
        return "feed/index";
    }
}
