package com.ehayes.portfolio.Ehayes.Portfolio.Model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String barber;

    @NonNull
    private Date date;

    @NonNull
    private String time;

    @ManyToOne
    private User user;





}
