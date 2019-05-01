package com.ehayes.portfolio.Ehayes.Portfolio.Service;


import com.ehayes.portfolio.Ehayes.Portfolio.Model.Role;
import com.ehayes.portfolio.Ehayes.Portfolio.Model.User;
import com.ehayes.portfolio.Ehayes.Portfolio.Repository.RoleRepository;
import com.ehayes.portfolio.Ehayes.Portfolio.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private final RoleRepository roleRepository;



    public UserService(UserRepository userRepository, RoleService roleService, RoleRepository roleRepository1) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.roleRepository = roleRepository1;
        encoder = new BCryptPasswordEncoder();
    }



    public User Register(User user){

//        need to take password from form and encode it
        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);

        //add role user automatically
        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);
        user.addRole(roleService.findByName("ROLE_USER"));

        //Save user to database
        Save(user);

        return user;

    }

    public User Save(User user){
        return userRepository.save(user);
    }


}
