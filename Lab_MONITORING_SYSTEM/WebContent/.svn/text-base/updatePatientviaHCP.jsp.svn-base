<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HCP::Update Patient</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

   <script>
   
   function ShowHideDiv(chkPassport) {
       var dvPassport = document.getElementById("showing");
       dvPassport.style.display = chkPassport.checked ? "block" : "none";
   }
   
   </script>


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
    

<div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Update Patient Details</h4>
        </div>
        <div class="modal-body">
        <div class="row">
		<div class="col-md-12">
			<div >
				
				<div class="tab-content">
					<div class="tab-pane active" id="panel-patient">
						<p>
		<div class="col-md-12"  align="center">
		<div class="form-group" align="right">
   <form role="form" name="registrationForm" method="post" action="LabControllerServlet">
			
	<table align="center">

	<div id="registration" align="center">
	<% 
	request.setAttribute("pidd", request.getParameter("patientid"));
	%>
					 					
										<input type="hidden" class="form-control"  size="15"  id="patientid" name="patientid" value="<%=request.getParameter("patientid") %>"/>
									
		<div class="form-group" align="left">
					 					<label for="hcpn">
											FIRST NAME:
										</label>
										<input type="text" class="form-control"  size="15"  id="firstname" name="firstname" value="<%=request.getParameter("firstname") %>" required />
									</div>
		<div class="form-group" align="left">
					 					<label for="hcpn">
										LAST NAME:
										</label>
										<input type="text" class="form-control"  size="15"  id="lastname" name="lastname" value="<%=request.getParameter("lastname") %>" required />
									</div>
									<div class="form-group" align="left">
					 					<label for="gender">
											Gender: 
										</label>
											<%
										String gender=request.getParameter("gender");
										if(gender.equals("male"))
										{
										
										%>
										
											<label class="radio-inline"><input type="radio" value="male" name="Gender" checked="checked" id="genderm">Male</label>
											<label class="radio-inline"><input type="radio" value="female" name="Gender" id="genderf">Female</label>
<%

										}
										else
										{

%>
												<label class="radio-inline"><input type="radio" value="male" name="Gender"  id="genderm">Male</label>
											<label class="radio-inline"><input type="radio" value="female" name="Gender"  checked="checked" id="genderf">Female</label>

<%

										}
%>
									</div>

				
		<div class="form-group" align="left">
					 					<label for="hcpn">
										AGE:
										</label>
										<input type="number" min="0" max="200" class="form-control"  size="15"  id="age" name="age"  value="<%=request.getParameter("age") %>"required />
									</div>
				
		<div class="form-group" align="left">
					 					<label for="hcpn">
										ADDRESS:
										</label>
										<textarea type="text" class="form-control"   id="address" name="address"   required ><%= request.getParameter("address")%></textarea>
									</div>
				
		<div class="form-group" align="left">
					 					<label for="hcpn">
										CONTACT:
										</label>
										<input type="number" min="1000000000" max="9999999999" class="form-control" maxlength="10" size="15"  id="contact" name="contact"  required value="<%=request.getParameter("contact") %>"/>
									</div>
		<div class="checkbox" align="left">
 										 <label><input type="checkbox" onclick="ShowHideDiv(this)" name="isInsuranceCover" value="">Insurance Cover</label>
									</div>
									<div class="form-group" align="left" style="display:none" id="showing">
					 					<label for="contact">
											Health Insurance Cover Number:
										</label>
										<input type="text" class="form-control" id="show" name="healthInsuranceNo" size="15" maxlength="10" required value="<%=request.getParameter("healthInsuranceNo") %>"/>
									</div>
									
									<div class="form-group" align="left">
					 					<label for="medicalComplaint">
											Medical Complaint:
										</label>
										<textarea class="form-control" id="medical_complaint" name="medical_complaint" maxlength="100"  required/><%=request.getParameter("medical_complaint") %></textarea>
									</div>

									<div class="form-group" align="left">
					 					<label for="referredDoctor">
											Referred Doctor:
										</label>
										<input type="text" class="form-control" id="referredDoctor" name="referredDoctor" size="15" maxlength="30"   required value="<%=request.getParameter("referredDoctor") %>"/>
									</div>

<input type="hidden" value="finalupdate" name="action"></input>
			
			
					<button class=" btn btn-info" type="submit" name="login" >Update Patient
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




</table>
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

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>