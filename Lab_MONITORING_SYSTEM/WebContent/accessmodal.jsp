<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Patient Prompt</title>
</head>
<body>
<div class="modal  fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title modal-error">Access Denied</h4>
        </div>
       
          
         
			<div class="modal-body">
          <p> We are sorry you can't access this page without login</p>
         
        </div>
			 <div class="modal-footer">
        <a href="index.jsp" type="button"  class="btn btn-primary">OK</a>
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