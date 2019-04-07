function clearForm(){
	$("#load .messages").text("");
	$("#load .commissionstudentId").val("");
	$("#load .commission .faculty").text("");
	$("#load .commission .career").text("");
	$("#load .commission .subject").text("");
	$("#load .commission .semester").text("");
	$("#load .commission .timeshift").text("");
	$("#load .commission .year").text("");
	$("#load .finalscore").val(null);		
	resetSelect($( "#load .commissions" ));	
	$("#load .finalscore").prop('disabled', false);	
	$("#load .commissions").closest("div.form-group").hide();
	$("#load .commission").hide();
	$("#load .finalscore").closest("div.form-group").hide();
}

$(document).ready(function() { 
	clearForm();
	
	$("#load .finalscore").val(null);
	var request = $.ajax({
	  url: "/api/v1/students",
	  method: "GET",
	  dataType: "json"
	}).done(function( data ) {
		var jqSelect = $( "#load .students" );
		resetSelect(jqSelect );
		$.each(data, function(index, student) {
			jqSelect .append( "<option value='"+student.id+"'>"+student.lastname+","+
					student.firstname+"</option>");	
		});	  
	}).fail(function( jqXHR, textStatus ) {
	  alert( "Request failed: " + textStatus );
	});
	
	$("#load .students").on('change', function(){	
		clearForm();
		var request = $.ajax({
			  url: "/api/v1/students/"+$("#load .students").val()+"/commissions",
			  method: "GET",
			  dataType: "json"
			}).done(function( data ) {
				var jqSelect= $( "#load .commissions" );
				resetSelect(jqSelect );
				
				if (data.length > 0){
					$.each(data, function(index, commission) {
					var name= commission.professorship.name
							+" "+commission.year
							+" - "+commission.semester.name
							+" "+commission.timeshift.name;
					jqSelect.append( "<option value='"+commission.id+"'>"+name+"</option>");	
					});
					
					$("#load .commissions").closest("div.form-group").show();				
				} else {
					showError("Sin comisiones asignadas.");
				}
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
	});
	
	$("#load .commissions").on('change', function(){
		var request = $.ajax({
			  url: "/api/v1/commissions/"+$("#load .commissions").val(),
			  method: "GET",
			  dataType: "json"
			}).done(function( commission ) {
			  $("#load .commission .faculty").text(commission.professorship.subject.career.faculty.name);
			  $("#load .commission .career").text(commission.professorship.subject.career.name);
			  $("#load .commission .subject").text(commission.professorship.subject.name);
			  $("#load .commission .semester").text(commission.semester.name);
			  $("#load .commission .timeshift").text(commission.timeshift.name);
			  $("#load .commission .year").text(commission.year);
			  $("#load .commission").show();
			  $("#load .finalscore").closest("div.form-group").show();
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
		
		var request = $.ajax({
			  url: "/api/v1/students/"+$("#load #students").val()
			  			+"/commissionsstudent/"
			  			+$("#load .commissions").val(),
			  method: "GET",
			  dataType: "json"
			}).done(function( commissionstudent ) {	
				$("#load .commissionstudentId").val(commissionstudent.id);
				if (commissionstudent.studentsituation.name=="Libre"){
					showError("Estudiante en condición libre. No puede cargar nota.");
					$("#load .finalscore").prop('disabled', true);
				} else {
					$("#load .finalscore").val(commissionstudent.finalscore);						
				}
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
	
	});
	
	$("#load .submit").on('click', function() {
		var request = $.ajax({
			  url: "/api/v1/commissionsstudents/"+$("#load .commissionstudentId").val(),
			  method: "PUT",
			  data: JSON.stringify({ "finalscore": $("#load .finalscore").val() }),
			  dataType: "json",
			  contentType: 'application/json'
			}).done(function( data ) {				
				showInfo("Nota cargada correctamente.");
			}).fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
			});
	});

})