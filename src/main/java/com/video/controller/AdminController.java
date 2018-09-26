package com.video.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.video.dao.JsonVideo;
import com.video.service.VideoService;

@RestController
public class AdminController {
	
	@Autowired
	VideoService videoSer;
	
	@Autowired
	JsonVideo jsonVideo;
	
	@RequestMapping("getVideos")
	public ModelAndView getVideos() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("videoList", videoSer.getVideoDetals());
		mv.addObject("videoTypeList", videoSer.getVideoTypeDetals());
		mv.addObject("categoryList", videoSer.getCategoryDetals());
		
		mv.setViewName("video");
		
		ArrayList videoList = new ArrayList();
		/*videoList.add("1");
		videoList.add("2");
		videoList.add("3");
		videoList.add("4");*/
		videoList.add(videoSer.getVideoDetals());
		
		//System.out.println(videoList+"\n000000000000000000000000000000"+mv.getViewName()+mv.getStatus());	
		return mv;
	}
	@RequestMapping("getVideosforjson")
	public ArrayList getVideosforjson() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("videoList", videoSer.getVideoDetals());
		mv.addObject("videoTypeList", videoSer.getVideoTypeDetals());
		mv.addObject("categoryList", videoSer.getCategoryDetals());
		
		mv.setViewName("video");
		
		ArrayList videoList = new ArrayList();
		/*videoList.add("1");
		videoList.add("2");
		videoList.add("3");
		videoList.add("4");*/
		videoList.add(videoSer.getVideoDetals());
		
		//System.out.println(videoList+"\n000000000000000000000000000000"+mv.getViewName()+mv.getStatus());	
		
		return videoSer.getVideoDetalsForJson();
	}
	@RequestMapping("/getJsonResponce")
	public String ok() {
		
		jsonVideo.getVideoJson();
		
		return jsonVideo.getVideoJson();
	}
	
}
