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


</script>

</head>
<body>
	<header style="background-color: #03a9f4; height: 30px;">
	   <b>!!!!!!!!!!!!!!!!!!!!!!!!!!!</b> 
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	 </header>
	<div  class="container">
		<b style="color:black;">CARs PAGE</b> 
	     <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
	      <marquee scrolldelay="100">
		<img id="studentImage"  src="${pageContext.request.contextPath}/img/bmw-z4.png" class="semere"  style="height: 100px;display: inline;">
	<img id="studentImage"  src="${pageContext.request.contextPath}/img/bmw-z4.png" class="semere"  style="height: 100px;display: inline;">
	<img id="studentImage"  src="${pageContext.request.contextPath}/img/bmw-z4.png" class="semere"  style="height: 100px;display: inline;">
	</marquee>
	 <hr style="border-top: 5px solid rgba(103,58,183,1);"/>
	
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
        <td>${item.id}</td>
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

</body>
</html>