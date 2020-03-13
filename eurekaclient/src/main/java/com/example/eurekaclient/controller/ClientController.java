package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eurekaclient.config.ClientConfiguration;

@RestController
public class ClientController {

	@Autowired
	private ClientConfiguration conf;
	
	@GetMapping("/ping")
	public String ping() {	
		return conf.showPerporties();
	}
	
}
