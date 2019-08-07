package com.zj.spring_boot.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
	
	@RequestMapping("/select")
	public String select() {
		return "Hello World!";
	}

}
