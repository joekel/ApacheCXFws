



function doGet(){
	$.ajax({
    	type: "GET",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/FinalSpringProject2/services/patientservice/costomer/"+$('#patientID').val(),
        
  
    }
	
	
	).then(function(data) {
		 alert('Customer Deleted');
       $('#patientID').val(data.id);
       $('#patientName').val(data.name); 
    });
}
	
function doPut(){
$.ajax({
	type: "PUT",
	 contentType: "application/json; charset=utf-8",
     dataType: "json",
     data: JSON.stringify({name:$('#patientName').val()}),
    url: "http://localhost:8080/FinalSpringProject2/services/patientservice/"
    	
	}).then(function(data) {
		$('#patientID').val(data.id);
		$('#patientName').val(data.name);
	});
    
}
	
	
function doDelete(){
	$.ajax({
    	type: "DELETE",
    	 contentType: "application/json; charset=utf-8",
         dataType: "json",
        url: "http://localhost:8080/FinalSpringProject2/services/patientservice/costomer/"+$('#patientID').val()
    }).then(function(data) {
       alert('Customer Deleted');
    });
}