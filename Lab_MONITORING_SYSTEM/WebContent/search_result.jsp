<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    <%@page import="bean.Search_bean,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search results</title>
</head>
<body background="images/bg.png">
<div id="wrap">

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
						else if(hcpatid!=null)
						{
							
						
						out.print(hcpatid);
						}
						
						%> !!</span></h4></li>
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
			HttpSession sp=request.getSession();
			String hcpid=(String)sp.getAttribute("hcpid");
			if(hcpid!=null)
			{
			%>
			<form action="LabControllerServlet" method="post"/>
	
	<input type="hidden" name="action" value="sort_results"/>
	<input type="submit" class="btn btn-info" value="Sort the Test based on the Cost">
	</form>	
	
<%
			}
ArrayList<Search_bean> arsearch=new ArrayList<Search_bean>();
arsearch=(ArrayList<Search_bean>)request.getAttribute("arsearch");
if(arsearch.size()==0)
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
<div class="container">
<table class="table table-hover table-bordered">
<thead>
<tr>
<th>
Lab Service Provider Name
</th>
<th>
Address
</th>
<th>
State
</th>
<th>
City
</th>

<th>
Test Name
</th>
<th>
Test code
</th>
<th>
Test Description
</th>
<th>
Cost
</th>
<th>
Lab OR Home
</th>

</tr>
</thead>

<tbody>



<% 


if(arsearch.size()!=0)
{
%>

<%
for(Search_bean s:arsearch)
{
	%>
	<tr>
<td>
<% 
	out.print(s.getLab_service_provider_name());
	%>
	</td>
	<td>
	<% 
	out.print(s.getAddress());
	%>
	</td>
	<td>
	<% 
	out.print(s.getState());
	%>
	</td>
	<td>
	<%  
	out.print(s.getCity());
	%>
	</td>
	<td>
	<% 
	out.print(s.getTest_name());
	%>
	</td>
	<td>
	<% 
	out.print(s.getTest_code());
	%>
	</td>
	<td>
	<% 
	out.print(s.getTest_description());
	%>
	</td>
	<td>
	<% 
	out.print(s.getCost_of_the_test());
	
	%>
	</td>
	<td>
	<% 
	out.print(s.getLaborhome());
	String pid=(String)sp.getAttribute("pid");
	if(pid!=null || hcpid!=null)
	{
	%>
	</td>
	<td>
	 
	<form action="LabControllerServlet" method="post" >
 <input type="hidden" name="test_code" value=<%=s.getTest_code() %>"/>
    <input type="hidden" value="<%=s.getTest_name() %>" name="test_name"/>
    <input type="hidden" value="<%=s.getLab_service_provider_name() %>" name="lab_service_name"/>
    <input type="hidden" value="<%=s.getCity()%>" name="city"/>
    <input type="hidden" value="view_schedule" name="action"/>
       <input type="submit" class="btn btn-link" value="View Schedule" />

		</form>
	</td>
	</tr>
	<% 
	}
}
}
}
%>
</tbody>
</table>
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