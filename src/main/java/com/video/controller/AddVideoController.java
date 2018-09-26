package com.video.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.video.entity.Video;
import com.video.service.AddVideoService;

@RestController
public class AddVideoController {
	@Autowired
	AddVideoService advs;
	
	@RequestMapping("/addvideo")
	public ModelAndView showRegistrationPage()
    {
		ModelAndView model = new ModelAndView();
		model.setViewName("addvideo");
		return model;
    }
	@RequestMapping("/videoaddSubmit")
	public ModelAndView registrationSubmit(@RequestBody MultiValueMap<String, String> map, HttpServletRequest req)
    {
		ModelAndView model = new ModelAndView();
		try {
			advs.addVideo(map);
			model.setViewName("success");
			model.addObject("successMSG", "Video added successfully");
		}
		catch(Exception e) {
			model.setViewName("error");
			model.addObject("errorMSG", "Video not added!!!"+e);
			System.out.println(e);
		}
		 return model;
    }
	@RequestMapping(value="/videoaddjson", method = RequestMethod.POST)
	public String registrationSubmit(@RequestBody Video video)
    {
		ModelAndView model = new ModelAndView();
		try {
			System.out.println("video------------------------------"+video.getCategory());
			advs.addVideoWithJson(video);
		}
		catch(Exception e) {
			model.setViewName("error");
			model.addObject("errorMSG", "Video not added!!!"+e);
			System.out.println(e);
			return "fail";
		}
		 return "success";
    }
	

}
