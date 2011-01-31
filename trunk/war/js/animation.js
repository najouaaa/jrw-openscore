$(function(){
	
	/* Habillage diff */
	
	$("#menu").accordion({ header: "h3" });
	$("#deco").button();
	
	$('#confirm').button();
	$('.jbouton').button();
	$('.JHide').hide();
	
	/* boite de confirmation sauvegarder */
	
	/** 
	 * Création dialog jquery avec param
	 * pour sauvegarder
	 */
	$("#dialog-sauvegarder").dialog({
		autoOpen: false,
		resizable: false,
		height:230,
		modal: true,
		buttons: {
			"Sauvegarder": function() {
				document.confirmS.submit();
			},
			"Annuler": function() {
				$(this).dialog("close");
			}
		}
	});
	
	/**
	 * Evènement click sur le bouton
	 * pour vérif saisi != null
	 * pour sauvegarder
	 */
	$('#validerScore').click(function(){
		var valide = true;
		var i;
		
		// boucle vérif null ou juste numérique
		for(i=1;i<19;i++){
			if($('#S'+i).val() == "" || !$('#S'+i).val().match(/^[1-9]$/i)){
				valide = false;
				if(valide == false) {
					$('#S'+i).css('background-color','red');
					$('#S'+i).css('color','white');
				}
			}
		}
		
		if(valide == true) {
			$('form#confirmS').submit(function(){
				$('#dialog-sauvegarder').dialog('open');
				return false;
			});
		} else {
			alert('Erreur de saisit: \n\t * format accepté > numérique [1-9] \n\t * champs vide [empty] ');
			return false;
		}
	});
	
	/** 
	 * Création dialog jquery avec param
	 * pour modifier
	 */
	$("#dialog-modifier").dialog({
		autoOpen: false,
		resizable: false,
		height:230,
		modal: true,
		buttons: {
			"Modifier": function() {
				document.confirmC.submit();
			},
			"Annuler": function() {
				$(this).dialog("close");
			}
		}
	});
	
	/**
	 * Evènement click sur le bouton
	 * pour vérif saisi != null
	 * pour charger
	 */
	$('#modifierScore').click(function(){
		var valide = true;
		var i;
		
		for(i=1;i<19;i++){
			if($('#S'+i).val() == "" || !$('#S'+i).val().match(/^[1-9]$/i)){
				valide = false;
				if(valide == false) {
					$('#S'+i).css('background-color','red');
					$('#S'+i).css('color','white');
				}
			}
		}
		
		if(valide == true) {
			$('form#confirmC').submit(function(){
				$('#dialog-modifier').dialog('open');
				return false;
			});
		} else {
			alert('Erreur de saisit: \n\t * format accepté > numérique [1-9] \n\t * champs vide [empty] ');
			return false;
		}
	});
	
});
