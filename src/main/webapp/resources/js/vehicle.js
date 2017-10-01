

$(document).ready(function() {
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
$("#carbrand").change(function(){

	var carBrand = $("#carbrand").val();
	if(carBrand.length==0){///carBrand==""
		 $('#carmodel').html('');
		 $('#carmodel').append( '<option  value="" label="--select car brand---" />');
		// return;
		 
	} 
	$.ajax({
		//"http://localhost:8080/SecurityExample/vehicle/carmodel"
		url:contextRoot+'/vehicle/carmodel',
		type:"GET",
		dataType:'json',
		contentType:'application/json',
		data:"carbrand=" + carBrand,
		success:function(model){	
     		  $('#carmodel').html('');
			   var toAppend = '<option  value="" label="--select car brand---" />';
	           $.each(model,function(i,o){
	           toAppend += '<option value="'+o+'">'+o+'</option>';
	          });

	         $('#carmodel').append(toAppend);

           
				
				
		},
		error: function(xhr, status, error) {
		  (xhr.responseText);
		 }
		
	});
	
	
	
});
			});
