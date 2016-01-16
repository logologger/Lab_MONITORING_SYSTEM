<!DOCTYPE html>
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
    <div class="container-fluid">
	<div class="row">

		<div class="col-md-12">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="#">Hetero Lab Services</a>
				</div>
	
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<div class="navbar-form navbar-right" >
										<form class="navbar-form navbar-left" role="search" method="post" action="Patientcontroller">
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
			<div class="modal-dialog" style="margin-top:10%;
 		align="center";
 		">
<div class="col-md-12" align="center" style="align:center">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Forgot Password</h4>
        </div>
        <div class="modal-body">
        <div class="row">
		<div class="col-md-12" align="center">
			
							<div class="col-md-12" align="center">
								<form role="form" name="ccform" method="post" action="LabControllerServlet"  onsubmit=" return registervalid()">
									<div class="form-group" align="left">
					 					<label for="patientid">
											Patient ID:
										</label>
										<input type="text" class="form-control" id="patient_id"  name="patient_id" size="15" maxlength="30" required />
									</div>
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
									<input type="hidden" value="forget_patient" name="action"/>
									<div class="col-md-6">
									<input type="submit" name="submit" value="Reset My Password" class="btn btn-info"/>
									</div>
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