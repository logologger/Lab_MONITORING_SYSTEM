<!DOCTYPE html>
<%@page import="javax.servlet.*" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Hetero Lab Services</title>

    <meta name="description" content="Online Lab serivces in Hyderabad">
    <meta name="author" content="HYD11/HJA52/Group E">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body background="images/bg.png">
  <div id="wrap">
	
    <div class="container-fluid" >
    <%
    
    String hcpid=(String)request.getAttribute("hcpid");
    String seshcpid=(String)session.getAttribute("hcpid");
    String password=(String)request.getAttribute("password");
    System.out.println("hcp id is "+hcpid+"password is"+password);
    if(hcpid!=null && password!=null )
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
          <p><%  out.print("<b>HCP ID: </b>"+hcpid); %></p>
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
    	//show him error message
    }
    else if(hcpid==null && password==null&&seshcpid!=null){
    	
    	response.sendRedirect("hcpPanel.jsp");
    }
    else
    {
    	System.out.println("He must have another situation in hcp");
    	
    	
    	
    }
    %>
	
    <%
    
    String pid=(String)request.getAttribute("pid");
    String sespid=(String)session.getAttribute("pid");
    String pass=(String)request.getAttribute("password");
    System.out.println("Patient Id is "+pid+"password is"+pass);
    if(pid!=null && pass!=null )
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
    	//show him error message
    }
    else if(pid==null && pass==null &&sespid!=null ){
    	response.sendRedirect("Patientpanel.jsp");
    }
    else
    {
    	System.out.println("Patient Panel another situation");
    	
    
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

  
 <div class="modal-dialog" 
 style="margin-top:10%;
 		align="center";
 		">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Log In</h4>
        </div>
        <div class="modal-body">
        <div class="row">
		<div class="col-md-12">
			<div class="tabbable" id="tabs-815170">
				<ul class="nav nav-tabs">
					<li class="active col-md-6">
						<a href="#panel-441649" data-toggle="tab">Patient</a>
					</li>
					<li class="col-md-6">
						<a href="#panel-905695" data-toggle="tab">HCP</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-441649">
						<p>
		<div class="col-md-6"  align="center">
			<form role="form" action="LabControllerServlet" method="post">
				<div class="form-group" align="left">
					 
					<label for="exampleInputEmail1">
						Patient Id/ Contact No
					</label>
					<input type="text" class="form-control" id="pid" name="pid"  required/>
				</div>
				<div class="form-group" align="left">
					 
					<label for="exampleInputPassword1">
						Password
					</label>
					<input type="password" class="form-control" id="password" name="password" required/>
					<input type="hidden" name="action" value="login_patient"/>
				</div>
				<div class="col-md-6">
				<button type="submit" class="btn btn-default">
					Log In as Patient
				</button>
				
			</div>
			<div class="col-md-6">
				<a  href="forgetpassword.jsp" class="btn btn-link">
					Forgot password?
				</a>
			</div>
			</form>
		</div>
		
	    
			
			
			
			
			
		<div class="col-md-6" align="center">

			<img src="images/user.png" class="img-rounded" alt="hcp login" width="200" height="180">


		</div>
						</p>
					</div>
					<div class="tab-pane " id="panel-905695">
						<p>
							<div class="col-md-6" align="center">
								<form role="form" method="post" action="LabControllerServlet">
									<div class="form-group" align="left">
					 					<label for="login">
											HCP Id
										</label>
										<input type="text" class="form-control"  id="login" name="login" required />
									</div>
									<div class="form-group" align="left">
					 					<label for="password">
										Password
										</label>
										<input type="password" class="form-control" id="password" name="password" required/>
									</div>
									<input type="hidden" name="action" value="login_hcp"/>
									<div class="col-md-6">
									<button type="submit" class="btn btn-default">
										Log in as HCP
									</button>
									</div>
									<div class="col-md-6">
				<a  href="forgethcppassword.jsp" class="btn btn-link">
					Forgot password?
				</a>
			</div>
								</form>
							</div>
							<div class="col-md-6" align="center">

			<img src="images/hcp.png" class="img-rounded" alt="hcp login" width="200" height="180">


		</div>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
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
