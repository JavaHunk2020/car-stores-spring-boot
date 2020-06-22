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
	
	    <p style="font-size: 18px;">Hello , <b>${sessionScope.userData.name}</b> , Email , <b>${sessionScope.userData.email}</b></p>
	    <hr/>
		<img src="${pageContext.request.contextPath}/img/car.jpg"  style="height:180px;"> 
		<a href="${pageContext.request.contextPath}/logout">
		  <img src="${pageContext.request.contextPath}/img/logout.png" style="height: 60px;">
		  </a>
		 
		<div  class="tcenter" style="width: 75%">
		           <table class="table table-bordered">
      <tr>
        <td>
        <a href="${pageContext.request.contextPath}/addCar">
        <img src="${pageContext.request.contextPath}/img/add-car.png">  
        </a>
        </td>
        <td><img src="${pageContext.request.contextPath}/img/add-car.png">  </td>
             <td>
             
             <a href="${pageContext.request.contextPath}/cars">
             <img src="${pageContext.request.contextPath}/img/cars.png">
             </a> 
              </td>
      </tr>
      <tr>
       <td>
          <a href="${pageContext.request.contextPath}/pcars">
       <img src="${pageContext.request.contextPath}/img/pagi.png">
       </a>  
       
       </td>
  <td><img src="${pageContext.request.contextPath}/img/add-car.png">  </td>
             <td><img src="${pageContext.request.contextPath}/img/add-car.png">  </td>
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