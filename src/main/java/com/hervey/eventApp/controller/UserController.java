package com.hervey.eventApp.controller;

import com.hervey.eventApp.model.User;
import com.hervey.eventApp.service.MapValidationErrorService;
import com.hervey.eventApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        ResponseEntity<?> err = mapValidationErrorService.MapValidation(result);
        if(err != null){
            return err;
        }

        User user1 = userService.saveUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }
}
