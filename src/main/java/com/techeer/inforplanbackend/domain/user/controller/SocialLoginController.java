package com.techeer.inforplanbackend.domain.user.controller;

import com.techeer.inforplanbackend.domain.user.config.auth.SessionUsers;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/google")
public class SocialLoginController {
    private final HttpSession httpSession;

    @GetMapping("/signin")
    public String index(Model model){
        //model.addAttribute("posts", postsService.findAllDesc());

        SessionUsers user = (SessionUsers) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index.mustache";
    }
}