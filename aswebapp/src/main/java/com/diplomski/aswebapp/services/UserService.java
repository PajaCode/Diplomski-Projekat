package com.diplomski.aswebapp.services;

import com.diplomski.aswebapp.entities.Role;
import com.diplomski.aswebapp.entities.User;
import com.diplomski.aswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired(required = true)

    private UserRepository userRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findOne(String email)
    {

        return userRepository.findById(email).get();
    }

    public Boolean isUserPresent(String email) {
        User u=userRepository.findById(email).orElse(null);
        if(u!=null){
            return true;}

        if (u==null){
        return false;
        }
        else
            return null;
    }

    public List<User> findByName(String name) {
        return  userRepository.findByNameLike("%"+name+"%");
    }

}

