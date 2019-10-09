package com.metacube.rahul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.rahul.service.MailSender;
import com.metacube.rahul.service.MockMailSender;
import com.metacube.rahul.service.SmtpMailSender;


//annotations left to handle
@Configuration
@ComponentScan(basePackages = "com.metacube.rahul.config")
public class MailConfig {
	/*@Bean
	public MailSender smtpMailSender(){
		return new SmtpMailSender();
	}
	//@Primary
	@Bean
	public MailSender mockMailSender(){
		return new MockMailSender();
	}*/
}
 