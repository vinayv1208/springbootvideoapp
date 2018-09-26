package com.video.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("hi")
	public String sayHellow() {
		return "Hi Video";
	}
	

}
