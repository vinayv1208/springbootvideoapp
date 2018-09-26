package com.video.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import com.video.dao.AddVideoDAOImpl;
import com.video.entity.Video;
import com.video.util.CommonUtility;

@Service
public class AddVideoService {
	
	@Autowired
	AddVideoDAOImpl addv;
	
	public void addVideo(MultiValueMap<String, String> map) {
		ModelAndView model = new ModelAndView();
		HashMap<String,String> videoData = new HashMap<String,String>(); 
		videoData = CommonUtility.convertMultiToRegularMap(map);
		System.out.println(videoData);
		addv.addVideo(videoData);
	}
	public void addVideoWithJson(Video map) {
		System.out.println(map);
		addv.addVideo(map);
	}

}
