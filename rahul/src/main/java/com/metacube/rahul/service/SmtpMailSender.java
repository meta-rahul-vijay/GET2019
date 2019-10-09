package com.metacube.rahul.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmtpMailSender implements MailSender {

	@Override
	public String sendMail() {
		return "send mail via Smtp Mail Sender";
	}

}
