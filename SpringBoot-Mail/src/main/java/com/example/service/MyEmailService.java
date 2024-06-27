package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MyEmailService {
	
	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
		System.out.println("Mail Sent Successfully");
	}

	public void sendEmailWithAttachment() {

		try {

			MimeMessage msg = emailSender.createMimeMessage();
			// true = multipart message
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo("vinaykumar.vvk1998@gmail.com");

			helper.setSubject("Testing from Spring Boot--");

			helper.setText("Check attachment for image!", true);

			helper.addAttachment("Test.png", new FileSystemResource("C:\\Users\\ADMIN\\Pictures\\test\\Test.png"));

			emailSender.send(msg);
			System.out.println("Mail sent");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
