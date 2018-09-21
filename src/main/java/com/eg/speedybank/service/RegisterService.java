package com.eg.speedybank.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eg.speedybank.dto.RegisterRequestDTO;
import com.eg.speedybank.dto.RegisterResponseDTO;
import com.eg.speedybank.entity.SpeedyAuthority;
import com.eg.speedybank.entity.SpeedyUser;
import com.eg.speedybank.entity.SpeedyUserDetails;
import com.eg.speedybank.repository.IRegisterRepository;
import com.eg.speedybank.repository.SpeedyAuthorityRepository;
import com.eg.speedybank.validator.RegisterValidator;
@Service
public class RegisterService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	RegisterValidator regValidator;
	@Autowired
	IRegisterRepository registerRepo;
	@Autowired
	SpeedyAuthorityRepository authRepo;
	public RegisterResponseDTO registerUser(RegisterRequestDTO userDto) {
		SpeedyUser user = new SpeedyUser();
		RegisterResponseDTO response = new RegisterResponseDTO();
		response.setEmail(userDto.getEmail());
		String errorMessage = regValidator.ValidateNewUser(userDto);
		if (errorMessage == "") {
			try {
				String role="ROLE_USER";
				SpeedyAuthority isauthority = authRepo.findByAuthority(role);
				if(isauthority==null) {
					SpeedyAuthority newAuthority = new SpeedyAuthority();
					newAuthority.setAuthority(role);
					authRepo.save(newAuthority);
				}
				SpeedyAuthority authority = authRepo.findByAuthority(role);
				
				SpeedyUserDetails userDetails = new SpeedyUserDetails();
				userDetails.setAccountNonExpired(true);
				userDetails.setAccountNonLocked(true);
				userDetails.setCredentialsNonExpired(true);
				userDetails.setEnabled(true);
				userDetails.getAuthorities().add(authority);
				
				user.setSpeedyUsername(userDto.getUserName());
				user.setEmail(userDto.getEmail());
				user.setPassword(passwordEncoder.encode(userDto.getPassword()));
				user.setUserDetails(userDetails);
				
				
				registerRepo.save(user);
				response.setStatus("Success");
				response.setMessage("Registered Successfully");
			} catch (DataIntegrityViolationException e) {
				response.setStatus("Failed");
				response.setMessage("User Already exists");
			}
		} else {
			response.setStatus("Failed");
			response.setMessage(errorMessage);
		}
		return response;

	}
}