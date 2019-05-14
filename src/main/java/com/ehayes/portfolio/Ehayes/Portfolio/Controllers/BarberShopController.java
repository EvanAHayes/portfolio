package com.ehayes.portfolio.Ehayes.Portfolio.Controllers;

import com.ehayes.portfolio.Ehayes.Portfolio.Model.Appointment;
import com.ehayes.portfolio.Ehayes.Portfolio.Model.BarberName;
import com.ehayes.portfolio.Ehayes.Portfolio.Model.User;
import com.ehayes.portfolio.Ehayes.Portfolio.Repository.UserRepository;
import com.ehayes.portfolio.Ehayes.Portfolio.Service.AppointmentService;
import com.ehayes.portfolio.Ehayes.Portfolio.Service.UserService;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class BarberShopController {

    @Autowired
    UserService userService;

    @Autowired
    AppointmentService appointmentService;

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
    public String Appointment(Model model, ModelMap mp){

        List<BarberName> barber = appointmentService.getAllBarbers();
        mp.put("barbers", barber);

//        model.addAttribute("appointments", appointmentService.FindAppointments());
        model.addAttribute("appointment", new Appointment());
        return "BookAppointment";
    }

    @PostMapping(value = "/BookAppointment")
    public String NewAppointment(@Valid Appointment appointment, BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes, ModelMap mp) throws ParseException {
            if(bindingResult.hasErrors()) {
                model.addAttribute("appointment", appointment);
                List<BarberName> barber = appointmentService.getAllBarbers();
                mp.put("barbers", barber);
                model.addAttribute("validationErrors", bindingResult.getAllErrors());
                return "BookAppointment";
            }
          else{
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
                String Adate = dateFormat.format(appointment.getDate());
                appointment.setDate(dateFormat.parse(Adate));
                appointmentService.Save(appointment);
                redirectAttributes.addFlashAttribute("success", true);
              return "redirect:/BookAppointment";
                }
    }

}
