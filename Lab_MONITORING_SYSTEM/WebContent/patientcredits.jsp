<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Note down the Patient Credentials Please</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<%
String p_id=(String)request.getAttribute("hcp_p_id");
String password=(String)request.getAttribute("hcp_p_password");
//out.print(p_id+"  "+password);
if(p_id!=null && password!=null )
{
	%>
	<div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">

  <!-- Modal content-->
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal">&times;</button>
      <h4 class="modal-title">Please Note down Patient Login Credentials</h4>
    </div>
    <div class="modal-body">
      <p><%  out.print("<b>Patient ID:</b>"+p_id); %></p>
      <p>
      <%  out.print("<b>Password:</b> "+password); %>
      </p>
    </div>
    <div class="modal-footer">
      <a href="hcpPanel.jsp" type="button"  class="btn btn-default">Close</a>
    </div>
  </div>
  
</div>
</div>
	<% 
	//show him error message
}
else if(p_id!=null && password==null ){
	
	response.sendRedirect("hcpPanel.jsp");
}
else
{
	System.out.println("He must have another situation in hcp via patient");
	
	//success
	//show him success and login_id and password
	
	
}
%>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script>
$(window).load(function(){
    $('#myModal').modal('show');
});
</script>

</body>
</html>