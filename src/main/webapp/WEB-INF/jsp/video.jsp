<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Video List</title>
<style>
.a {
  display: block;
  border: 1px solid red;
  background-color: lightgrey;
  padding: 10px;
  width: 350px;
}
.b {
  border: 1px solid blue;
  background-color: lightblue;
  padding: 10px;
}
body{
padding-left: 92px;
}
</style>
<script type="text/javascript">
	$(document).ready(function ($) 
	{
		try
		{
			$('#ugv').hide();
			$('#ugvg').hide();
			$('#uvg').hide();
			$('input[type=radio][name=category]').change(function(){
				
				var categoryValue = $("input[name='category']:checked").val();
				var languageValue = $("input[name='language']:checked").val();
				alert(categoryValue+"category"+languageValue);
				if (categoryValue == 'user' && languageValue == 'video') {
					$('#uv').show();
					$('#ugvg').hide();
					$('#uvg').hide();
					$('#ugv').hide();
			    }
				else if (categoryValue == 'group' && languageValue == 'video') {
					$('#ugv').show();
					$('#uv').hide();
					$('#ugvg').hide();
					$('#uvg').hide();
				}
				else if (categoryValue == 'user' && languageValue == 'group') {
					$('#uv').hide();
					$('#ugvg').hide();
					$('#uvg').show();
					$('#ugv').hide();
			    }
				else if (categoryValue == 'group' && languageValue == 'group') {
					$('#ugv').hide();
					$('#uv').hide();
					$('#ugvg').show();
					$('#uvg').hide();
				}
			});
			$('input[type=radio][name=language]').change(function(){
				
				var categoryValue = $("input[name='category']:checked").val();
				var languageValue = $("input[name='language']:checked").val();
				alert(categoryValue+"category"+languageValue);
				if ( languageValue == 'video' && categoryValue == 'user') {
					$('#uv').show();
					$('#ugv').hide();
					$('#ugvg').hide();
					$('#uvg').hide();
			    }
				else if ( languageValue == 'group' && categoryValue == 'user') {
					$('#uvg').show();
					$('#ugv').hide();
					$('#uv').hide();
					$('#ugvg').hide();
				}
				else if ( languageValue == 'video' && categoryValue == 'group') {
					$('#uv').hide();
					$('#ugv').show();
					$('#ugvg').hide();
					$('#uvg').hide();
			    }
				else if ( languageValue == 'group' && categoryValue == 'group') {
					$('#uvg').hide();
					$('#ugv').hide();
					$('#ugvg').show();
					$('#uv').hide();
				}
			});
		}
		catch(e)
		{
			alert(e);
		}
	});
	

	
	</script>
</head>
<%
ArrayList videoList = new ArrayList();
ArrayList videoTypeList = new ArrayList();
ArrayList categoryList = new ArrayList();


	ArrayList temp = new ArrayList();
	videoList = (ArrayList)request.getAttribute("videoList");
	videoTypeList = (ArrayList)request.getAttribute("videoTypeList");
	categoryList = (ArrayList)request.getAttribute("categoryList");
	//System.out.println(videoList+"\n000000000000000000000000000000"+videoTypeList);
%>

<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav navbar-right">
						<li id="cd"><a href="<%=request.getContextPath()%>"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Home</font></a>
							<a href="./addvideo"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Add Video</font></a>
							<a href="./getVideos"><i class="fa fa-user" id="icn" style="color: #fff;"></i><font color="#fff">Show Videos</font></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container-fluid">
		<table class="table" align="center" > 
			<thead align="center" class="thead-dark">
				<tr align="center">
					<th align="center">User</th>
					<th align="center">Video</th>
				</tr>
			</thead>
			<tr>
				<td>
					<input type="radio" name="category" value="user" checked>user 
		  			<input type="radio" name="category" value="group"> group
				</td>
				<td>
						<input type="radio" name="language" value="video" checked>Video 
		  <input type="radio" name="language" value="group"> group
				</td>
			</tr>
		</table>
		 
		
		<div class="row" id="uv">
			<%if(videoList!=null && videoList.size()>0){ %>
				<h1>All Videos</h1>
				
				<%for(int i=0;i<videoList.size();i++) {
					temp = (ArrayList)videoList.get(i);
				%>
					<div class="col-md-4">
						<div class="a">
							 
								Excellence!
								A movie with a heart touching emotions, great graphics, imposing villain, awesome actions and the main point great storyline; 
								
							<div class="b">
								Movie Name: <label><%= temp.get(1)%></label><br>
								Director: <label><%= temp.get(5)%></label><br>
								Hero: <label><%= temp.get(6)%></label><br>
								Producer: <label><%= temp.get(9)%></label><br>
								Budjet: <label><%= temp.get(8)%></label>$
							</div> 
							<a href="<%=request.getContextPath()%>/getDetails?id=<%=temp.get(0)%>">Update</a>
						</div>
						
					</div>
				<%} %>
				
			<%} %>
		</div>
<br>
<div class="row" id="uvg">
	<%if(videoTypeList!=null && videoTypeList.size()>0 && videoList!=null && videoList.size()>0){ %>
	
		<h1>Language Wise Videos</h1>
		<%for(int x=0;x<videoTypeList.size();x++){ %>
		<div class="row">
		<h2><%=videoTypeList.get(x) %></h2>
		<%for(int i=0;i<videoList.size();i++) {
			temp = (ArrayList)videoList.get(i);
			System.out.println(videoTypeList.get(x).toString()+"\n000000000000000000000000000000"+temp.get(11));
		%>
			<%if((videoTypeList.get(x)).equals(temp.get(12))) {%>
			<div class="col-md-4">
						<div class="a">
							 
								Excellence!
								A movie with a heart touching emotions, great graphics, imposing villain, awesome actions and the main point great storyline; 
								
							<div class="b">
								Movie Name: <label><%= temp.get(1)%></label><br>
								Director: <label><%= temp.get(5)%></label><br>
								Hero: <label><%= temp.get(6)%></label><br>
								Producer: <label><%= temp.get(9)%></label><br>
								Budjet: <label><%= temp.get(8)%></label>$
							</div> 
							<a href="<%=request.getContextPath()%>/getDetails?id=<%=temp.get(0)%>">Update</a>
						</div>
						
					</div>
			<%} %>
			<%} %>
			</div>
		<%} %>
		
	<%} %>
	</div>	
	<br>
<div class="row" id="ugvg">
	<%if(categoryList!=null && categoryList.size()>0 && videoTypeList!=null && videoTypeList.size()>0 && videoList!=null && videoList.size()>0){ %>
	
		<h1>Language And User Category Wise </h1>
		<%for(int x=0;x<videoTypeList.size();x++){ %>
		<div class="row">
		<h2><%=videoTypeList.get(x) %></h2>
		
		<%for(int a=0;a<categoryList.size();a++){ %>
		<div class="row">
		<h2><%=categoryList.get(a) %></h2>
		
		<%for(int i=0;i<videoList.size();i++) {
			temp = (ArrayList)videoList.get(i);
			System.out.println(videoTypeList.get(x).toString()+"\n000000000000000000000000000000"+temp.get(11));
		%>
			<%if( videoTypeList.get(x).equals(temp.get(12)) && categoryList.get(a).equals(temp.get(14))    ) {%>
			<div class="col-md-4">
						<div class="a">
							 
								Excellence!
								A movie with a heart touching emotions, great graphics, imposing villain, awesome actions and the main point great storyline; 
								
							<div class="b">
								Movie Name: <label><%= temp.get(1)%></label><br>
								Director: <label><%= temp.get(5)%></label><br>
								Hero: <label><%= temp.get(6)%></label><br>
								Producer: <label><%= temp.get(9)%></label><br>
								Budjet: <label><%= temp.get(8)%></label>$
							</div> 
							<a href="<%=request.getContextPath()%>/getDetails?id=<%=temp.get(0)%>">Update</a>
						</div>
						
					</div>
			<%} %>
			<%} %>
			</div>
			<%} %>
			</div>
		<%} %>
		
	<%} %>
</div>



<div class="row" id="ugv">
	<%if(categoryList!=null && categoryList.size()>0 && videoTypeList!=null && videoTypeList.size()>0 && videoList!=null && videoList.size()>0){ %>
	
		<h1> User Category Wise </h1>
		
		<%for(int a=0;a<categoryList.size();a++){ %>
		<div class="row">
		<h2><%=categoryList.get(a) %></h2>
		
		<%for(int i=0;i<videoList.size();i++) {
			temp = (ArrayList)videoList.get(i);
		%>
			<%if(  categoryList.get(a).equals(temp.get(14))    ) {%>
			<div class="col-md-4">
						<div class="a">
							 
								Excellence!
								A movie with a heart touching emotions, great graphics, imposing villain, awesome actions and the main point great storyline; 
								
							<div class="b">
								Movie Name: <label><%= temp.get(1)%></label><br>
								Director: <label><%= temp.get(5)%></label><br>
								Hero: <label><%= temp.get(6)%></label><br>
								Producer: <label><%= temp.get(9)%></label><br>
								Budjet: <label><%= temp.get(8)%></label>$
							</div> 
							<a href="<%=request.getContextPath()%>/getDetails?id=<%=temp.get(0)%>">Update</a>
						</div>
						
					</div>
			<%} %>
			<%} %>
			</div>
			<br>
			<%} %>
		<%} %>
		
</div>
</div>

</body>
</html>