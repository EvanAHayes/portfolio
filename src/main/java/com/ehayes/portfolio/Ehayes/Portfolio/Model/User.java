package com.ehayes.portfolio.Ehayes.Portfolio.Model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Size(min = 3, max = 20)
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Please Enter a username")
    private String username;

    @NonNull
    @Column(name = "password")
    @Size(min = 4)
    @NotEmpty(message = "Please Enter a Password")
    private String password;

    @NonNull
    @Column
    @NotEmpty(message = "Please Enter Your First Name")
    private String FirstName;

    @NonNull
    @Column
    @NotEmpty(message = "Please Enter Your Last Name")
    private String LastName;

    @NonNull
    @Column(name = "age")
    @NotEmpty(message = "Enter Your Age")
    private String age;

    @NonNull
    @Column(name = "phonenumber")
    @NotEmpty(message = "Please Enter Your Phone Number")
    private String PhoneNumber;

    //immediatly load roles with fetch type
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )

    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        roles.add(role);
    }


    @Transient
    @Setter(AccessLevel.NONE)
    private String fullName;

    public String getFullName(){
        return FirstName + " " + LastName;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        //return the authorities list
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
