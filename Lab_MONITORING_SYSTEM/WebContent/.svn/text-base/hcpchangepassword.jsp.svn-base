<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>
<%
  String hcpid=(String)session.getAttribute("hcpid");
  if(hcpid!=null){
	  %>
<body background="images/bg.png">
<div id="wrap">
    <div class="container-fluid" >
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="hcpPanel.jsp">Hetero Lab Services</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<div class="navbar-form navbar-center" >
										<form class="navbar-form navbar-left" role="search" method="post" action="LabControllerServlet">
				    <div class="form-group ">
				        <input type="text" class="form-control input-lg" placeholder="Search a Lab"  name="search" size="30">
				        <input type="hidden" name="action" value="search_form">
				    </div>
				    <button type="submit" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-search"></span></button>
											</form>

					</div>
				
					<ul class="nav navbar-nav navbar-right">
						<li><h4><span class="label label-success">Welcome <%=hcpid %> </span></h4></li>
						<li>
							 <a href="logoutmodal.jsp" class="btn  btn-link btn-lg">
          						<span class="glyphicon glyphicon-log-out"></span> Log out
       						 </a>
        				</li>
					</ul>
					
						
					


					
					
				</div>
			</nav>

     	</div>

    </div>


<div class="col-md-12">
<div class="col-md-2 nav " style="margin-top:10%;
 		align="center";
 		">
	<ul class="nav nav-pills nav-stacked">
		<li>
		<form action="hcpPanel.jsp"><input type="submit" class="btn btn-info btn-block"  value="Home"></form>
		</li>
		<li>
		<form action="LabControllerServlet" method="post">
				<input type="submit" value="View Profile" class="btn btn-info btn-block">
				<input type="hidden" value="view_hcp" name="action"></input>
			</form>
		</li>
		<li>
			<form action="LabControllerServlet" method="post">
				<input type="submit" value="Update Profile" class="btn btn-info btn-block">
				<input type="hidden" value="UpdatehcpProfile" name="action"></input>
			</form>
		</li>
			<li>
				<form action="hcpchangepassword.jsp" method="post">
					<input type="submit" value="Change Password" class="btn btn-info btn-block">
				</form>
			</li>
			<li>
		
			<form action="setHCPSecurity.jsp" method="post">
				<input type="submit" value="Set Security Question" class="btn btn-info btn-block">
				
			</form>
		</li>
		<li>
		<form action="addpatientviahcp.jsp" method="post">
				<input type="submit" value="Add Patient" class="btn btn-info btn-block">
				</form>
			
		</li>
		<li>
			<form action="LabControllerServlet" method="post">
				<input type="submit" value="Update Patient Profile" class="btn btn-info btn-block">
				<input type="hidden" value="UpdatePatientProfile" name="action"></input>
			</form>
		</li>
		<li>
			<form action="LabControllerServlet" method="post">
				<input type="submit" value="Delete Patient Profile" class="btn btn-info btn-block">
				<input type="hidden" value="deletePatientviahcp" name="action"></input>
			</form>
		</li>
	
	</ul>	
		
		



</div>


 
   
  <div class="modal-dialog" style="margin-top:10%;
 		align="center";
 		">
    
<div class="col-md-12" align="center" style="align:center">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Change Password</h4>
        </div>
        <div class="modal-body">
        <div class="row">
		<div class="col-md-12">
			<div>
				
				
					<div >
						<p>
							<div class="col-md-12" align="center">
								<form role="form" name="ccform" method="post" action="LabControllerServlet"  onsubmit="return check()">
									<div class="form-group" align="left">
					 					<label for="old_password">
											Old Password:
										</label>
										<input type="password" class="form-control" id="old_password" name="old_password" size="15" maxlength="30" required />
									</div>
									<div class="form-group" align="left">
					 					<label for="old_password">
											New Password:
										</label>
										<input type="password" class="form-control" id="new_password" name="new_password" size="15" maxlength="30" required />
									</div>
									<div class="form-group" align="left">
					 					<label for="old_password">
											Re-type New  Password:
										</label>
										<input type="password" class="form-control" id="re_new_password" name="re_new_password" size="15" maxlength="30" required />
									</div>
									<input type="hidden" name="action" value="changepasswordviahcp"/>
									<input type="submit"   value="Change Password" class="btn btn-info"/> 
									</form>
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


	<% 
	
 } 
 else{
	 response.sendRedirect("error.jsp");
 }
	
	%>
	<script src="javascript/checkps.js"><</script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>