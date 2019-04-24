package com.ehayes.portfolio.Ehayes.Portfolio.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Size(min = 8, max = 20)
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Please Enter a username")
    private String Username;

    @NonNull
    @Column
    @NotEmpty(message = "Please Enter a Password")
    private String Password;

    @NonNull
    @Column
    @NotEmpty(message = "Please Enter Your First Name")
    private String FirstName;

    @NonNull
    @Column
    @NotEmpty(message = "Please Enter Your Last Name")
    private String LastName;

    @NonNull
    @Column
    @NotEmpty(message = "Enter Your Age")
    private String age;

    @NonNull
    @Column
    @NotEmpty(message = "Please Enter Your Phone Number")
    private String PhoneNUmber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )


    private Set<Role> roles = new HashSet();

    @Transient
    @Setter(AccessLevel.NONE)
    private String fullName;

    public String getFullName(){
        return FirstName + " " + LastName;
    }



}
