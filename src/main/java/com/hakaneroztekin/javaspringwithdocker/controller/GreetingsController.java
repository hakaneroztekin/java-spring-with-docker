package com.hakaneroztekin.javaspringwithdocker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingsController {

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }
}
