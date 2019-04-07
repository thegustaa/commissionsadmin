$(document).ready(function(){
	$(".sub-page").hide();
	$(".vert-menu").on('click', function(){
		$(".sub-page").hide();
		var page = $(this).data("page");
		$("#"+page).show();
	});
});