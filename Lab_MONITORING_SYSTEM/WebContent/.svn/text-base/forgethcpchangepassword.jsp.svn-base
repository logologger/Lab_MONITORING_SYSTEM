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
<body>


    <div class="container-fluid">
    <div id="wrap">
	<div class="row">

		<div class="col-md-12">
			<nav class="navbar navbar-default " role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="#">Hetero Lab Services</a>
				</div>
	
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						
									<div class="navbar-form navbar-right" >
										<form class="navbar-form navbar-left" role="search" method="post" action="Patientcontroller">
				    <div class="form-group">
				        <input type="text" class="form-control" placeholder="Search a Lab"  name="search" size="30">
				        <input type="hidden" name="action" value="search_form">
				    </div>
				    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
											</form>

					</div>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="register.jsp"><span class="glyphicon glyphicon-user"></span>Register</a>
						</li>
						
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="login.jsp"  ><span class="glyphicon glyphicon-lock"></span>Log In</a>
						</li>
						
					</ul>	
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.jsp"><span class="glyphicon glyphicon-home"></span>Home</a>
						</li>
						
					</ul>
					
					
				</div>

					

				
			</nav>



    <div class="modal-dialog">
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
									<input type="hidden" name="action" value="forgethcpchangepassword"/>
									<input type="hidden" name="ppid" value="<%=request.getAttribute("ppid") %>"/>
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







<div id="footer">
      <div class="container">
        <p class="text-muted credit" style="margin-left:40%;">© HYD11 - HJA52 &#8226; Group E . All Rights Reserved. </p>
      </div>
    </div>


</div>
	<script src="javascript/checkps.js"><</script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>