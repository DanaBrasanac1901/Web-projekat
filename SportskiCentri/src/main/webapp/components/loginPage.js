Vue.component("login-page", {
	
	data: function(){
		return{
			user: {"username": "" , "password":""}
			
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
		<form id="login" class="login-form" @submit='login'>
				<table>
					<tr>
						<td>Korisničko ime :</td>
						<td><input class="loginInput" name ="userName" id ="userName" type="text"  v-model="user.username"  ></td>
		
		    		</tr>
					<tr>
						<td>Lozinka :</td>
						<td><input class="loginInput" name ="password" id ="password" type="password" v-model="user.password" ></td>
				
					</tr>
					
					<tr>
					
					<td colspan="2">
					 <input  class="button-3" type="submit" value="Uloguj se">
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
			if (event != undefined){
				event.preventDefault();
			}
			if (!this.isValidToLogIn()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}
			
			axios
			.post("rest/login", {username: this.user.username , password: this.user.password })
			.then(response => {
				router.push('/buyerHome');
			})
			.catch(function(error){
				alert('Neuspešno logovanje')
			})
		},
		
			isValidToLogIn : function() {
			if (this.user.username == '') {
				return false;
			}
			if (this.user.password == '') {
				return false;
			}

			return true;
		}
		
		
	}
	
	
	
});