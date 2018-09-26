package com.video.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
@ComponentScan("com.video")
@ComponentScan(basePackages = "com.video")
public class VideoApplication{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = SpringApplication.run(VideoApplication.class, args);
	}
    @Autowired
    JdbcTemplate jdbcTemplate;
	
}