<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Car Page</title>
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
	   <b>!!!!!!!!!!!!!!!!!!!!!!!!!!!</b> 
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	 </header>
	<div  class="container">
		<b style="color:black;">ADD CAR PAGE</b> 
	     <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
	      <h3>${message }</h3>
		<img id="studentImage"  src="${pageContext.request.contextPath}/img/bmw-z4.png" class="semere"  style="height: 100px;">
		<form name="carForm" action="${pageContext.request.contextPath}/addCar" method="post"  
		enctype="multipart/form-data">
		<div  class="semere"   style="width: 50%">
		 			<br/>
		            <label for="color" >Color</label>
		             <select class="form-control"  name="color">
		                 <option>White</option>
		                 <option>Red</option>
		                 <option>Blue</option>
		             </select>
		             <hr/>
		               <label>Model</label>
		            
  <select class="form-control"  name="model">
		                 <option>2020</option>
		                 <option>2018</option>
		                 <option>2012</option>
		                 <option>2010</option>
		             </select>
		             <hr/>
		               <label for="price">Price</label>
		            <input type="text" name="price" class="form-control" >
		            		             <hr/>
		              <label>Mfg*</label>
		            
  <select class="form-control"  name="mfg">
		                 <option>Honda</option>
		                 <option>BMW</option>
		                 <option>AUDI</option>
		             </select>
		             
		               <hr/>
		               <label for="photo">Photo</label>
		            <input type="file" name="photo" class="form-control" >
		            		  <hr/>
		        
		             <br/>
		<button type="submit" class="btn btn-primary" >Upload</button>
		</div>
		</form>
	</div>



</body>
</html>