package com.metacube.assignment.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * 
 * @author Sabir
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/**
	 * 
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
	
	/**
	 * 
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home")
            .hasAnyRole("USER", "ADMIN").antMatchers("/home/showStudents").hasAnyRole("USER", "ADMIN")
            .antMatchers("/home/studentForm").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
            .loginPage("/login")
            .permitAll().and().logout().permitAll();

        http.csrf().disable();
    }

    /**
     * 
     * @param authenticationMgr
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
        .withUser("employee").password("{noop}employee").authorities("ROLE_USER").and()
        .withUser("admin").password("{noop}admin").authorities("ROLE_USER", "ROLE_ADMIN");
    }
}