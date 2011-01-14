<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>			
			
			<div id="menu">
				
				<div id="membre">
					
					<img id="mmd" src="/img/mmd.png"/> <br/><br/>	
					
					Bonjour : <span class="info"></span><br/><br/>
					
					> Club: <span class="info"></span><br/>
					> Index: <span class="info"></span><br/>
					> Dernière partie: <span class="info"></span><br/>
					
				</div>
			
				<div id="ssmenu">
			
					<h3><a href="#">PARTIE</a></h3>
			    	<div id="partie">
						<a href="ajouterPartie"><img id="img" src="/img/ajouter.png"/> Ajouter partie</a><br/><br/>
						<a href="chargerPartie"><img id="img" src="/img/charger.png"/> Charger partie</a><br/><br/>
						<a href="supprimerPartie"><img id="img" src="/img/supp.png"/> Supprimer partie</a><br/><br/>
					</div>
				
			    	<h3><a href="#">PROFILE</a></h3>
					<div id="profile">
						<br/><br/>
						<a href="/openscore?page=profile"><img id="img" src="/img/edit.png"/> Modifier profile</a><br/><br/>
						<a href="/openscore?page=deconnexion"><img id="img" src="/img/deco.png"/> Déconnexion</a>
						<br/><br/>
					</div>
			
				</div>
				
				<div >
				<img src="/img/jrwlogo.png" alt="Powered by JRed Way" id="jrw"/>
				<img src="http://code.google.com/appengine/images/appengine-silver-120x30.gif" alt="Powered by Google App Engine" id="pub"/>
				</div>
			
			</div>