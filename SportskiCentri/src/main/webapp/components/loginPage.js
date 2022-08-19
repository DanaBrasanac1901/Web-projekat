Vue.component("login-page", {
	
	data: function(){
		return{
			
			
		}
		
		
	},
	
	template: ` 
<div>
	<div class="topnav">
 	 	<a  style="float: left; "href="#/">Početna strana</a>
 	 	<a  href="#/registration">Registruj se</a>
 	 	<a  class="active" href="#/login">Uloguj se</a>
 	 
	</div>
	
	<div class="loginForma">
		<!--<form id="login2" class="login-form" @submit='login'>
		-->		<table>
					<tr>
						<td>Korisničko ime :</td>
						<td><input class="loginInput"   type="text"   ></td>
		
		    		</tr>
					<tr>
						<td>Lozinka :</td>
						<td><input class="loginInput"  ></td>
				
					</tr>
					
					<tr>
					
					<td colspan="2">
					<!-- <input v-on:click="login()"  class="button-3" type="submit" value="Uloguj se">
					-->
					<button v-on:click="login()">Log in</button>
					
					</td> 
					</tr>			
					</table>
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	, 
	mounted(){
		
	},
	
	methods: {
		login : function(event) {
		/*	if (event != undefined){
				event.preventDefault();
			}
			if (!this.isValidToLogIn()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}
		*/	
			axios
			.post("rest/login/login")
			.then(response => {
				router.push('/');
			})
	/*		.catch(function(error){
				alert('Neuspešno logovanje')
			})*/
		},
		
/*			isValidToLogIn : function() {
				
			if (this.user.username == '') {
				
				return false;
			}
			if (this.user.password == '') {
				
				return false;
			}

			return true;
		}
	*/	
		
	}
	
	
	
});