package com.metacube.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.rahul.service.MailSender;

@RestController
public class MailController {

	private MailSender mailSender;
	
	
	//injection using constructor
	@Autowired
	public MailController(MailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}
	
	
	//setter injection by primary or qualifier
	/*@Autowired
	@Qualifier("mockMailSender")
	public void setMailSender(MailSender mailSender){
		this.mailSender = mailSender;
	}*/
	
	//setter injection by name of smtp mailsender
	/*@Autowired
	public void setMailSender(MailSender smtpMailSender){
		this.mailSender = smtpMailSender;
	}*/
	
	//setter injection by name of mock mailsender
	/*@Autowired
	public void setMailSender(MailSender mockMailSender){
		this.mailSender = mockMailSender;
	}*/
	
	@GetMapping("/send")
	public String getMailSender() {
		System.out.println(mailSender.sendMail());
		return mailSender.sendMail();
	}
	
}
