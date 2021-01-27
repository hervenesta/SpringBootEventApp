package com.hervey.eventApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidation(BindingResult result){
        if(result.hasErrors()){
            Map<String, String> map = new HashMap<>();
            for(FieldError err: result.getFieldErrors()){
                map.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
