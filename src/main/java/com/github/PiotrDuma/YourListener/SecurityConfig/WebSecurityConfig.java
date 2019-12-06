package com.github.PiotrDuma.YourListener.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.github.PiotrDuma.YourListener.Users.UserDetailServiceConfig;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailServiceConfig userDetailsService;

	@Autowired
	WebSecurityConfig(UserDetailServiceConfig userDetailServiceConfig){
		this.userDetailsService = userDetailServiceConfig;
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
		auth.userDetailsService(userDetailsService);
	}
}