package com.zj.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ControllerTest {
	
	
	@Autowired
    private DiscoveryClient client;
	//http://localhost:8080/hello
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String select() {
		
		List<ServiceInstance> instances = client.getInstances("hello-service");
		for (int i = 0; i < instances.size(); i++) {
            System.err.println("Host"+instances.get(i).getHost()+"ServiceId"+instances.get(i).getServiceId());
        }
		return "Hello World!";
	}

}
