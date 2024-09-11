package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.utils.SNSUtil;

@RestController
@RequestMapping("/sns")
public class SNSController {

    @GetMapping
    public String publishToSNS(){
        System.out.println("in SNS controller");
        SNSUtil snsUtil = new SNSUtil();
        String status = snsUtil.publish();
        return status;
    }
}
