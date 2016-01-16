<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LSP login</title>

    <meta name="description" content="Online Lab serivces in Hyderabad">
    <meta name="author" content="HYD11/HJA52/Group E">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
<%


String pid=(String)request.getAttribute("username");
String password=(String)request.getAttribute("password");


if(pid!=null  && password !=null)
{
%>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Please Note Your Login Credentials</h4>
        </div>
        <div class="modal-body">
          <p><%  out.print("<b>LogIn ID: </b>"+pid); %></p>
          <p>
          <%  out.print("<b>Password:</b> "+(String)request.getAttribute("password")); %>
          </p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  <%
  
}
  
  %>
  <div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse navbar-fixed-top " role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="index.jsp">Hetero Lab Services</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<div class="navbar-form navbar-right" >
										<form class="navbar-form navbar-left" role="search" method="post" action="LabControllerServlet">
				    <div class="form-group">
				        <input type="text" class="form-control input-lg" placeholder="Search a Lab"  name="search" size="30">
				        <input type="hidden" name="action" value="search_form">
				    </div>
				    <button type="submit" class="btn btn-default input-lg"><span class="glyphicon glyphicon-search"></span></button>
											</form>

					</div>
				
					<ul class="nav navbar-nav navbar-right">
						
						
						<li>
							<a href="index.jsp"><span class="glyphicon glyphicon-home input-lg" ></span>Home</a>
						</li>
						<li>
							<a href="login.jsp" ><span class="glyphicon glyphicon-lock input-lg"></span>Log in</a>
						</li>
						<li>
							<a href="register.jsp" ><span class="glyphicon glyphicon-user input-lg"></span>Register</a>
						</li>
							
						
					</ul>
					
					
				</div>
				
			</nav>
			
			</div>
			</div>
			
			
				
				 <div class="modal-dialog" 
 style="margin-top:10%;
 		align="center";
 		">
			 <div class="modal-content" >
        <div class="modal-header">
          <h4 class="modal-title">Log In</h4>
        </div>
        <div class="modal-body">
        <div class="row">
		<div class="col-md-12">
		<div class="col-md-6"  align="center">
			<form role="form" action="LabControllerServlet" method="post">
				<div class="form-group" align="left">
					 
					<label for="exampleInputEmail1">
						LSP ID
					</label>
					<input type="text" class="form-control" id="pid" name="pid"  required/>
				</div>
				<div class="form-group" align="left">
					 
					<label for="exampleInputPassword1">
						Password
					</label>
					<input type="password" class="form-control" id="password" name="password" required/>
					<input type="hidden" name="action" value="login_lsp"/>
				</div>
				<div class="col-md-6">
				<button type="submit" class="btn btn-default">
					Log In 
				</button>
				
			</div>
		
			</form>
		</div>
  </div>
  </div>
  </div>
  </div>
  </div>
  </div>
  
  
  	<div id="footer">
      <div class="container">
        <p class="text-muted credit" style="margin-left:40%;">© HYD11 - HJA52 &#8226; Group E . All Rights Reserved. </p>
      </div>
    </div>



    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script>
$(window).load(function(){
    $('#myModal').modal('show');
});
</script>
</body>
</html>