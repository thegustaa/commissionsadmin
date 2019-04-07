/**
 * Reinicia el select dejando solamente la opción predeterminada.
 * @param jqSelect
 */
function resetSelect(jqSelect) {
	jqSelect.html("<option value='-1'>Seleccione...</option>");
}

/**
 * Carga mensaje de error en container con clase 'messages'.
 * @param message
 */
function showError(message) {
	var alert=
	"<div class='alert alert-danger alert-dismissible'>"+
	  "<button type='button' class='close' data-dismiss='alert'>&times;</button>"+
	  message+
	"</div>";
	
	$("#messages").append(alert);
}

/**
 * Carga mensaje de error en container con clase 'messages'.
 * @param message
 */
function showInfo(message) {
	var alert=
	"<div class='alert alert-success alert-dismissible'>"+
	  "<button type='button' class='close' data-dismiss='alert'>&times;</button>"+
	  message+
	"</div>";
	
	$("#messages").append(alert);
}