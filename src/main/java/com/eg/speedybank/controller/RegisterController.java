package com.eg.speedybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eg.speedybank.dto.RegisterRequestDTO;
import com.eg.speedybank.dto.RegisterResponseDTO;
import com.eg.speedybank.entity.SpeedyUser;
import com.eg.speedybank.service.RegisterService;
import com.eg.speedybank.validator.RegisterValidator;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@RestController
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@Autowired
	SpeedyUser user;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RegisterResponseDTO register(@RequestBody RegisterRequestDTO userDto) {
		return registerService.registerUser(userDto);
	}
	
}