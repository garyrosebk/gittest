package com.example.eurekaclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
@RefreshScope
public class ClientConfiguration {

	@Value("${sample.string.property}")
	private String sampleStringProperty;
	
	@Value("${sample.int.property}")
	private int sampleIntProperty;
	
	public String showPerporties() {
		return String.format("Hello from %s %d", sampleStringProperty, sampleIntProperty);
	}	

}