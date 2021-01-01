package com.gauro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chandra
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @GetMapping
    public String firstPage(){
        return "Hello World";
    }
}
