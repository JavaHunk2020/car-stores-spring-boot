<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "hero" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Cars</title>
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
	
	<style>
.zoom {
  transition: transform .2s; /* Animation */
  margin: 0 auto;
  height: 120px;
}

.zoom:hover {
  transform: scale(1.5); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
}
</style>

<style type="text/css">
.semere {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>
<script type="text/javascript">

//https://stackoverflow.com/questions/4459379/preview-an-image-before-it-is-uploaded
//Code to perview image
function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      $('#blah').attr('src', e.target.result);
	    }
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
	}

$(document).ready(function(){
	    $("#imgInp").change(function() {
		  readURL(this);
		});
});


function openModal(rid){
	$("#updateImageModal").modal("show");
	//it is setting database unique id inside hidden field
	$("#rid").val(rid);
	$("#cphoto").attr("src","loadImage?rid="+rid);
}



function openPriceModal(rid){
	
	//below code is fetching price data for a particular as a JSON
	const options = {
			  method: 'GET',
			  headers: {
			    'Content-Type': 'application/json',
			    'Accept': 'application/json'
			  }
			};
	
	 fetch('v3/car/prices?cid='+rid, options)
	  .then(res => res.json())
	  .then(data => {
		  	console.log(data); //data array of JavaScript object
		  	var htmlContent="";
		  	for(var x=0;x<data.length;x++) {
		  		   var rowdata=data[x];
		  		 htmlContent=htmlContent+'<tr>';
		  		 htmlContent=htmlContent+'<td>'+(x+1)+'</td>';
		  		 htmlContent=htmlContent+'<td>'+rowdata.price+'</td>';
		  		 htmlContent=htmlContent+'<td>'+rowdata.doe+'</td>';
		  		 htmlContent=htmlContent+'</tr>';
		  	}
		  	$("#modelData").html(htmlContent);
		});
	$("#showPricesModal").modal("show");
	//it is setting database unique id inside hidden field
	$("#pcphoto").attr("src","loadImage?rid="+rid);
}

</script>

</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;">
	   <b>!!!!!!!!!!!!!!!!!!!!!!!!!!!</b> 
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	 </header>
	<div  class="container">
		<b style="color:black;">Pagination Cars</b> 
	     <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
	      <marquee scrolldelay="100" behavior="alternate">
		<img id="studentImage"  src="${pageContext.request.contextPath}/img/bmw-z4.png" class="semere"  style="height: 100px;display: inline;">
	<img id="studentImage"  src="${pageContext.request.contextPath}/img/bmw-z4.png" class="semere"  style="height: 100px;display: inline;">
	<img id="studentImage"  src="${pageContext.request.contextPath}/img/bmw-z4.png" class="semere"  style="height: 100px;display: inline;">
	</marquee>
	 <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
	 <b style="background-color: yellow;">${startPage}</b> - ${startPage+maxRecord-1} of <b>${totalCount}</b>
	   <a href="${pageContext.request.contextPath}/pcars?page=${cpage-1}">
	  <img src="${pageContext.request.contextPath}/img/pre.png" style="height: 25px;margin-left: 20px;"/>
	  </a>
	  <a href="${pageContext.request.contextPath}/pcars?page=${cpage+1}">
	  <img src="${pageContext.request.contextPath}/img/next.png" style="height: 25px;margin-left: 20px;"/>
	  </a>
	 <table class="table table-bordered">
    <thead>
      <tr>
        <th>Cid</th>
        <th>Color</th>
        <th>Model</th>
        <th>Price</th>
        <th>Mfg</th>
        <th>Photo</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    <hero:forEach  items="${carLista}"  var="item">
      <tr>
        <td>${item.id}
            <a href="javascript:openPriceModal(${item.id});">
          <img src="${pageContext.request.contextPath}/img/details.png"/>
          </a>
        </td>
        <td>${item.color}</td>
        <td>${item.model}</td>
          <td>${item.price}</td>
        <td>${item.mfg}</td>
        <td>
         <img src="${pageContext.request.contextPath}/loadImage?rid=${item.id}"  class="zoom" >
          <a href="javascript:openModal(${item.id});">
          <img src="${pageContext.request.contextPath}/img/edit.png"/>
          </a>
        </td>
        <td>
        <img src="${pageContext.request.contextPath}/img/edit.png"/>
        <img src="${pageContext.request.contextPath}/img/delete.png" style="height: 45px;"/>
        </td>
      </tr>
      </hero:forEach>
   
    </tbody>
  </table>
	</div>

<!-- The Modal -->
<div class="modal" id="updateImageModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <form action="updatePhoto" method="post"  enctype="multipart/form-data">
       <input type="hidden"  name="id"   id="rid"  class="form-control" />
      <div class="modal-header">
        <h4 class="modal-title">Update Photo</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
             <lable>Current Pic : </lable>
             <img src=""   id="cphoto" style="height: 200px;">
              <lable>New Price: </lable>
             <input  type="text"    name="price"  class="form-control"  style="background-color: #dffffc;"/>
             <hr/>
             <input  type="file" id="imgInp"  name="photo"  class="form-control"  style="background-color: #dffffc;"/>
             <hr/>
              <img id="blah" src="#" alt="your image"  style="height: 120px;"/>
             
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      <button type="submit" class="btn btn-primary">Update Photo</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
      </form>

    </div>
  </div>
</div>

<div class="modal" id="showPricesModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <form action="updatePhoto" method="post"  enctype="multipart/form-data">
       <input type="hidden"  name="id"   id="rid"  class="form-control" />
      <div class="modal-header">
        <h4 class="modal-title">Car Price List</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
             <lable>Car Pic : </lable>
             <img src=""   id="pcphoto" style="height: 200px;">
             <hr/>
              <table class="table table-bordered">
    <thead>
      <tr>
        <th>Sno</th>
        <th>Price</th>
        <th>DOE</th>
      </tr>
    </thead>
    <tbody id="modelData">
     
      </tbody>
      </table>
      
             
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
      </div>
      </form>

    </div>
  </div>
</div>

</body>
</html>