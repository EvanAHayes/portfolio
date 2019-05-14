package com.ehayes.portfolio.Ehayes.Portfolio.Service;

import com.ehayes.portfolio.Ehayes.Portfolio.Model.Appointment;
import com.ehayes.portfolio.Ehayes.Portfolio.Model.BarberName;
import com.ehayes.portfolio.Ehayes.Portfolio.Repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentService {

   private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> FindAppointments(){return appointmentRepository.findAll();}

    public List<BarberName> getAllBarbers(){return barber;}

    public Appointment Save(Appointment appointment){return appointmentRepository.save(appointment);}


    public static final List<BarberName> barber = Arrays.asList(

            new BarberName("darnell"),
            new BarberName("Alex"),
            new BarberName("chaz"),
            new BarberName("Rell")
    );


}
