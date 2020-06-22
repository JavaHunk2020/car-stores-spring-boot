<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">

.semere {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>


</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;">
	   <b>Address : = ${applicationScope.address}</b> 
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<b style="color:yellow;">Email : = ${applicationScope.email}</b> 
	 </header>
	<div  class="container">
	     <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
		<img id="studentImage"  src="${pageContext.request.contextPath}/img/student.png" class="semere"  style="height: 200px;">
		
		<form name="loginform" action="${pageContext.request.contextPath}/auth" method="post">
		<div  class="semere"   style="width: 50%">
		 <span  id="message"  style="color:red;font-size: 16px;font-weight: bold;">
		       ${message}
		 </span>
		 			<br/>
		            <label for="username">Username</label>
		            <input type="text" name="username" class="form-control"  onkeyup="clearMessage();">
		              <br/>
		               <label>Password</label>
		            <input type="password" name="password" class="form-control" onkeyup="clearMessage();">
		             <br/>
		<button type="button" class="btn btn-primary"  onclick="validateAuth();">Sign In</button>
		<a href="${pageContext.request.contextPath}/addCar"><button type="button" class="btn btn-info">Sign Up</button></a>
		</div>
		</form>
	</div>


<script>


function clearMessage(){
	 var spanObject=window.document.getElementById("message");
	  spanObject.innerHTML="";
}

function validateAuth()  {
	  //window.document.loginform.username = object
	  var username=document.loginform.username.value;
	  if(username.length==0) {
		  var spanObject=window.document.getElementById("message");
		  spanObject.innerHTML="Username cannot be empty";
		  document.loginform.username.focus();
		  return;
	  }
	  var password=window.document.loginform.password.value;	  
	  if(password.length==0) {
		  var spanObject=window.document.getElementById("message");
		  spanObject.innerHTML="Password cannot be empty";
		  document.loginform.password.focus();
		  return;
	  }
	  //submit form data from client to server using JavaScript
	  document.loginform.submit();
}
   
   //This is called global variable
   var count =1;
   
    function validate()  {
    	  //Accessing an object in JavaScript
    	  var imgObj=window.document.getElementById("studentImage");
    	  imgObj.src="img/college-student-dental-health.jpg";
    	  console.log("Hello do not click here!!!!!!!!!!!!! count = "+count);
    		count++;
    }

    var  x =100;
    var  y =900;
    var temp = x+y;
    //System.out.println
    console.log("temp  = "+temp);		
</script>
</body>
</html>