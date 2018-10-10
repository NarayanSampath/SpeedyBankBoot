package com.eg.speedybank.handler;

import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class LoginFailureHandler extends AuthenticationFailureBadCredentialsEvent {


    public LoginFailureHandler(Authentication authentication, AuthenticationException exception) {
        super(authentication, exception);
        // TODO Auto-generated constructor stub
    }

}
