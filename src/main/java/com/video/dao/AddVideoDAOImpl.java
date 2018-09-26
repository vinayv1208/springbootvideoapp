package com.video.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.video.entity.Video;


@Component
public class AddVideoDAOImpl implements AddVideoDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate ;

	@Override
	public int addVideo(HashMap<String, String> newUserData) {
        String sql = "INSERT INTO video \n" + 
        		"(id, name, language, category, discription, director, hero, heroin, produced_by,budjet) \n" + 
        		"select max(id)+1 ,?,?, ?, ?, ?, ?, ?, ?, ? from video";
        
        System.out.println(jdbcTemplate);
        
         int result = 0;
         result = jdbcTemplate.update(sql,
        		 newUserData.get("name"),
        		 newUserData.get("language"),
        		 newUserData.get("category"),
        		 newUserData.get("discription"),
        		 newUserData.get("director"),
        		 newUserData.get("hero"),
        		 newUserData.get("heroin"),
        		 newUserData.get("produced_by"),
        		 newUserData.get("budjet"));
         
        return result;
    }

	@Override
	public int addVideo(Video newUserData) {
        String sql = "INSERT INTO video \n" + 
        		"(id, name, language, category, discription, director, hero, heroin, produced_by,budjet) \n" + 
        		"select max(id)+1 ,?,?, ?, ?, ?, ?, ?, ?, ? from video";
        
        System.out.println(jdbcTemplate);
        
         int result = 0;
         result = jdbcTemplate.update(sql,
        		 newUserData.getName(),
        		 newUserData.getLanguage(),
        		 newUserData.getCategory(),
        		 newUserData.getDiscription(),
        		 newUserData.getDirector(),
        		 newUserData.getHero(),
        		 newUserData.getHeroin(),
        		 newUserData.getProduced_by(),
        		 newUserData.getBudjet());
         
        return result;
    }

}
