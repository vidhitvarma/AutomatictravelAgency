package com.travel.agency.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity security) throws Exception {
		
		return security.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	
	@Bean
	public UserDetailsService service() {
		UserDetails user1 = User.withUsername("user1").password("user1").roles("USER").build();
		UserDetails admin1 = User.withUsername("admin").password("admin").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user1, admin1);
	}

}
