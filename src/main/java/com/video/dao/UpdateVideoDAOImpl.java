package com.video.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.video.entity.Video;

@Repository
public class UpdateVideoDAOImpl implements UpdateVideoDAO {
	
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public ArrayList getVideoDetails(int id) {
		System.out.println("---------------------");
		String sql = "select id, name, discription, director, hero from video where id="+id;
		//String sql = "SELECT college_id, college_name FROM college_master where state_id="+stateId+" and district_id="+districtId+" and city_id="+cityId;
		List a = new ArrayList();
		List<ArrayList> data = jdbc.query(sql, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		temp.add(rs.getString(i));
            	}
                return temp;
            }
       });
		System.out.println(data);
		return (ArrayList) data;
	
		
	}

	public int updateVideo(HashMap<String, String> newUserData) {
		String SQL = "update video set name=?, discription=?, director=?, hero=? where id = ?";
		int i = jdbc.update(SQL, newUserData.get("name"),newUserData.get("description"),newUserData.get("director"),newUserData.get("hero"),newUserData.get("id"));
	      System.out.println("Updated Record with ID = " + i );
	      
		return i;
	}

	@Override
	public int updateVideo(Video newUserData) {
		String SQL = "update video set name=?, discription=?, director=?, hero=? where id = ?";
		int i = jdbc.update(SQL, newUserData.getName(),newUserData.getDiscription(),newUserData.getDirector(),newUserData.getHero(),newUserData.getId());
	      System.out.println("Updated Record with ID = " + i );
	      
		return i;
	}
}
