package com.istad.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/homepage")
    public String userHomepage(){
        return "this is the homepage";
    }
    @GetMapping("/feed")
    public String userFeed(){
        return "this is the user Feed";
    }
}
