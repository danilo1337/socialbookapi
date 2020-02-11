package com.algaworks.socialbooks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("danilo").password("a@A.com").roles("USER");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
//		http.
//			authorizeRequests()
//			.antMatchers("/**").permitAll()
//			.anyRequest().authenticated()
//			.and()
//				.httpBasic()
//			.and()
//				.csrf().disable();
	}
}
