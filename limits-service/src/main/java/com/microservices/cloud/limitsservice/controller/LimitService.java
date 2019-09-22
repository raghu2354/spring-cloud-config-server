package com.microservices.cloud.limitsservice.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

public class LimitService {

	private Integer maximum;
	private Integer minimum;
	
	
	public LimitService() {
	}
	public LimitService(Integer maximum, Integer minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}
	public Integer getMaximum() {
		return maximum;
	}
	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}
	public Integer getMinimum() {
		return minimum;
	}
	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}
	
	
}
