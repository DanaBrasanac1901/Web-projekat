Vue.component("edit-manager", {

	data: function() {
		return {
			manager : {
				username : ""
				
			}
		}


	},

	template: ` 
<div>
	
	<div class="loginForma">
		<form id="login"  class="login-form" @submit="edit" method = "post">
				<table>
					<tr>
						<td><label for="manager.username">Korisničko ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="manager.username"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="manager.password">Lozinka :</label></td>
						<td><input class="loginInput"  type="password" v-model="manager.password" ></td>
				
					</tr>
						<tr>
						<td><label for="manager.firstName">Ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="manager.firstName"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="manager.lastName">Prezime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="manager.lastName"  ></td>
					<tr>
						<td><label for="manager.gender">Pol :</label></td>
						<td><select v-model="manager.gender" class="loginInput" >
									<option value="MALE">muški</option>
									<option value="FEMALE">ženski</option>
								</select>                                
						</td>
		
		    		</tr>
					<tr>
						<td><label for="manager.birthDate">Datum rodjenja :</label></td>
						<td><input class="loginInput"  type="date" v-model="manager.birthDate" ></td>
				
					</tr>
								
				    </table>
						 <input  class="button-3" type="submit" value="Izmeni">
				
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	,
	mounted() {
		axios
			.get('rest/managers/logedManager')
			.then(res=>{this.manager = res.data; 
			}
		
			)
	},

	methods: {
		edit: function(event) {
			if (event != undefined) {
				event.preventDefault();
			}
				alert(this.manager.birthDate);


			if (!this.isValidToEdit()) {
				alert('Niste popunili sva polja neophodna za menadžera!');
				return;
			}


			axios
				.post("rest/managers/edit", {
					"username": this.manager.username,
					"password": this.manager.password,
					"firstName": this.manager.firstName,
					"lastName": this.manager.lastName,
					"gender": this.manager.gender,
					"birthDate": this.manager.birthDate
				})
				.then(response => {
					if (response.data == "uspesno") {
						alert("Uspesno ste izmenili managera.")
					} else if (response.data == "ima") {
						alert("Korisničko ime koje ste uneli već postoji.")
						this.username = ""

					}

				})


				.catch(function(error) {
					alert('Neuspešna izmena menadžera!')

				})


		},

		isValidToEdit: function() {
			if (this.manager.username == '') {
				return false;
			}
			if (this.manager.password == '') {
				return false;
			}

			if (this.manager.firstName == '') {
				return false;
			}

			if (this.manager.lastName == '') {
				return false;
			}

			if (this.manager.gender == '') {
				return false;
			}

			if (this.manager.birthDate == '') {
				return false;
			}


			return true;
		}

	}



});