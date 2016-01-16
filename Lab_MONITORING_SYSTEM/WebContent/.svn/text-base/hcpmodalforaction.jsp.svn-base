<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
</head>
<body>

<%

String message=(String)request.getAttribute("message");

%>
<div class="modal  fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title modal-error">Message from System</h4>
        </div>
         <div class="modal-body">
           <%
         if(message!=null)
         {
        	 if(message.equals("successupdate"))
        	 {
        		 %>
        		 
        		  <p>Your details are updated</p>
        		  <%
        	 }
        	 else if(message.equals("errorupdate"))
        	 {
        		 %>
        		 
       		  <p>Sorry ! Something went wrong. Your details not updated..Please try Again</p>
       		  <%
        		 
        	 }
        	 else if(message.equals("mismatch"))
        	 {
        		 %>
        		 
       		  <p>Sorry!! Password you have entered did not match with our records.Please enter correct password!! </p>
       		  <%
        		 
        	 }
        	 
        	 
        	 
        	 
        	 
        	 else{

        		 %>
        		   <p>Oops!! there is some issue.We will correct it soon. Sorry for In convinence</p>
       			  <%
        		 
        	 }
        	 
        	 
         }
          
          %> 
        </div>
        <div class="modal-footer">
          
        
        <a href="hcpPanel.jsp" type="button"  class="btn btn-default">Continue</a>
		
        
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