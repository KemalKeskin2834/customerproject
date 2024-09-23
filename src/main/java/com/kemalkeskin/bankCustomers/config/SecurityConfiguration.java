package com.kemalkeskin.bankCustomers.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	// ADMİN					//MANAGER
	//username: kemal			USERNAME:salih
	//password: deneme123		PASSWORD:salih123
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		 JdbcUserDetailsManager detailsManager=new JdbcUserDetailsManager(dataSource);
		 detailsManager.setUsersByUsernameQuery("select username,password from users where username=?");
		 detailsManager.setAuthoritiesByUsernameQuery("select username,authority from authorities where username=?");
		 return detailsManager;
		 
	}
	
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer->configurer.requestMatchers(HttpMethod.GET,"/basecustomer/basecustomers").hasRole("ADMİN")
																.requestMatchers(HttpMethod.GET,"/corporatecustomer/corporatecustomers/**").hasRole("ADMİN")
																.requestMatchers(HttpMethod.GET,"/individualcustomer/individualcustomers/**").hasRole("ADMİN")
																
																.requestMatchers(HttpMethod.DELETE,"/corporatecustomer/corporatecustomers/**").hasRole("ADMİN")	
																.requestMatchers(HttpMethod.PUT,"/corporatecustomer/corporatecustomers/**").hasRole("MANAGER")
																.requestMatchers(HttpMethod.POST,"/corporatecustomer/corporatecustomers/**").hasRole("MANAGER")
																.requestMatchers(HttpMethod.GET,"/corporatecustomer/corporatecustomers/**").hasRole("MANAGER")
																
																.requestMatchers(HttpMethod.DELETE,"/individualcustomer/individualcustomers/**").hasRole("ADMİN")
																.requestMatchers(HttpMethod.PUT,"/individualcustomer/individualcustomers/**").hasRole("MANAGER")
																.requestMatchers(HttpMethod.POST,"/individualcustomer/individualcustomers/**").hasRole("MANAGER")
																.requestMatchers(HttpMethod.GET,"/individualcustomer/individualcustomers/**").hasRole("MANAGER")
				
				
				
				
				
				);
	 http.httpBasic(Customizer.withDefaults());
	 http.csrf(csrf->csrf.disable());
	 return http.build();
	}
	
	
}
