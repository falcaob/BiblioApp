package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(request -> request
					.requestMatchers("/").permitAll()
					.requestMatchers("/libros/**", "/css/*", "/js/*", "/img/*").hasAnyRole("USER", "ADMIN")
					.requestMatchers("/usuarios/**").hasAnyRole("USER", "ADMIN")			
					.anyRequest().authenticated()
			).formLogin(login -> login.permitAll()
					);
		return http.build();
	} 

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager userManager = new InMemoryUserDetailsManager();

		userManager
				.createUser(User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build());
		userManager.createUser(
				User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());

		return userManager;

	}

}
