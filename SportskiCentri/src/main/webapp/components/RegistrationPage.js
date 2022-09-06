Vue.component("registration-page", {
	
	data: function(){
		return{
			username : "",
            password : "",
	        firstName: "",
	        lastName: "",
	        gender: "",
	        birthDate : ""
		     
			
		}
		
		
	},
	
	template: ` 
<div>
	<div class="topnav">
 	 	<a  style="float: left; "href="#/">Početna strana</a>
 	 	<a   class="active" href="#/registration">Registruj se</a>
 	 	<a   href="#/login" href="#/login">Uloguj se</a>
 	 
	</div>
	
	<div class="loginForma">
		<form id="login" class="login-form" @submit='register' method = "post">
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
						<td><label for="firstName">Ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="firstName"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="lastName">Korisničko ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="lastName"  ></td>
					<tr>
						<td><label for="gender">Pol :</label></td>
						<td><select v-model="gender" class="loginInput" >
									<option value="MALE">muški</option>
									<option value="FEMALE">ženski</option>
								</select>                                
						</td>
		
		    		</tr>
					<tr>
						<td><label for="birthDate">Datum rodjenja :</label></td>
						<td><input class="loginInput"  type="date" v-model="birthDate" ></td>
				
					</tr>
								
				    </table>
						 <input  class="button-3" type="submit" value="Registruj se">
				
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	, 
	mounted(){
		
	},
	
	methods: {
		register : function(event) {
			if (event != undefined){
				event.preventDefault();
			}
	/*		if (!this.isValidToLogIn()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}
		*/	
			alert(this.birthDate)
		/*	axios
		    .post("rest/login/login" , {"username" : this.username,
            "password": this.password,
	         "firstName" : this.firstName,
	         "lastName" : this.lastName,
	         "gender" : gender,
	         " birthDate"  : this.birthDate})
			.then(response=>alert(response.data))
		/*	.catch(function(error){
				alert('Neuspešno logovanje')
			})*/
		},
		
			isValidToRegister : function() {
			if (this.username == '') {
				return false;
			}
			if (this.password == '') {
				return false;
			}
			
			if (this.firstName == '') {
				return false;
			}
			
			if (this.lastName == '') {
				return false;
			}
			
			if (this.gender == '') {
				return false;
			}
			
			if (this.birthDate == '') {
				return false;
			}
			
			
			return true;
		}
		
	}
	
	
	
});