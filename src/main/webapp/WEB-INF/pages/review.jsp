<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Review Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.tcenter {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>

</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;"> </header>

	<div class="container">
		<img src="img/student.png"  style="height: 150px;">
		 <span  style="font-weight: bold;font-size: 18px">${message}</span>
		<form action="register" method="post">
		<div  class="tcenter" style="width: 75%">
		           <table class="table table-bordered">
    <thead>
      <tr>
        <th>Username</th>
        <th>${pdata.userid}</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Password  :  </td>
        <td>${pdata.password}</td>
      </tr>
      <tr>
        <td>Name  :  </td>
        <td>${pdata.name}</td>
      </tr>
      <tr>
        <td>Email  :  </td>
        <td>${pdata.email}</td>
      </tr>
      
   
      <tr>
        <td>Salutation  :  </td>
        <td>${pdata.image}</td>
      </tr>
      
        <tr>
        <td>Date  :  </td>
        <td>${pdata.createDate}</td>
      </tr>
      
            <tr>
        <td>Pid  :  </td>
        <td>${pdata.uid}</td>
        
      </tr>
      
         <tr>
        <td>Image  :  </td>
        <td><img src="${pdata.salutation}" style="height: 200px;"></td>
      </tr>
    </tbody>
  </table>
        <span style="float: right;">
        <a href="${pageContext.request.contextPath}/dasha"><button type="button" class="btn btn-primary">Edit</button></a>
        
      	<a href="${pageContext.request.contextPath}/dasha"><button type="button" class="btn btn-info">Next</button></a>
      	</span>
		</div>
		</form>
	</div>

</body>
</html>