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
   <script>
   
   function ShowHideDiv(chkPassport) {
       var dvPassport = document.getElementById("showing");
       dvPassport.style.display = chkPassport.checked ? "block" : "none";
   }
   
   </script>

  </head>
  <body  background="images/bg.png">
<div id="wrap">
    <div class="container-fluid" >
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="index.html">Hetero Lab Services</a>
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
 		align="center";">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">LSP Register</h4>
        </div>
        <div class="modal-body">
        <div class="row">
		<div class="col-md-12">
			
		<div class="col-md-12"  align="center">
			<form role="form" name="lspform" method="post" action="LabControllerServlet"  >
									<div class="form-group" align="left">
					 					<label for="firstname">
											LSP Name:
										</label>
										<input type="text" class="form-control" id="lspname" name="lspname" size="15" maxlength="30" required />
									</div>
																		


									

									<div class="form-group" align="left">
					 					<label for="address">
											Address:
										</label>
										<textarea class="form-control" id="address"  name="lspaddress" maxlength="100" required /></textarea>
									</div>

									<div class="form-group" align="left">
					 					<label for="contact">
											Contact No:
										</label>
										<input type="number" class="form-control" id="lspcontact" min="1000000000" min="9999999999" name="lspcontact" size="10" maxlength="10" required/>
									</div>
									
									
														<div class="form-group" align="left">
					 					<label for="contact">
											Email ID:
										</label>
										<input type="email" class="form-control" id="lspemail"  name="lspemail"  required/>
									</div>
									
									

									<input type="hidden" value="lspregister" name="action"></input>

									<button type="submit" class="btn btn-info">
										Register as LSP
									</button>
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




    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="javascript/register.js"></script>
  </body>
</html>

