package com.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class VideoDAOImpl implements VideoDAO{
	
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public ArrayList getVideoDetals() {
		String sql = "select * from video v, videotype vt where v.type=vt.type GROUP by v.`type`,v.id ";
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

	@Override
	public ArrayList getVideoTypeDetals() {
		String sql = "select vt.description from video v, videotype vt where v.type=vt.type GROUP by v.`type`";
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
	public  ArrayList pickDataByPrepareStmt(String query,ArrayList paramList,boolean ColumnNameStatus,boolean ColumnDataType) throws Exception
	 {
		  Connection lcon=null; 
		  PreparedStatement prStmt = null;
		    ResultSet lrs=null;
		  ArrayList DataList=new ArrayList();
		  ArrayList tempList = new ArrayList();
		  try
		    {
		      lcon = jdbc.getDataSource().getConnection();
		      prStmt = lcon.prepareStatement(query); 
		      //System.out.println("paramList in DagaAccess : "+paramList);
		      for(int looper=0;looper<paramList.size();looper++)
		      {
		    	    tempList = new ArrayList();
			    	tempList = (ArrayList)paramList.get(looper);
			    	if(tempList.get(0).toString().equalsIgnoreCase("S"))
			    	{
			  	  	  prStmt.setString(looper+1, tempList.get(1).toString().trim());
			    	}
			    	else if(tempList.get(0).toString().equalsIgnoreCase("I"))
			    	{
				  	  	  prStmt.setInt(looper+1, Integer.parseInt(tempList.get(1).toString().trim()));
				    }
		      }
		      //System.out.println("Query:\n"+query);
			  lrs = prStmt.executeQuery();     
			  
		      ResultSetMetaData rsMetaData=lrs.getMetaData();
		      int columnCount=rsMetaData.getColumnCount();
		      if(ColumnDataType)
		      {
			      if(columnCount>1)
			      {
				      ArrayList colList=new ArrayList();
				      for(int i=1;i<=columnCount;i++)
				      {
				        colList.add(rsMetaData.getColumnTypeName(i));
				      }

				      DataList.add(colList);
			      }
			      else
			      {
			    	  DataList.add(rsMetaData.getColumnTypeName(1));
			      }
		      }
		      if(ColumnNameStatus)
		      {
		    	 if(columnCount>1)
		    	 {
				      ArrayList colList=new ArrayList();
				      for(int i=1;i<=columnCount;i++)
				      {
				        colList.add(rsMetaData.getColumnName(i));
				      }
				      DataList.add(colList);
		    	 }
		    	 else
		    	 {
		    		 DataList.add(rsMetaData.getColumnName(1));
		    	 }
		      }
		      while(lrs.next())
		          {
		    	  
				    	  if(columnCount>1)
					    	 {
					              ArrayList alist=new ArrayList();
					              for(int loopCount=1;loopCount<=columnCount;loopCount++)
					              {
					            	//System.out.println("ColumnValue:"+  lrs.getString(loopCount));
					            	
					                if(lrs.getString(loopCount)!=null)                
					                {
					                	//System.out.println("Data in Main :"+lrs.getString(loopCount));
					                
					                         alist.add(lrs.getString(loopCount));
					                      
					                }
					               else
					                {
					                  alist.add("");
					                  //System.out.println("In Varcharcommma");
					                }
					               
					              
					              }      
					              DataList.add(alist);
					    	 }
				    	     else
					    	  {
				    	    	 if(lrs.getString(1)!=null)                
					                {
					                	//System.out.println("Data in Main :"+lrs.getString(loopCount));
					                
				    	    		 DataList.add(lrs.getString(1));
					                      
					                }
					               else
					                {
					            	   DataList.add("");
					                  //System.out.println("In Varcharcommma");
					                }
					    	  }
		           }
		      
		      
//		           if(lrs!=null)
//		           {
//		              lrs.close();
//		              lrs=null;
//		           }
//		           
//		           if(prStmt!=null)
//		           {
//		        	   prStmt.close();
//		           }
//		           
//		           if(lcon!=null)
//		           {
//		                lcon.close();
//		                lcon=null;
//		           }
		           
		      }    
		      catch(SQLException sqle)
		     {
		         throw sqle;
		      }
		     catch(Exception lexp)
		     {
		          throw lexp;
		     }
		     finally
		      {
		    	 
		      }
		      return DataList;
	 }
}
