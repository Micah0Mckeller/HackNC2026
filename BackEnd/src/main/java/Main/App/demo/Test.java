package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    
    @GetMapping("/api/test")
    public String test() {
        return "Test successful!";
    }
}
