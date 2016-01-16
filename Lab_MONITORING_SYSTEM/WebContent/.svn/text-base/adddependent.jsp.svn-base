<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Patient::Add Dependent</title>

    <meta name="description" content="Online Lab serivces in Hyderabad">
    <meta name="author" content="HYD11/HJA52/Group E">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
   
<script>
   
   function ShowHideDiv(chkPassport) {
       var dvPassport = document.getElementById("show");
       dvPassport.style.display = chkPassport.checked ? "block" : "none";
   }
   
   </script>
  </head>
   <%
  String pid=(String)session.getAttribute("pid");
 if(pid!=null)
 {
 
  %>
  <body background="images/bg.png">
  <div id="wrap">

    <div class="container-fluid" >
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse navbar-fixed-top " role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="index.html">Hetero Lab Services</a>
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
						<li><h4><span class="label label-success">Welcome <%=pid %></span></h4></li>
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
 		align="center";">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Add Dependent Details</h4>
        </div>
        <div class="modal-body">
        <div class="row">
		<div class="col-md-12">
			<div>
				
				
					<div >
						<p>
							<div class="col-md-12" align="center">
								<form role="form" name="ccform" method="post" action="LabControllerServlet"  onsubmit=" return registervalid()">
									<div class="form-group" align="left">
					 					<label for="firstname">
											First Name:
										</label>
										<input type="text" class="form-control" id="First_name" name="First_name" size="15" maxlength="30" required />
									</div>
									
									<div class="form-group" align="left">
					 					<label for="licensenumber">
											Last Name:
										</label>
										<input type="text" class="form-control" id="Last_name" name="Last_name"  size="15" maxlength="30"  required/>
									</div>
									<div class="form-group" align="left">
					 					<label for="relation">
										Relation: 
										</label>
											<label class="radio-inline"><input required type="radio" value="spouse" name="Relationship" id="Relationship">Spouse</label>
											<label class="radio-inline"><input required type="radio" value="child" name="Relationship" id="Relationship">Child</label>
											<label class="radio-inline"><input required type="radio" value="parent" name="Relationship" id="Relationship">Parent</label>
									</div>

									<div class="form-group" align="left">
					 					<label for="gender">
											Gender: 
										</label>
											<label class="radio-inline"><input required type="radio" value="male" name="Gender" id="genderm">Male</label>
											<label class="radio-inline"><input required type="radio" value="female" name="Gender" id="genderf">Female</label>

									</div>
									
									<div class="form-group" align="left">
					 					<label for="age">
											Age:
										</label>
										<input type="number" min="1" max="200" class="form-control" id="Age"  name="Age"required/>
									</div>

									<div class="form-group" align="left">
					 					<label for="address">
											Address:
										</label>
										<textarea class="form-control" id="Address"  name="Address" maxlength="100" required /></textarea>
									</div>

									<div class="form-group" align="left">
					 					<label for="Phone_number">
											Contact No:
										</label>
										<input type="number" class="form-control" id="Phone_number" min="1000000000" max="9999999999" name="Phone_number" maxlength="10" maxlength="10" required/>
									</div>
									<div class="checkbox" align="left">
 										 <label><input type="checkbox" onclick="ShowHideDiv(this)" value="">Health Insurence Cover</label>
									</div>
									<div class="form-group" align="left" id="show"  style="display:none">
					 					<label for="contact">
											Insurance cover:
										</label>
										<input type="text" VALUE="0" class="form-control" id="Health_number" name="Health_number" size="15" maxlength="10" />
									</div>
									
										<input type="hidden" value="AddDependent" name="action"></input>

									<button type="submit" class="btn btn-info">
										Register as Dependent
									</button>
								</form>
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
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="javascript/register.js"></script>
  </body>
</html>

