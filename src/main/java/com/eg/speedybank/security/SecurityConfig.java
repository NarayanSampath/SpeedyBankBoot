package com.eg.speedybank.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
//	@Autowired
//	private LoginSuccessHandler successHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(userDetailsService());
		return authProvider;
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select u.email,u.password,d.enabled from speedyuser u, speedyuserdetails d where u.email=?")
				.authoritiesByUsernameQuery(
						"select u.email, z.authority from speedyuser u "
						+ "INNER JOIN speedyuserdetails_authorities d on u.user_details_id = d.speedy_user_details_id "
						+ "INNER JOIN speedyuserdetails_authorities a on a.speedy_user_details_id = u.user_details_id "
						+ "INNER JOIN speedy_authority z on z.id = a.authorities_id where u.email=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().httpBasic().and().authorizeRequests()
				.antMatchers("/signin", "/reg", "/", "/register", "/css/**", "/js/**", "/images/**", "/videos/**").permitAll()
//				.antMatchers("/userdash").hasAnyRole("ADMIN", "USER").anyRequest().authenticated()
				.antMatchers("/admindash").hasRole("ADMIN").anyRequest().authenticated().and()
				.formLogin().permitAll().and().logout().permitAll();
//				.successHandler(successHandler)
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

}
