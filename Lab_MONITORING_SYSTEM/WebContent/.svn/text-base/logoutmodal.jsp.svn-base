<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logout Prompt</title>
</head>
<body>
<div class="modal  fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title modal-error">Are You Sure want to logout</h4>
        </div>
        <div class="modal-footer">
          
         
			<form action="logout.jsp" method="post">
				<input type="submit" value="Log Out" class="btn btn-danger">
				<input type="hidden" value="deletePatient" name="action"></input>
			<%
			HttpSession s2=request.getSession();
			String hcpid=(String)s2.getAttribute("hcpid");
			String pid=(String)s2.getAttribute("pid");
			if(hcpid!=null)
			{
			
			%>
        <a href="hcpPanel.jsp" type="button"  class="btn btn-default">Cancel</a>
			<%
			
			}
			else
			{
				%>
				
				 <a href="Patientpanel.jsp" type="button"  class="btn btn-default">Cancel</a>
				 <% 
			}
			%>
			
			
			</form>
        
        </div>
      </div>
      
    </div>
  </div>
    
</body>
  <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script>
$(window).load(function(){
    $('#myModal').modal('show');
});
</script>
</html>