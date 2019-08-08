package com.zj.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class ControllerTest {
	
	@Autowired
	RestTemplate restTemplate;
	//http://localhost:9000/ribbon-consumer
	@RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
	public String helloTest() {
		int i=0;
		while(true) {
			i++;
			String body = restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
			System.out.println(body);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>10) {
				break;
			}
		}
		return "hello";
	}

}
