package com.microservices.cloud.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.cloud.currencyconversionservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to
			,@PathVariable BigDecimal quantity) {


		Map<String,String> uriVariables= new HashMap<String,String>();
		
		uriVariables.put("from", from);
		uriVariables.put("to",to);
		
		ResponseEntity<CurrencyConversionBean> forEntity = 
				new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean respones=forEntity.getBody();
		/*respones.setQuantity(quantity);
		respones.setTotalCalculatedAmount(totalCalculatedAmount);
		return */
		return new CurrencyConversionBean(respones.getId(),from,to,respones.getConversionMultiplier(),quantity,quantity.multiply(respones.getConversionMultiplier()),respones.getPort());

	}
	
	
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to
			,@PathVariable BigDecimal quantity) {


		CurrencyConversionBean respones=proxy.retrieveExchangeValue(from, to);
		/*respones.setQuantity(quantity);
		respones.setTotalCalculatedAmount(totalCalculatedAmount);
		return */
		return new CurrencyConversionBean(respones.getId(),from,to,respones.getConversionMultiplier(),quantity,quantity.multiply(respones.getConversionMultiplier()),respones.getPort());

	}


}
