package com.video.dao;

import java.util.HashMap;

import com.video.entity.Video;

public interface AddVideoDAO {
	
	public int addVideo(HashMap<String,String> newUserData);
	public int addVideo(Video newUserData);

}
