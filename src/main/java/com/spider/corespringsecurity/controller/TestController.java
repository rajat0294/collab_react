package com.spider.corespringsecurity.controller;

import com.spider.corespringsecurity.dto.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<Greeting> greet(){
       return ResponseEntity.ok(new Greeting("Hello !!"));
    }
}
