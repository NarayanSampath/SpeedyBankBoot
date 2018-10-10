package com.eg.speedybank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eg.speedybank.entity.SpeedyAuthority;
import com.eg.speedybank.entity.SpeedyUser;
import com.eg.speedybank.repository.ISpeedyUserRepository;
import com.eg.speedybank.repository.SpeedyAuthorityRepository;
import com.eg.speedybank.request.dto.GroupAuthoritiesRequestDTO;
import com.eg.speedybank.response.dto.GroupAuthoritiesResponseDTO;
import com.eg.speedybank.response.dto.UserResponseDTO;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    ISpeedyUserRepository userRepo;
    @Autowired
    SpeedyAuthorityRepository authRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<UserResponseDTO> getUsers() {
        List<UserResponseDTO> userDetails = new ArrayList<>();
        for (SpeedyUser user : userRepo.findAll()) {
            UserResponseDTO responseDto = new UserResponseDTO();
            responseDto.setId(user.getId());
            responseDto.setEmail(user.getEmail());
            responseDto.setPassword(user.getUserDetails().getPassword());
            responseDto.setSpeedyUsername(user.getUserDetails().getUsername());
            responseDto.setCredentialsNonExpired(user.getUserDetails().isCredentialsNonExpired());
            responseDto.setAccountNonLocked(user.getUserDetails().isAccountNonLocked());
            responseDto.setAccountNonExpired(user.getUserDetails().isAccountNonExpired());
            responseDto.setEnabled(user.getUserDetails().isEnabled());
            userDetails.add(responseDto);
        }
        return userDetails;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<SpeedyAuthority> getAuthoritiesForUser(@PathVariable(value = "id") Long id) {
        SpeedyUser user = userRepo.findById(id).get();
        return user.getUserDetails().getAuthorities();
    }

    @RequestMapping(value = "/authority", method = RequestMethod.POST)
    public GroupAuthoritiesResponseDTO addAuthorities(@RequestBody GroupAuthoritiesRequestDTO userAuths) {
        GroupAuthoritiesResponseDTO resp = new GroupAuthoritiesResponseDTO();
        for (Long user : userAuths.getUserIds()) {
            if (userRepo.findById(user) != null) {
                SpeedyUser currentUser = userRepo.findById(user).get();
                resp.setUser(currentUser.getEmail());
                List<SpeedyAuthority> authList = new ArrayList<>();
                for (Long authId : userAuths.getAuthorityIds()) {
                    if (authRepo.findById(authId) != null) {
                        authList.add(authRepo.findById(authId).get());
                    } else {
                        resp.setStatus("Failed");
                        resp.setMessage("Authorities don't exist");
                        break;
                    }
                }
                currentUser.getUserDetails().setAuthorities(authList);
                userRepo.save(currentUser);
                resp.setStatus("Success");
                resp.setMessage("User Authorities Updated");
            } else {
                resp.setStatus("Failed");
                resp.setMessage("User Doesn't exist");
            }
        }
        return resp;
    }
}
