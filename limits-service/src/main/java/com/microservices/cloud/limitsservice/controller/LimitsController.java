package com.microservices.cloud.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

	@Autowired
	public Configure configure;
	@GetMapping("/limits")
	public LimitService limits() {
		return new LimitService(configure.getMaximum(), configure.getMinimum());
	}
}
