/**
 * 
 */

var nom = new Array();
var valeur = new Array();
var nomParcours;
var numeroTrou = new Array();
var distTrou = new Array();
var parTrou = new Array();
var hcpTrou = new Array();

// On enlève le ?
param = window.location.search.slice(1,window.location.search.length);

// On sépare le paramètres....
// first[0] est de la forme param=valeur

first = param.split("&");

for(i=0;i<first.length;i++){
    second = first[i].split("=");
    nom[i] = second[0];
    valeur[i] = second[1];
}

// on récupère les paramètres puis ouvre le xml correspondant
// valeur[1] = nom parcours pour xml
// valeur[2] = couleur depart

$(document).ready(function() {
		   $.ajax( {
		            type: "GET",
		            url: "/parcours/"+valeur[1]+".xml",
		            dataType: "xml",
		            success: function(xml) {
		            			$(xml).find('Courses').each(function(){
		            				nomParcours = $(this).find('Course').attr('N');
		            				document.getElementById("titre").innerHTML = "<h2>"+nomParcours+"</h2>";
		            				var i;
	                        		for(i=1;i<19;i++) {
	                        			numeroTrou[i] = $(this).find('Course').find('Tees').find(valeur[2]).find('H'+i).attr('N');
	                        			document.getElementById("N"+i).innerHTML = numeroTrou[i];
	                        		}
	                        		for(i=1;i<19;i++) {
	                        			distTrou[i] = $(this).find('Course').find('Tees').find(valeur[2]).find('H'+i).attr('Y');
	                        			document.getElementById("D"+i).innerHTML = distTrou[i];
	                        		}
	                        		for(i=1;i<19;i++) {
	                        			parTrou[i] = $(this).find('Course').find('Tees').find(valeur[2]).find('H'+i).attr('P');
	                        			document.getElementById("P"+i).innerHTML = parTrou[i];
	                        		}
	                        		for(i=1;i<19;i++) {
	                        			hcpTrou[i] = $(this).find('Course').find('Tees').find(valeur[2]).find('H'+i).attr('H');
	                        			document.getElementById("H"+i).innerHTML = hcpTrou[i];
	                        		}
	                     		});
		                      }
		        });
		   
		   		// changer la couleur des colonnes en fonction des du param depart GET
				$('.D').addClass(valeur[2]);
		}
);