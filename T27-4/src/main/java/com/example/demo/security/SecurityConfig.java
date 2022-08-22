package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
	
		// Login filter (requests for /login)
		.addFilterBefore(new LoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)

				
		// Token filter (other requests that are not /login)
		.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Default account creation
		auth.inMemoryAuthentication().withUser("admin1").password("{noop}123").roles("ADMIN");

		auth.inMemoryAuthentication().withUser("user1").password("{noop}root").roles("USER");
	}
}