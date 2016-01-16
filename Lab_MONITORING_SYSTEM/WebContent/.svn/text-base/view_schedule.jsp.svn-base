<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,bean.View_Schedule;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule for the Labs test</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    

<body background="images/bg.png">
<div id="wrap">
<div class="container-fluid">
	<%
String hcpatid=(String)session.getAttribute("hcpid");
String patid=(String)session.getAttribute("pid");



%>
<div class="container-fluid">
<% 
if(hcpatid!=null || patid!=null)
{
%>
<div class="row">
		<div class="col-md-12">
			<nav class="navbar-inverse navbar-fixed-top  " role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="login.jsp">Hetero Lab Services</a>
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
						<li><h4><span class="label label-success">Welcome <%
						
						if(patid!=null)
						{
							out.print(patid);
						}
						else
						{
							
					
						out.print(hcpatid);
						}
						%> </span></h4></li>
						<li>
							 <a href="logoutmodal.jsp" class="btn  btn-link btn-lg">
          						<span class="glyphicon glyphicon-log-out"></span> Log out
       						 </a>
        				</li>
					</ul>
					

					
					
				</div>
			</nav>

     	</div>
     	
     		<br>
			<br>
			
			<br>
			<br>
			
			<br>
			<br>
			<br>
     	
<% 

}
else
{
	
%>

<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse navbar-fixed-top " role="navigation">
				<div class="navbar-header">
					 <a class="navbar-brand" href="login.jsp">Hetero Lab Services</a>
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
			
			<br>
			<br>
			
			<br>
			<br>
			
			<br>
			<br>
			<br>
			
<%

}
ArrayList<View_Schedule> v=(ArrayList<View_Schedule>)request.getAttribute("vs");
		if(v.size()==0)
		{
			%>
			<div class="page-header">
        <h1>Sorry No Labs  Exist !</h1>
    </div>
			<% 
		}
		else
		{
%>
<div  class="container">
<div class="page-header">
        <h3>Schedule for the Selected Lab is...</h3>
    </div>
<table  class="table table-hover table-bordered">
  <thead>
      <tr>
        <th>Test Name</th>
        <th>City</th>
        <th>Lab Service Provider Name</th>
        <th>Schedule date</th>
        <th>Schedule duration</th>
      </tr>
    </thead>
    <tbody>
<%
String name="sdfsd";
String city="asdfsd";
String lab_Service_provider_name="sdfsdf";
for(View_Schedule vs:v)
{
	%>
	<tr>
	<td>
	
	
	<%
	if(name.equals(vs.getTest_name()))
	{
		
	}
	else
	{
		out.print(vs.getTest_name());
	}
	
	%>
	<%
	
	
	name=vs.getTest_name();
	%>
	<% 
	%>
	</td>
	<td>
	<%
	if(city.equals(vs.getCity()))
	{
		
	}
	else
	{
		%> <% out.print(vs.getCity());%></h3>
		<%
	}
	
	%>
	<%
	
	
	city=vs.getCity();
	%>
	</td>
	<td >
	<%
	if(lab_Service_provider_name.equals(vs.getLab_service_provider_name()))
	{
		
	}
	else
	{
		%> <% out.print(vs.getLab_service_provider_name());%>
		<%
	}
	
	%>
	<%
	
	
	lab_Service_provider_name=vs.getLab_service_provider_name();
	%>
	</td>
	<td>
	
	<%
	out.print(vs.getSchedule_date());
	%>
	</td>
	<td>
	<%
	out.print(vs.getSchedule_duration());
	%>
	</td>
	<% 
}
		}
%>
</tr>
</tbody>
</table>
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


</body>
<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</html>