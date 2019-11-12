package com.metacube.SpringSecurityJDBC.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * 
 * @author Sabir
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
    DataSource dataSource;
	
	/**
	 * 
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/Image/**","/css/**","/js/**");
    }
	
	/**
	 * 
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
            .antMatchers("/getUser").hasAnyRole("USER", "ADMIN")
            .antMatchers("/updateUser").hasAnyRole("USER", "ADMIN")
            .antMatchers("/getAdmin").hasAnyRole("ADMIN")
            .antMatchers("/updateAdmin").hasAnyRole("ADMIN")
            .anyRequest().authenticated().and().formLogin().loginPage("/login")
            .permitAll().defaultSuccessUrl("/welcome").failureUrl("/login?error=true").
            and().logout().permitAll();

        http.csrf().disable();
    }
	
	/**
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).dataSource(dataSource);
	 }
}