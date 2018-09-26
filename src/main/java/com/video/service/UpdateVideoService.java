package com.video.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import com.video.dao.UpdateVideoDAOImpl;
import com.video.entity.Video;
import com.video.util.CommonUtility;

@Service
public class UpdateVideoService {
	@Autowired
	UpdateVideoDAOImpl ud;
	public ArrayList getVideoDetails(int id) {
		System.out.println("00000000000000000000");
		return ud.getVideoDetails(id);
		
	}
	public void updateVideoDetails(MultiValueMap<String, String> map) {
		ModelAndView model = new ModelAndView();
		HashMap<String,String> videoData = new HashMap<String,String>(); 
		videoData = CommonUtility.convertMultiToRegularMap(map);
		System.out.println(videoData);
		ud.updateVideo(videoData);
	}
	public void updateVideoDetails(Video map) {
		System.out.println(map);
		ud.updateVideo(map);
	}
}
