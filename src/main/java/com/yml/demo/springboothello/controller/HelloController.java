package com.yml.demo.springboothello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("world")
    public String world() {
        return "hello world";
    }
}
