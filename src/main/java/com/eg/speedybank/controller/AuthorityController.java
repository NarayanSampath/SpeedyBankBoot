package com.eg.speedybank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eg.speedybank.entity.SpeedyAuthority;
import com.eg.speedybank.repository.ISpeedyUserRepository;
import com.eg.speedybank.repository.SpeedyAuthorityRepository;
import com.eg.speedybank.request.dto.AuthorityRequestDTO;
import com.eg.speedybank.response.dto.AuthorityResponseDTO;

@RestController
@RequestMapping(value = "/authorities")
public class AuthorityController {
    @Autowired
    SpeedyAuthorityRepository authRepo;
    @Autowired
    ISpeedyUserRepository userRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<SpeedyAuthority> getAuthorities() {
        Iterable<SpeedyAuthority> authorities = authRepo.findAll();
        List<SpeedyAuthority> newAuth = new ArrayList<>();
        for (SpeedyAuthority authority : authorities) {
            authority.setAuthority(authority.getAuthority().split("_")[1]);
            newAuth.add(authority);
        }
        return newAuth;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public AuthorityResponseDTO deleteAuthority(@RequestBody AuthorityRequestDTO authority) {
        SpeedyAuthority deleteAuth = authRepo.findById(authority.getId()).get();
        AuthorityResponseDTO respDto = new AuthorityResponseDTO();
        respDto.setAuthority(authority.getAuthority());
        if (deleteAuth != null) {
            authRepo.delete(deleteAuth);
            respDto.setMessage("Deleted Successfully");
            respDto.setStatus("Success");
        } else {
            respDto.setMessage("Authorities Don't Exist.");
            respDto.setStatus("Failed");
        }
        return respDto;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public AuthorityResponseDTO createAuthority(@RequestBody AuthorityRequestDTO authority) {
        SpeedyAuthority newAuthority = new SpeedyAuthority();
        AuthorityResponseDTO authDto = new AuthorityResponseDTO();
        authDto.setAuthority(authority.getAuthority());
        String queryAuthority = "ROLE_" + (authority.getAuthority().toLowerCase()).toUpperCase();
        if (authRepo.findByAuthority(queryAuthority) == null) {
            newAuthority.setAuthority(queryAuthority);
            authDto.setStatus("Success");
            authDto.setMessage("Created Successfully");
        } else {
            authDto.setStatus("Failed");
            authDto.setMessage("Authority Name already Exists");
        }
        authRepo.save(newAuthority);
        return authDto;
    }

}
