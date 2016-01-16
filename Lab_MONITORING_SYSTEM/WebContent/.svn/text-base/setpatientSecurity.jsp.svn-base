<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Patient::Set Security</title>

    <meta name="description" content="Online Lab serivces in Hyderabad">
    <meta name="author" content="HYD11/HJA52/Group E">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <%
  String pid=(String)session.getAttribute("pid");
  
  if(pid!=null)
  {
  %>
  <body background="images/bg.png">
  <div id="wrap">
    <div class="container-fluid">
	<div class="row">

		<div class="col-md-12">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="#">Hetero Lab Services</a>
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
						<li><h4><span class="label label-success">Welcome <%=pid %> </span></h4></li>
						<li>
							 <a href="logoutmodal.jsp" class="btn  btn-link btn-lg">
          						<span class="glyphicon glyphicon-log-out"></span> Log out
       						 </a>
        				</li>
						
					</ul>
					
					
				</div>

					

				
			</nav>


<div class="col-md-2 nav " style="margin-top:10%;
 		align="center";
 		">
	<ul class="nav nav-pills nav-stacked">
		<li>
		<form action="Patientpanel.jsp"><input type="submit" class="btn btn-info btn-block"  value="Home"></form>
		</li>
		<li>
		<form action="LabControllerServlet" method="post">
				<input type="submit" value="View Profile" class="btn btn-info btn-block">
				<input type="hidden" value="viewPatient" name="action"></input>
			</form>
		</li>
		<li>
			<form action="LabControllerServlet" method="post">
				<input type="submit" value="Update Profile" class="btn btn-info btn-block">
				<input type="hidden" value="viewPatientupdate" name="action"></input>
			</form>
		</li>
			<li>
				<form action="changepassword.jsp" method="post">
					<input type="submit" value="Change Password" class="btn btn-info btn-block">
				</form>
			</li>
			<li>
		
			<form action="setpatientSecurity.jsp" method="post">
				<input type="submit" value="Set Security Question" class="btn btn-info btn-block">
				
			</form>
		</li>
		<li>
			<form action="deletePatientmodal.jsp" method="post">
				<input type="submit" value="Delete Profile" class="btn btn-info btn-block">
				<input type="hidden" value="deletePatient" name="action"></input>
			</form>
		</li>
		<li>
		<form action="adddependent.jsp" method="post">
				<input type="submit" value="Add Dependent" class="btn btn-info btn-block">
				</form>
			
		</li>
		<li>
			<form action="LabControllerServlet" method="post">
				<input type="submit" value="View Dependent" class="btn btn-info btn-block">
				<input type="hidden" value="ViewDependent" name="action"></input>
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
          <h4 class="modal-title">Set Your Security Question</h4>
        </div>
        <div class="modal-body" align="center">
        <div class="row" align="center">
		<div class="col-md-12" align="center">
			<div>
				
				
					<div >
						<p>
							<div class="col-md-12" align="center">
								<form role="form" name="ccform" method="post" action="LabControllerServlet"  onsubmit=" return registervalid()">
								
									<div class="form-group" align="left">
					 					<label for="securityquestion">
											Security Question:
										</label>
										<select class="form-control" class="select" name="security_question">
										<option value="1">What is your pet name?
										</option>
										<option value="2">What is your Mother's birth place?
										</option>
										<option value="3">
										What is your favorite color?
										</option>
										<option value="4">
										What is your childhood best friend?
										</option>
										<option value="5">
										What is your nick name?
										</option>
									
										</select>
										</div>
										<div class="form-group" align="left">
					 					<label for="securityanswer">
											Security Answer:
										</label>
										<input type="text" class="form-control" id="security_answer"  name="security_answer" size="15" maxlength="30" required />
									</div>
									<input type="hidden" value="setsecurity" name="action"/>
									<input type="submit" name="submit" value="Set My Security Question" class="btn btn-info"/>
									</form>
									</div>
									</div>
									</div></div>
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
  </body>
</html>
<%
  }
  else{
	  response.sendRedirect("error.jsp");
  }
	
	
	%>