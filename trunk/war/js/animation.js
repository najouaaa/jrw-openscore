$(function(){
	
	$("#menu").accordion({ header: "h3" });
	$("#deco").button();
	
	var message = "Voulez-vraiment vous d\351connecter ?";
	
	$('#confirm').bind('click', function() {
		confirm(message);
	}); 
	
});