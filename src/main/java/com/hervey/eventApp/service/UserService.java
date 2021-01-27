package com.hervey.eventApp.service;

import com.hervey.eventApp.exceptions.UsernameAlreadyExistsException;
import com.hervey.eventApp.model.User;
import com.hervey.eventApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user){
        try{
            return userRepo.save(user);
        }catch(Exception ex){
            throw new UsernameAlreadyExistsException("User "+ user.getUsername()+ " already exists.");
        }
    }
}
