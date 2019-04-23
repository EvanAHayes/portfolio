package com.ehayes.portfolio.Ehayes.Portfolio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarberShopController {

    @GetMapping(value = "/barbershop")
    public String Shop(){
        return "BarberShop";
    }

    @GetMapping(value = "/SignIn")
    public String Login(){
        return "SignIn";
    }

    @GetMapping(value = "/NewUser")
    public String NewUser(){
        return "Register";
    }

    @GetMapping(value = "/BookAppointment")
    public String Appointment(){
        return "BookAppointment";
    }
}
