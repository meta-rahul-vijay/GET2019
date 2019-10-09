package com.metacube.rahul.service;

import org.springframework.stereotype.Component;

@Component
public class MockMailSender implements MailSender {

	@Override
	public String sendMail() {
		return "send mail via Mock Mail Sender";
	}
}
