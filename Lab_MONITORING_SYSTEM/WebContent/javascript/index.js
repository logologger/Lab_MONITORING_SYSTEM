/**
 * Created by Rajat Singh Bhadauria
 * Dated 26 September
 * 2015
 * 
 */
function validate_search()
{
	
	var search=document.getElementById("search").value;
	if(search==null  || search=="")
		{
		alert('Search Box Cant be Empty');
			return false;
		}
	return true;
	}
function showing(hidden)
	{
		var show=document.getElementById("showing");
		show.style.display=hidden.checked?"block":"none";
	
	}
function validate()
{

	var first_name=document.getElementById("first_name").value;
	var last_name=document.getElementById("last_name").value;
	var age=document.getElementById("age").value;
	var address=document.getElementById("address").value;
	var phone_number=document.getElementById("phone_number").value;
	var gender=document.getElementsByName("gender");
	if(first_name==null || first_name=="")
		{
		alert('First Name cant be null');
		return false;
		}
	if(last_name==null || last_name=="")
		{
		alert('Last name cant be null');
			return false;
		}
	if(age==null || age=="")
		{
		alert('age cant be null');
		return false;
			
		}
	if(gender[0].checked==false && gender[1].checked==false)
		{
		alert('Please select any one gender');
		return false;
		}
	if(phone_number == null || phone_number=="")
		{
		alert('Please Enter Phone Number');
		return false;
		}
	
		return true;
	}