//package com.eg.speedybank.security;
//
//import java.io.IOException;
//import java.util.Collection;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
//			Authentication authentication) throws IOException, ServletException {
//		boolean hasUserRole = false;
//		boolean hasAdminRole = false;
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		System.out.println(authentication.getCredentials());
//		for(GrantedAuthority authority:authorities){
//			System.out.println(authority.getAuthority());
////			if (authority.getAuthority().equals("ROLE_USER")) {
////				hasUserRole=true;
////				break;
////				
////			} 
//			if (authority.getAuthority().equals("ROLE_ADMIN")) {
//				hasAdminRole=true;
//				break;
//			}
////			else {
////				throw new IllegalStateException();
////			}
//		}
//		System.out.println("userRole = "+hasUserRole);
//		System.out.println("admin role = "+hasAdminRole);
//		if (hasUserRole) {
//			redirectStrategy.sendRedirect(arg0, arg1, "/userdash");
//		} else if (hasAdminRole) {
//			redirectStrategy.sendRedirect(arg0, arg1, "/admindash");
//		} else {
//			throw new IllegalStateException();
//		}
//	}
//
//}
