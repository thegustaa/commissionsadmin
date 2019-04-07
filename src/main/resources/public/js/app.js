function clearForm(){
	$("#messages").text("");
	$("#commissionstudentId").val("");
	$("#faculty").text("");
	$("#career").text("");
	$("#subject").text("");
	$("#semester").text("");
	$("#timeshift").text("");
	$("#year").text("");
	$("#finalscore").val(null);		
	resetSelect($( "#commissions" ));	
	$("#finalscore").prop('disabled', false);	
	$("#commissions").closest("div.form-group").hide();
	$("#commission").hide();
	$("#finalscore").closest("div.form-group").hide();
}

$(document).ready(function() { 
	clearForm();
	
	$("#finalscore").val(null);
	var request = $.ajax({
	  url: "/api/v1/students",
	  method: "GET",
	  dataType: "json"
	}).done(function( data ) {
		var jqSelect = $( "#students" );
		resetSelect(jqSelect );
		$.each(data, function(index, student) {
			jqSelect .append( "<option value='"+student.id+"'>"+student.lastname+","+
					student.firstname+"</option>");	
		});	  
	}).fail(function( jqXHR, textStatus ) {
	  alert( "Request failed: " + textStatus );
	});
	
	$("#students").on('change', function(){	
		clearForm();
		var request = $.ajax({
			  url: "/api/v1/students/"+$("#students").val()+"/commissions",
			  method: "GET",
			  dataType: "json"
			}).done(function( data ) {
				var jqSelect= $( "#commissions" );
				resetSelect(jqSelect );
				
				if (data.length > 0){
					$.each(data, function(index, commission) {
					var name= commission.professorship.name
							+" "+commission.year
							+" - "+commission.semester.name
							+" "+commission.timeshift.name;
					jqSelect.append( "<option value='"+commission.id+"'>"+name+"</option>");	
					});
					
					$("#commissions").closest("div.form-group").show();				
				} else {
					showError("Sin comisiones asignadas.");
				}
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
	});
	
	$("#commissions").on('change', function(){
		var request = $.ajax({
			  url: "/api/v1/commissions/"+$("#commissions").val(),
			  method: "GET",
			  dataType: "json"
			}).done(function( commission ) {
			  $("#faculty").text(commission.professorship.subject.career.faculty.name);
			  $("#career").text(commission.professorship.subject.career.name);
			  $("#subject").text(commission.professorship.subject.name);
			  $("#semester").text(commission.semester.name);
			  $("#timeshift").text(commission.timeshift.name);
			  $("#year").text(commission.year);
			  $("#commission").show();
			  $("#finalscore").closest("div.form-group").show();
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		
		var request = $.ajax({
			  url: "/api/v1/students/"+$("#students").val()
			  			+"/commissionsstudent/"
			  			+$("#commissions").val(),
			  method: "GET",
			  dataType: "json"
			}).done(function( commissionstudent ) {	
				$("#commissionstudentId").val(commissionstudent.id);
				if (commissionstudent.studentsituation.name=="Libre"){
					showError("Estudiante en condición libre. No puede cargar nota.");
					$("#finalscore").prop('disabled', true);
				} else {
					$("#finalscore").val(commissionstudent.finalscore);						
				}
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
	
	});
	
	$("#submit").on('click', function() {
		var request = $.ajax({
			  url: "/api/v1/commissionsstudents/"+$("#commissionstudentId").val(),
			  method: "PUT",
			  data: JSON.stringify({ "finalscore": $("#finalscore").val() }),
			  dataType: "json",
			  contentType: 'application/json'
			}).done(function( data ) {				
				showInfo("Nota cargada correctamente.");
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
	});

})