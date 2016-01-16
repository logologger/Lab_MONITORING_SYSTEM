<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="javax.servlet.*" %>
    <%@ page import="java.util.ArrayList,bean.Patient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>
<link href="css/search_result.css" rel="stylesheet" />
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HCP::Delete Patient</title>
</head>
<%
  String hcpid=(String)session.getAttribute("hcpid");
  if(hcpid!=null){
	  %>
<body  background="images/bg.png">
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
										<form class="navbar-form navbar-left" role="search" method="post" action="Patientcontroller">
				    <div class="form-group ">
				        <input type="text" class="form-control input-lg" placeholder="Search a Lab"  name="search" size="30">
				        <input type="hidden" name="action" value="search_form">
				    </div>
				    <button type="submit" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-search"></span></button>
											</form>

					</div>
				
					<ul class="nav navbar-nav navbar-right">
							<li><h4><span class="label label-success">Welcome <%=hcpid %></span></h4></li>
						
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

<div class="col-md-10" style="margin-top:10%;
 		align="center";
 		">
 		
 		
<div class="col-md-4 input-group"style="margin:5px">
	<table>
		<form method="post" action="LabControllerServlet">
		<tr>
		<td><input type="text" name="searchdel" class="form-control" placeholder="Patient Id"></td>
		<td><input type="submit" class="btn btn-danger "value="Delete"><input type="hidden" name="action" value="deleteNewPatientviahcp"></td></tr>	
		</form>
	</table>
	</div>

<%
HttpSession se=request.getSession();
		ArrayList<Patient> patientList = (ArrayList<Patient>) se.getAttribute("patientList");
		if (patientList.size() > 0) {
	%>
	<table class="table table-hover table-bordered">
		<tr>
			<th>Patient ID</th>
			<th>First Name</th>
			<th>Last Name
			</th>
			<th>
			Address
			</th>
			<th>Age
			</th>
			<th>
			Contact Number
			</th><th>
			Medical Complaint
			</th>
			<th>
Referred Doctor			</th>

		</tr>
		<%
			for (Patient patient : patientList) {
		%>
		<tr>

			<td><%=patient.getPatientID()%></td>
			<td><%=patient.getFirstName()%></td>
			<td><%=patient.getLastName() %></td>
			<td><%=patient.getAddress() %>
			</td>
			<td>
			<%=patient.getAge() %>
			</td>
			<td>
			<%=patient.getContactNo() %>
			</td>
			<td>
			<%=patient.getMedicalComplaint() %>
			</td>
			<td>
			<%=patient.getReferDoctor() %>
			</td>
			
		</tr>
		<%
			}
		%>
	</table>
	
	
	
</div>
</div>
</div>

<div id="footer">
      <div class="container">
        <p class="text-muted credit" style="margin-left:40%;">© HYD11 - HJA52 &#8226; Group E . All Rights Reserved. </p>
      </div>
    </div>


<%
		} else {
			response.sendRedirect("norecordsmodal.jsp");
			
		}
		
		
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