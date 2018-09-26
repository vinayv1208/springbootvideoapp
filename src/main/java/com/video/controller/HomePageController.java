package com.video.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomePageController {
	
	@RequestMapping("/")
	public ModelAndView homePage()
    {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		//return model;
		//return "redirect:/register";
		return model;
    }

}
