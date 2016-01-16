function registervalid()
{
	var value1=document.getElementById("hcpname").value;
	var value2=document.getElementById("licensenumber").value;
	var value3=document.getElementById("contactnumber").value;
	var value4=document.getElementById("emergencycontnum").value;
	var value5=document.getElementById("email").value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	if(value1=="")
	{
		alert("please enter name");
		return false;
	}
	if(value2==""|| isNaN(value2))
	{
		alert("dont leave empty please enter valid license number");
		return false;
	}
	if(value3==""|| isNaN(value3))
	{
		alert("dont leave empty please enter valid contact number");
		return false;
	}
	if(value4==""|| isNaN(value4))
	{
		alert("dont leave empty please enter valid alt contact number");
		return false;
	}

	if (!filter.test(value5)) 
	{
	    alert('Please provide a valid email address');
	    return false;
	}
	return true;
}
