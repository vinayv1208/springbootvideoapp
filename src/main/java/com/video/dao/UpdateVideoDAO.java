package com.video.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.video.entity.Video;

public interface UpdateVideoDAO {
	
	public ArrayList getVideoDetails(int id);
	public int updateVideo(HashMap<String,String> newUserData);
	public int updateVideo(Video newUserData);

}
