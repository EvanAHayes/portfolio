package com.ehayes.portfolio.Ehayes.Portfolio.Model;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Appointment extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @NotEmpty(message = "Please select a barber")
    private String barber;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NonNull
    @NotEmpty(message = "Please choose a time")
    private String time;

    @ManyToOne
    private User user;

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }
}
