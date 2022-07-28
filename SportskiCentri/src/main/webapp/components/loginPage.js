Vue.component("login-page", {
	
	template: ` 
<div>
	<div class="topnav">
 	 	<a  style="float: left; "href="#/">Početna strana</a>
 	 	<a  href="#/registration">Registruj se</a>
 	 	<a  class="active" href="#/login">Uloguj se</a>
 	 
	</div>
	
	<div class="log">
		<form @submit='login'>
				<table>
					<tr><td>Korisničko ime</td><td><input type="text"></td></tr>
					<tr><td>Lozinka</td><td><input type="password" ></td></tr>
					<tr><b><td><input type="submit" value="Uloguj se"></td></b></tr>
					<tr><td id="logInText"></td></tr>
				</table>
			</form>
	
	</div>
	
	
	
</div>		  
`
	, 
	
});