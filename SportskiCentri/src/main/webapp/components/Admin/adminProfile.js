Vue.component("edit-admin", {

	data: function() {
		return {
			username: "",
			password: "",
			firstName: "",
			lastName: "",
			gender: "",
			birthDate: null


		}


	},

	template: ` 
<div>
	
	<div class="loginForma">
		<form id="login"  class="login-form" @submit="registration" method = "post">
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
						<td><label for="lastName">Prezime :</label></td>
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
	mounted() {

	},

	methods: {
		registration: function(event) {
			if (event != undefined) {
				event.preventDefault();
			}



			if (!this.isValidToRegister()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}


			axios
				.post("rest/buyers/registration", {
					"username": this.username,
					"password": this.password,
					"firstName": this.firstName,
					"lastName": this.lastName,
					"gender": this.gender,
					"birthDate": this.birthDate
				})
				.then(response => {
					if (response.data == "uspesno") {
						alert("Uspesno ste se registrovali.")
						this.username = "",
							this.password = "",
							this.firstName = "",
							this.lastName = "",
							this.gender = "",
							this.birthDate = null

					} else if (response.data == "ima") {
						alert("Korisničko ime koje ste uneli već postoji.")
						this.username = ""

					}

				})


				.catch(function(error) {
					alert('Neuspešno registrovanje!')

				})


		},

		isValidToRegister: function() {
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