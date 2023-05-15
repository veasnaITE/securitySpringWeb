package com.istad.securitydemo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/homepage")
    @ResponseBody
    public String adminHomePage(){
        return "this is admin homepage";
    }

    @GetMapping("/feed")
    @ResponseBody
    public String adminFeed(){
        return "this is the admin feed page";
    }
}
