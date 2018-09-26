<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		
				body, html{
				     height: 100%;
				 	background-repeat: no-repeat;
				 	background-color: #d3d3d3;
				 	font-family: 'Oxygen', sans-serif;
				}
				
				.main{
				 	margin-top: 70px;
				}
				
				h1.title { 
					font-size: 50px;
					font-family: 'Passion One', cursive; 
					font-weight: 400; 
				}
				#reg{
					text-align:center;
					border:1px solid black;
					width:30.6%;
					margin-left:34.6%;
				}
				i{
					background-color:pink;
					height:20px;
					width:20px;
					text-align: center;
					padding: 5px;
				}
				#stateDivId,#districtDivId,#cityDivId,#collegeDivId{
					float: right;
					margin-right:0%;
					width:90%;
				}
				hr{
					width: 10%;
					color: #fff;
				}
				
				.form-group{
					margin-bottom: 15px;
				}
				
				label{
					margin-bottom: 15px;
				}
				#isfinalyear{
					width:50px;
					line-height: 20px;
				}
				input,
				input::-webkit-input-placeholder {
				    font-size: 11px;
				    padding-top: 3px;
				    line-height: 20px;
				    width:88%;
				}
				
				.main-login{
				 	background-color: #fff;
				    /* shadows and rounded borders */
				    -moz-border-radius: 2px;
				    -webkit-border-radius: 2px;
				    border-radius: 2px;
				    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
				    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
				    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
				
				}
				
				.main-center{
				 	margin-top: 30px;
				 	margin: 0 auto;
				 	max-width: 330px;
				    padding: 40px 40px;
				
				}
				
				.login-button{
					margin-top: 5px;
				}
				
				.login-register{
					font-size: 11px;
					text-align: center;
				}
				
				nav{
					width: 100%;
					height: 65px;
					position: relative;
					background: #0a4b33;
					box-shadow: 0px 2px 8px 0px #333;
				}
				.nav-container{
					width: 1000px;
					margin: 0 auto;
					position: relative;
				}
				#icn{
					background-color: transparent;
					margin-right: 5px;
				}
				#ab{
					font-family: sans-serif,Arial;
					font-size: 16px;
					font-weight: bold;
					letter-spacing: -0.05em;
					position: relative;
					line-height: 65px;
				}
				#cd{
					font-family: sans-serif,Arial;
					font-size: 16px;
					font-weight: bold;
					letter-spacing: -0.05em;
					position: relative;
					line-height: 65px;
				}
		
		
		
		</style>
		
</head>
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

</body>
</html>