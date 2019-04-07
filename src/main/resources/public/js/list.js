$(document).ready(function() { 
		$("#list .finalscore").val(null);
		var request = $.ajax({
		  url: "/api/v1/commissions",
		  method: "GET",
		  dataType: "json"
		}).done(function( data ) {
			var jqSelect = $( "#list .commissions" );
			resetSelect(jqSelect );
			$.each(data, function(index, commission) {
				var name= commission.professorship.name
				+" "+commission.year
				+" - "+commission.semester.name
				+" "+commission.timeshift.name;
				jqSelect.append( "<option value='"+commission.id+"'>"+name+"</option>");
			});	  
		}).fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
		});
		
		$("#list .commissions").on('change', function(){
			$("#list .table-studentscommission tbody").html("");
			$("#list .search-input").val("");
			var request = $.ajax({
				  url: "/api/v1/commissionsstudents/search?id_commission="+$("#list .commissions").val(),
				  method: "GET",
				  dataType: "json"
				}).done(function( commissionstudents ) {					
						$.each(commissionstudents, function (index, commissionstudent) {
							var rowClass="table-light";
							var situation = commissionstudent.studentsituation.name;
							if (situation=="Libre"){
								rowClass="table-danger";
							} else if (situation=="Regular" 
								&& commissionstudent.finalscore != null) {								
									rowClass="table-success";												
							}
							
							var finalscore = commissionstudent.finalscore;
							if (finalscore==null) {
								finalscore="-";
							}
							
							var row="<tr class='"+rowClass+"'>"+
						        "<td>"+commissionstudent.student.firstname+"</td>"+
						        "<td>"+commissionstudent.student.lastname+"</td>"+
						        "<td>"+commissionstudent.studentsituation.name+"</td>"+
						        "<td>"+finalscore+"</td>"+
						      "</tr> ";
							$("#list .table-studentscommission tbody").append(row);
						});
					}).fail(function( jqXHR, textStatus ) {
							alert( "Request failed: " + textStatus );
					});
				});
		
		 $("#list .search-input").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#list .table-studentscommission tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
		 });

  });