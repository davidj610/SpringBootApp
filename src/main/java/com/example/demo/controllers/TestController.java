package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import com.example.demo.utils.PrivateClass;

@RestController()
@RequestMapping("/test")
public class TestController {

    @GetMapping("string")
    public String stringTest(){
        String str1 = "str1";
        String str2 = str1;

        Boolean result = str1 == str2;
        String htm = "<html><body>%s</body></html>";
        return htm.formatted(result.toString());

    }
    @GetMapping("optional")
    public String optionalTest(){
        Optional opt = Optional.ofNullable(null);
        String htm = "<html><body>%s</body></html>";
        return htm.formatted("other");

    }

    @GetMapping("reflection")
    public String reflectionTest(){

        try {
            PrivateClass cls = (PrivateClass) Class.forName("com.example.demo.utils.PrivateClass").newInstance();
        }catch(Exception e){ e.printStackTrace();}

        return "complete";
    }

}
