package com.github.PiotrDuma.YourListener.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailServiceEngine;

	@Autowired
	public WebSecurityConfig(UserDetailsService userDetailServiceEngine) {
		this.userDetailServiceEngine = userDetailServiceEngine;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .antMatchers("/", "/home").permitAll()
	        .antMatchers("/register").permitAll()
	        .antMatchers("/admin").hasAuthority("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	      .formLogin()
	        .loginPage("/login").permitAll()
	        .defaultSuccessUrl("/",true)
//	        .failureUrl("/login?error=true")
	        .and()
	      .logout()
	        .permitAll()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    	.logoutSuccessUrl("/logout")
	    	.and().csrf().disable();
  }

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServiceEngine);
	}
}