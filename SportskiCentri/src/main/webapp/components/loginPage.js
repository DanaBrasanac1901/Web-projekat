Vue.component("login-page", {
	
	data: function(){
		return{
			 username: "",
		     password: "",
			
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
		<form id="login" class="login-form" @submit='login' method = "post">
				<table>
					<tr>
						<td><label for="username">Korisničko ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="username"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="password">Lozinka :</label></td>
						<td><input class="loginInput"  type="password" v-model="password" ></td>
				
					</tr>
					
					<tr>
				    </table>
						 <input  class="button-3" type="submit" value="Uloguj se">
				
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	, 
	mounted(){
		
	},
	
	methods: {
		login : function(event) {
			if (event != undefined){
				event.preventDefault();
			}
	/*		if (!this.isValidToLogIn()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}
		*/	
			
			axios
		    .post("rest/login/login" , {"username":this.username, "password": this.password })
			.then(response=>alert(response.data))
		/*	.catch(function(error){
				alert('Neuspešno logovanje')
			})*/
		},
		
	/*		isValidToLogIn : function() {
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