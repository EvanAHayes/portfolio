package com.ehayes.portfolio.Ehayes.Portfolio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String Main() {
        return "index";
    }


    @GetMapping(value = "/PassGen")
    public String PasswordGen() {
        return "PassGen";
    }
}