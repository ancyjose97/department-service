package com.cts.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope //Will trigger the refresh event for this MessageController spring bean
//that is, will reload the configuration properties from the Config server.
@RestController
public class MessageController {

	@Value("${spring.boot.message}")
	private String message;
	
	@GetMapping("message")
	public String message() {
		
		return message;
	}
}
