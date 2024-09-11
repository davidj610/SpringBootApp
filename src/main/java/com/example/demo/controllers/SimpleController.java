package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/simple")
public class SimpleController {

    @GetMapping()
    public String doSimple(){
        return "<html><body>Simple response</body></html>";
    }
}
