package com.video.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.video.entity.Video;


@Repository
public class JsonVideo {
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	public String getVideoJson() {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		JSONObject jObj = new JSONObject();
		try {

			con  = jdbc.getDataSource().getConnection();
			String qry = "select v.id,v.name,v.discription,v.director,v.hero,v.heroin,v.budjet,v.produced_by,v.release_date,l.description as 'language',ut.description as 'category' from video v, language l,usertype ut where v.language=l.id and ut.type=v.category GROUP by v.language,v.category,v.id";
			st = con.createStatement();
			rs = st.executeQuery(qry);

			
			ArrayList<Video> list=new ArrayList<Video>();
			Map<String, String> map=new HashMap<String, String>();
			Video sPojo=null;
			while (rs.next()) {
			sPojo=new Video();
			
			
			/*
			 * {
		  "id": "1",
		  "name": "The Dark Knight",
		  "discription": "After Gordon, Dent  organised ",
		  "director": "Christopher Nolan",
		  "hero": "Joker",
		  "heroin": "NA",
		  "budjet": "100",
		  "produced_by": "DC Comics",
		  "release_date": "20-10-2016",
		  "language": "English",
		  "category": "premium"
		}
			 */
			
			sPojo.setId(rs.getInt("id"));
			sPojo.setName(rs.getString("name"));
			sPojo.setDiscription(rs.getString("discription"));
			sPojo.setDirector(rs.getString("director"));
			sPojo.setHero(rs.getString("hero"));
			sPojo.setHeroin(rs.getString("heroin"));
			sPojo.setBudjet(rs.getInt("budjet"));
			sPojo.setProduced_by(rs.getString("produced_by"));
			sPojo.setRelease_date(rs.getString("release_date"));
			sPojo.setLanguage(rs.getString("language"));
			sPojo.setCategory(rs.getString("category"));

			
			list.add(sPojo);

			}
			//System.out.println(list);

			jObj.put("videodetails",list);

			System.out.println(jObj.toString());
			

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return jObj.toString();

	}
		
}
