
<%@page import="java.util.*"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Vehicle</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<section>
		<div class="jumbotron">
			<div class="container">
				<!-- <h1>Valued Members</h1> -->
				<h3>Add Car</h3>
			</div>
		</div>
	</section>
	<c:choose>
			<c:when test="${mode=='NEW_VEHICLE'}">
			
        <form:form  method="post"  commandName="vehicle">
		<table align="center"  cellpadding="5"  >
		
		<tr>
		
		</tr>
		
		<tr>
			<td><form:label  path="plateNumber">Plate
				number:</form:label> 
				</td>
		<td><form:input placeholder="number plate" path="plateNumber"  /></td>
			<td><form:errors path="plateNumber" cssStyle="color:red;"/></td>
		</tr>
		
		 <tr>
			<td><form:label    path="registrationYear">Registration year:
				</form:label> </td>
				
			<td><form:input placeholder="registration year" path="registrationYear"   /></td>
		<td>
		<form:errors path="registrationYear" cssStyle="color:red;"/>
		 </td>
		</tr> 
		
		<tr>
			<td><form:label path="typeOfCar">Type of
				car:</form:label></td>
			<td><form:select path="typeOfCar" >
				<form:option value="" label="--select type of car--" />
				<form:options items="${typeofCar}"  />
			</form:select></td>
			<td>
			<form:errors path="typeOfCar" cssStyle="color:red;"/>
			</td>
		</tr>
		
		<tr>
			<td><form:label path="carBrand">Car brand:</form:label></td>
			<td><form:select path="carBrand"  id="carbrand"  >
				<form:option value=""  label="--select car brand---" />
				<form:options items="${carbrand}"  />
			</form:select></td>
			<td>
			<form:errors path="carBrand" cssStyle="color:red;"/>
			</td>
		</tr>
		
		 <tr>
			<td><form:label path="model">Car model:</form:label></td>
			<td><form:select path="model" id="carmodel"  >
				 <form:option   value="" label="--select car  model---" /> 
				
			</form:select></td>
			<td>
			  <form:errors path="model" cssStyle="color:red;"/>
			</td>
		</tr>
		
		<tr>
			<td><form:label path="color">Color of car:</form:label></td>
			<td><form:select path="color"  >
				<form:option value="" label="--select color of car--" />
				<form:options items="${color}"  />
				
			</form:select></td>
			<td>
			<form:errors path="color" cssStyle="color:red;"/>
			      </td>
		</tr>
		 
		
         <tr>
         
			<td><form:label path="description">Additional information:
				</form:label> </td>
			<td><form:textarea  path="description" rows="5" cols="20"  /></td>
			<td><form:errors path="description" cssStyle="color:red;"/></td>
		</tr>
		<tr>
		  <td></td>
			 <td colspan="2" align="center" >
				 <form:button class="btn btn-primary"   name="add">Add</form:button>
			 </td>
			
		</tr>
		</table>
		
	</form:form>
	</c:when>
	<c:otherwise>
	
    <c:url value="/vehicle/addvehicle" var="updateUrl"/>
        <form:form action="${updateUrl}"  method="post"  commandName="vehicle">
		<table align="center"  cellpadding="5"  >
		
		<tr>
			
		<td><form:hidden path="id" value="${update.id}" /></td>
			
		</tr>
		
		<tr>
			<td><form:label  path="plateNumber">Plate
				number:</form:label> 
				</td>
		<td><form:input placeholder="number plate" path="plateNumber" value="${update.plateNumber}" /></td>
			<td><form:errors path="plateNumber" cssStyle="color:red;"/></td>
		</tr>
		
		 <tr>
			<td><form:label    path="registrationYear" >Registration year:
				</form:label> </td>
				
			<td><form:input placeholder="nregistrationY year" path="registrationYear" value="${update.registrationYear}"  /></td>
		
		<td>
		<form:errors path="registrationYear" cssStyle="color:red;"/>
		 </td>
		</tr> 
		
		<tr>
			<td><form:label path="typeOfCar">Type of
				car:</form:label></td>
			<td><form:select path="typeOfCar"   >
				<form:option value="${update.typeOfCar}" label="${update.typeOfCar}" />
				<form:options items="${typeofCar}"  />
			</form:select></td>
			<td>
			<form:errors path="typeOfCar" cssStyle="color:red;"/>
			</td>
		</tr>
		
		<tr>
			<td><form:label path="carBrand">Car brand:</form:label></td>
			<td><form:select path="carBrand"  id="carbrand" value="${update.carBrand}" >
				<form:option value="${update.carBrand}"  label="${update.carBrand}"  />
				<form:options items="${carbrand}"  />
			</form:select></td>
			<td>
			<form:errors path="carBrand" cssStyle="color:red;"/>
			</td>
		</tr>
		
		 <tr>
			<td><form:label path="model">Car model:</form:label></td>
			<td><form:select path="model" id="carmodel" value="${update.model}" >
				 <form:option   value="${update.model}" label="${update.model}" /> 
				
			</form:select></td>
			<td>
			  <form:errors path="model" cssStyle="color:red;"/>
			</td>
		</tr>
		
		<tr>
			<td><form:label path="color">Color of car:</form:label></td>
			<td><form:select path="color" value="${update.color}" >
				<form:option value="${update.color}" label="${update.color}" />
				<form:options items="${color}"  />
				
			</form:select></td>
			<td>
			<form:errors path="color" cssStyle="color:red;"/>
			      </td>
		</tr>
		 
		
         <tr>
         
			<td><form:label path="description">Additional information:
				</form:label> </td>
			<td><form:textarea  path="description" value="${update.description}" rows="5" cols="20"  /></td>
			<td><form:errors path="description" cssStyle="color:red;"/></td>
		</tr>
		<tr>
		  <td></td>
			 <td colspan="2" align="center" >
				 <form:button class="btn btn-primary"   name="add">Add</form:button>
			 </td>
			
		</tr>
		</table>
		
	</form:form>
	
	</c:otherwise>
	</c:choose>

     <script src="<c:url value="/resource/js/vehicle.js" />"></script> 



</body>
</html>