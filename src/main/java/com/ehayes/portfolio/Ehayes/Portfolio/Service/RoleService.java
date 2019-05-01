package com.ehayes.portfolio.Ehayes.Portfolio.Service;

import com.ehayes.portfolio.Ehayes.Portfolio.Model.Role;
import com.ehayes.portfolio.Ehayes.Portfolio.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public Role Save(Role name){return roleRepository.save(name);}

//    Role userRole = new Role("ROLE_USER");
//        roleRepository.save(userRole);
}
