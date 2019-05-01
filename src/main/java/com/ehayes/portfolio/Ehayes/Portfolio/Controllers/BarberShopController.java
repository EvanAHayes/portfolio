package com.ehayes.portfolio.Ehayes.Portfolio.Controllers;

import com.ehayes.portfolio.Ehayes.Portfolio.Model.User;
import com.ehayes.portfolio.Ehayes.Portfolio.Repository.UserRepository;
import com.ehayes.portfolio.Ehayes.Portfolio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class BarberShopController {

    @Autowired
    UserService userService;

    public BarberShopController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/barbershop")
    public String Shop(){
        return "BarberShop";
    }

    @GetMapping(value = "/SignIn")
    public String Login(){
        return "SignIn";
    }

    @GetMapping(value = "/NewUser")
    public String Register(Model model){
        model.addAttribute("user", new User());
        return "Register";
    }

    @PostMapping(value = "/NewUser")
    public String NewUser(@Valid User user, BindingResult bindingResult, Model model,
                          RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "Register";
        }else{

            userService.Register(user);
            redirectAttributes.addFlashAttribute("Success", true);
            return "redirect:/NewUser";

        }
    }

    @GetMapping(value = "/BookAppointment")
    public String Appointment(){
        return "BookAppointment";
    }
}
