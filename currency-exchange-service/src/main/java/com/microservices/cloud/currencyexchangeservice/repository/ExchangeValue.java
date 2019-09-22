package com.microservices.cloud.currencyexchangeservice.repository;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	
	private BigDecimal conversionMultiplier;
	
	private int port;
	
	public ExchangeValue() {
		
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiplier, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiplier = conversionMultiplier;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getConversionMultiplier() {
		return conversionMultiplier;
	}

	public void setConversionMultiplier(BigDecimal conversionMultiplier) {
		this.conversionMultiplier = conversionMultiplier;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	

}
