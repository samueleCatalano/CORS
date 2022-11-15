package com.cors.cors.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomController {

    @CrossOrigin(origins = {"http://localhost:8080"})
    @GetMapping("")
    public String welcomeMsg(){
        return "Welcome!";
    }
}
