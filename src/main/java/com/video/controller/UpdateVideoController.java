package com.video.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.video.entity.Video;
import com.video.service.UpdateVideoService;

@RestController
public class UpdateVideoController {
	@Autowired
	UpdateVideoService us;
	@RequestMapping(value = "/getDetails")
	public ModelAndView getVideoDetails(@RequestParam("id") int id) {
		System.out.println("----------"+id);
		ModelAndView model = new ModelAndView();
		model.setViewName("updatevideo");
		model.addObject("details", us.getVideoDetails(id));
		return model;
	}
	
	@RequestMapping("/videoupdateSubmit")
	public ModelAndView registrationSubmit(@RequestBody MultiValueMap<String, String> map, HttpServletRequest req)
    {
		ModelAndView model = new ModelAndView();
		try {
			us.updateVideoDetails(map);
			model.setViewName("success");
			model.addObject("successMSG", "Video updated successfully");
		}
		catch(Exception e) {
			model.setViewName("error");
			model.addObject("errorMSG", "Video not updated!!!"+e);
			System.out.println(e);
		}
		 return model;
    }
    @RequestMapping(value = "/videoUpdateJson", method = RequestMethod.POST)
	public String registrationSubmit(@RequestBody Video video)
    {
		try {
			us.updateVideoDetails(video);
		}
		catch(Exception e) {
			System.out.println(e);
			return "fail";
		}
		 return "success";
    }

}
