package com.eg.speedybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eg.speedybank.entity.SpeedyUser;
import com.eg.speedybank.request.dto.RegisterRequestDTO;
import com.eg.speedybank.response.dto.RegisterResponseDTO;
import com.eg.speedybank.service.RegisterService;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

//    @Autowired
//    SpeedyUser user;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public RegisterResponseDTO register(@RequestBody RegisterRequestDTO userDto) {
        return registerService.registerUser(userDto);
    }
}