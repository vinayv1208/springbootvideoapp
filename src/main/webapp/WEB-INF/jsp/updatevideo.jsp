<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
ArrayList categoryList = new ArrayList();


ArrayList details = new ArrayList();
details = (ArrayList)request.getAttribute("details");
details = (ArrayList)details.get(0);
System.out.println("9999999999999999"+details);
%>
<title>Update Video</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LOG Registration Form</title>
	
	<style type="text/css">
		
				body, html{
				 	background-repeat: no-repeat;
				 	background-position: center;
				 	background-size: cover;
				 	background-attachment: fixed;
				 	font-family: 'Oxygen', sans-serif;
				}
				
				.main{
				 	margin-top: 20px;
				}
				
				h1{ 
					font-size: 70px;
					font-family: 'Passion One', cursive; 
					font-weight: 200; 
					text-align: center;
					text-shadow: 0px 3px 0px white;
				}
				i{
					background-color:pink;
					height:27px;
					width:30px;
					text-align: center;
					padding: 5px;
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
					font-size: 19px;
				}
				
				input,
				input::-webkit-input-placeholder {
				    font-size: 11px;
				    padding-top: 3px;
				    line-height: 20px;
				    width:90%;
				    margin-top: 1%;
				}
				.input-group{
					border:1px solid transparent;
					width: 101%;
				}
				.main-login{
				 	background-color: rgba(0,0,0,0.28);
				 	font-weight:bold;
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
				    padding: 10px 40px;
					max-width: 400px;
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
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function ($) 
	{
		try
		{
			$('#regist').click(function(){
				//alert($('#student_id').val());
				if(confirm("Are you sure you want to submit the request?"))
				{
				 document.myForm.target="_self";
				 document.myForm.action="<%=request.getContextPath()%>/videoupdateSubmit";
				 document.myForm.submit();
					/*Screen Locking Started */
				/*Screen Locking Ended */
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
<body>
	<jsp:include page="./header.jsp" />
	<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <h1 class="title">Edit  Video Details</h1>
	            </div> 
				<div class="main-login main-center">
					<div class="panel-title text-center main-center">
	               		<h2 class="title">Edit video </h2>
	               		<hr />
	               	</div>
					<form name="myForm" class="form-horizontal" method="post" name="registrationForm" id="registrationForm" action="registrationSubmit" onsubmit="return validate()">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Name of the movie </label>
							<div class="cols-sm-10">
								<div class="input-group">
										<input type="hidden" name="id" id="id" value="<%=details.get(0) %>" required/>
									<input type="text" name="name" id="name" value="<%=details.get(1) %>" required/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">discription</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<input type="text" name="discription"  id="discription" value="<%=details.get(2) %>" required/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">director</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<input type="text" name="director"  id="director" value="<%=details.get(3) %>" required/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">hero</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<input type="text" name="hero"  id="hero" value="<%=details.get(4) %>" required/>
								</div>
							</div>
						</div>
						
						<div class="form-group ">
							<button id="regist" name="regist" type="submit">
								Update
							</button>
						</div>
					</form>
				</div>
			</div><br><br>
		</div>
</body>
</html>