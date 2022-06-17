package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
public class GreetingsController {

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }
}
