package com.video.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.video.dao.VideoDAOImpl;

@Service
public class VideoService {
	@Autowired
	VideoDAOImpl videoDAO;
	public ArrayList getVideoDetals() {
		ArrayList resultList = new ArrayList();
	
		try
		{
			//System.out.println("inside method");
			ArrayList paramList = new ArrayList();
			ArrayList tempList	= new ArrayList();
			
			String	lStrQuery	=  "select * from video v, language l,usertype ut where v.language=l.id and ut.type=v.category GROUP by v.language,v.category,v.id ";
			
		
		  	
			resultList=(ArrayList)videoDAO.pickDataByPrepareStmt(lStrQuery, paramList, false, false);
			//System.out.println("result"+resultList);
			paramList = null;
			tempList  = null;
		}    
		 catch(SQLException sqle)
		 {    
			 System.out.println("SQLException in CommonReportsDAOImpl @ getDistrictList :: Error Code : "+sqle.getErrorCode()+" :: Error Message : "+sqle.getLocalizedMessage());
		 }
		 catch(Exception lexp)
		 {
			 System.out.println("Exception in CommonReportsDAOImpl @ getDistrictList : "+lexp.getLocalizedMessage());
		 }
		System.out.println(resultList.size());
		return resultList;	
	}
	public ArrayList getVideoTypeDetals() {
		ArrayList resultList = new ArrayList();
	
		try
		{
			//System.out.println("inside method");
			ArrayList paramList = new ArrayList();
			ArrayList tempList	= new ArrayList();
			
			String	lStrQuery	=  "select l.description from video v, language l where v.language=l.id GROUP by v.`language`";
			
		
		  	
			resultList=(ArrayList)videoDAO.pickDataByPrepareStmt(lStrQuery, paramList, false, false);
			//System.out.println("result"+resultList);
			paramList = null;
			tempList  = null;
		}    
		 catch(SQLException sqle)
		 {    
			 System.out.println("SQLException in CommonReportsDAOImpl @ getDistrictList :: Error Code : "+sqle.getErrorCode()+" :: Error Message : "+sqle.getLocalizedMessage());
		 }
		 catch(Exception lexp)
		 {
			 System.out.println("Exception in CommonReportsDAOImpl @ getDistrictList : "+lexp.getLocalizedMessage());
		 }
		System.out.println(resultList);
		return resultList;	
	}
	public ArrayList getCategoryDetals() {
		ArrayList resultList = new ArrayList();
	
		try
		{
			//System.out.println("inside method");
			ArrayList paramList = new ArrayList();
			ArrayList tempList	= new ArrayList();
			
			String	lStrQuery	=  "select ut.description from video v, usertype ut where ut.type=v.category GROUP by ut.description";
			
			resultList=(ArrayList)videoDAO.pickDataByPrepareStmt(lStrQuery, paramList, false, false);
			//System.out.println("result"+resultList);
			paramList = null;
			tempList  = null;
		}    
		 catch(SQLException sqle)
		 {    
			 System.out.println("SQLException in CommonReportsDAOImpl @ getDistrictList :: Error Code : "+sqle.getErrorCode()+" :: Error Message : "+sqle.getLocalizedMessage());
		 }
		 catch(Exception lexp)
		 {
			 System.out.println("Exception in CommonReportsDAOImpl @ getDistrictList : "+lexp.getLocalizedMessage());
		 }
		System.out.println(resultList);
		return resultList;	
	}
	public ArrayList getVideoDetalsForJson() {
		ArrayList resultList = new ArrayList();
	
		try
		{
			//System.out.println("inside method");
			ArrayList paramList = new ArrayList();
			ArrayList tempList	= new ArrayList();
			
			String	lStrQuery	=  "select v.id,v.name,v.discription,v.director,v.hero,v.heroin,v.budjet,v.produced_by,v.release_date,l.description as 'language',ut.description as 'category' from video v, language l,usertype ut where v.language=l.id and ut.type=v.category GROUP by v.language,v.category,v.id ";
			
		
		  	
			resultList=(ArrayList)videoDAO.pickDataByPrepareStmt(lStrQuery, paramList, true, true);
			//System.out.println("result"+resultList);
			paramList = null;
			tempList  = null;
		}    
		 catch(SQLException sqle)
		 {    
			 System.out.println("SQLException in CommonReportsDAOImpl @ getDistrictList :: Error Code : "+sqle.getErrorCode()+" :: Error Message : "+sqle.getLocalizedMessage());
		 }
		 catch(Exception lexp)
		 {
			 System.out.println("Exception in CommonReportsDAOImpl @ getDistrictList : "+lexp.getLocalizedMessage());
		 }
		System.out.println(resultList.size());
		return resultList;	
	}
	
	
}
