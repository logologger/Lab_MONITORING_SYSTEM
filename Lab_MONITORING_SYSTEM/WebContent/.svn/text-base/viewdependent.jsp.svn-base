<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,bean.Dependent"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    

  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient::View Dependent</title>
</head>
 <%
  String pid=(String)session.getAttribute("pid");
  
  if(pid!=null)
  {
  %>
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

	<%
		ArrayList<Dependent> DList = (ArrayList<Dependent>) request.getAttribute("alist");
		if (DList.size() > 0) 
		{
	%>
	<div class="col-md-10" style="margin-top:10%;
 		align="center";
 		">
	<table class="table table-hover table-bordered">
		<tr>
			<th>Dependent Id</th>
			<th>First Name</th>
			<th>last Name</th>
			<th>Gender</th>
			<th>Relation</th>
			<th>Age </th>
			<th>Address</th>
			<th>Contact Number</th>
			<th>Health Insurance Number</th>
			<th>Update</th>
		</tr>
		<%
			for (Dependent d : DList) 
			{
		%>
		<tr>
			<td><%=d.getDep_id()%></td>
			<td><%=d.getFirst_name()%></td>
			<td><%=d.getLast_name()%></td>
			<td><%=d.getGender()%></td>
			<td><%=d.getRelationship()%></td>
			<td><%=d.getAge()%></td>
			<td><%=d.getAddress()%></td>
			<td><%=d.getPhone_number()%></td>
			<td><%=d.getHealth_number()%></td>
			
			<td><a href="updatedependent.jsp?dept_id=<%=d.getDep_id()%> &first_name=<%= d.getFirst_name() %> &last_name=<%=d.getLast_name()%>&age=<%=d.getAge()%>&address=<%=d.getAddress()%>&health_number=<%=d.getHealth_number()%>&contact=<%=d.getPhone_number() %>&gender=<%=d.getGender()%>&relation=<%=d.getRelationship()%>">Update</a></td>
		</tr>
		<%
			}
		}
		else {
			response.sendRedirect("patientnorecordsmodal.jsp");
		}
		%>
	</table>
	<%
		} 
  else{
	  response.sendRedirect("login_error.jsp");
  }
		
		
	%>



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





</body>


 <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</html>