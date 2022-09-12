Vue.component("navigation-bar-admin", {
	
	template: ` 
<div>
<div class="topnav">
	 <a  href="#/" style="float: left; ">Svi objekti</a>
	 <a  href="#/allUsers" style="float: left; ">Svi korisnici</a>
 	 <a  href="#/addFacility" style="float: left; ">Novi objekat</a>
 	 <a  href="#/newTrainer" style="float: left; ">Novi trener</a>
 	 
 	 	<a href="http://localhost:8080/SportskiCentri/#/">Odjavi se</a>
 	 <a href="#/editAdmin">Profil</a>
 	 
<!--	
 	 <a href="#/registration">Registruj se</a>
 	 <a href="#/login">Uloguj se</a>
-->
	</div>
</div>		  
`

	
});