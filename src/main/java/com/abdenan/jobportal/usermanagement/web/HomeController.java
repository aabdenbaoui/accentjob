package com.abdenan.jobportal.usermanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
   @GetMapping("/signup")
    public String sayHello(){
        return "signup";
    }

}
