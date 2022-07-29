Vue.component("login-page", {
	
	template: ` 
<div>
	<div class="topnav">
 	 	<a  style="float: left; "href="#/">Početna strana</a>
 	 	<a  href="#/registration">Registruj se</a>
 	 	<a  class="active" href="#/login">Uloguj se</a>
 	 
	</div>
	
	<div class="loginForma">
		<form  class="login-form" @submit='login'>
				<table>
					<tr>
						<td>Korisničko ime</td>
						<td><input class="loginInput" type="text"></td>
					</tr>
					<tr>
						<td>Lozinka</td>
						<td><input class="loginInput" type="password" ></td>
					</tr>
					
					<tr>
					
					<td colspan="2">
					 <input  class="button-3" type="submit" value="Uloguj se">
					</td>
					
					</table>
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	, 
	
});