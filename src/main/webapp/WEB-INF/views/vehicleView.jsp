
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link href="/resource/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Vehicle</title>
</head>

<body>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<section>
		<div class="jumbotron">
			<div class="container">
				<!-- <h1>Valued Members</h1> -->
				<h3>Your car details</h3>
				<c:out value="${vehicle.memberId}" />
			</div>
		</div>
	</section>

	
	<div class="text-center col-md-4 col-md-offset-4">


		<c:choose>
			<c:when test="${vehicleList.size()!=0}" >
				<table class="table table-striped">
				 MemberID:
					<tr>
						
					   <th></th>
						<th>Edit</th>
						<th>Delet</th>
					</tr>
					<c:forEach items="${vehicleList}" var="vehicle">
					<c:out value="${vehicle.memberId}" />
						
						
						 <tr>
						<td><i  id="display" class="fa fa-car" style="color:black;"></i>
						<img src="<c:url value="/resource/images/${vehicle.id}"></c:url>"/><!-- .jpg -->
						
							<c:out value="${vehicle.carBrand}" />
							
							<!-- <div id="imageDisplay" style="display: none;"> -->
							<c:url value="/vehicle/uploadFile/${vehicle.id}" var="updateUrl"/>
					<form:form action="${updateUrl}" method="post" enctype="multipart/form-data">
									<input type="file" name="file" /> <input type="submit"
											value="Upload File" class="btn btn-primary" />
									
								</form:form> 
								<!-- </div>  -->
							</td>

							<td><a
								href="<spring:url value="/vehicle/updateVehicle/${vehicle.id}" />">
									<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a
								href="<spring:url value="/vehicle/deletVehicl/${vehicle.id}" />">
									<span class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>

				</table>
			</c:when>
			<c:otherwise>
          <form:errors cssStyle="background:white;color:red;"><b> No Record of your car is found:</b></form:errors>
			</c:otherwise>

		</c:choose>
		<a href="<spring:url value="/vehicle/addvehicle" />"
			class="btn btn-primary"> <span class=""></span> Add a car
		</a>
		  <%--  <a href="<spring:url value="/members/number/${vehicleList.id}" />" class="btn btn-primary  btn-mini  ">View</a> --%>
	</div>

 <script src="<c:url value="/resource/js/vehicle.js" />"></script> 

</body>
</html>