package com.eg.speedybank.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.eg.speedybank.dto.RegisterRequestDTO;

@Component
public class RegisterValidator {

	public String ValidateNewUser(RegisterRequestDTO userDto) {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		String passwordRegex = "(?=\\S+$).{6,}";
		
//		if (validateString(userDto.getEmail(), emailRegex)) 
//			return "Invalid Email";
		if (validateString(userDto.getPassword(), passwordRegex)) 			
			return "Invalid Password";
		
		return "";
	}

	protected static boolean validateString(String mainString, String regex) {

		if (mainString == null)
			return false;

		Pattern pat = Pattern.compile(regex);
		return !pat.matcher(mainString).matches();

	}
}
