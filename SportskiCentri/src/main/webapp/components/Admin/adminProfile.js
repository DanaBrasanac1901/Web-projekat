Vue.component("edit-admin", {

	data: function() {
		return {
			admin : {
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
						<td><label for="admin.username">Korisničko ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="admin.username"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="admin.password">Lozinka :</label></td>
						<td><input class="loginInput"  type="password" v-model="admin.password" ></td>
				
					</tr>
						<tr>
						<td><label for="admin.firstName">Ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="admin.firstName"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="admin.lastName">Prezime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="admin.lastName"  ></td>
					<tr>
						<td><label for="admin.gender">Pol :</label></td>
						<td><select v-model="admin.gender" class="loginInput" >
									<option value="MALE">muški</option>
									<option value="FEMALE">ženski</option>
								</select>                                
						</td>
		
		    		</tr>
					<tr>
						<td><label for="admin.birthDate">Datum rodjenja :</label></td>
						<td><input class="loginInput"  type="date" v-model="admin.birthDate" ></td>
				
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
			.get('rest/admins/logedAdmin')
			.then(res=>{this.admin = res.data; 
	
			
			}
		
			)
	},

	methods: {
		edit: function(event) {
			if (event != undefined) {
				event.preventDefault();
			}
				


			if (!this.isValidToEdit()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}


			axios
				.post("rest/admins/edit", {
					"username": this.admin.username,
					"password": this.admin.password,
					"firstName": this.admin.firstName,
					"lastName": this.admin.lastName,
					"gender": this.admin.gender,
					"birthDate": this.admin.birthDate
				})
				.then(response => {
					if (response.data == "uspesno") {
						alert("Uspesno ste izmenili admina.")
					} else if (response.data == "ima") {
						alert("Korisničko ime koje ste uneli već postoji.")
						this.username = ""

					}

				})


				.catch(function(error) {
					alert('Neuspešno registrovanje!')

				})


		},

		isValidToEdit: function() {
			if (this.admin.username == '') {
				return false;
			}
			if (this.admin.password == '') {
				return false;
			}

			if (this.admin.firstName == '') {
				return false;
			}

			if (this.admin.lastName == '') {
				return false;
			}

			if (this.admin.gender == '') {
				return false;
			}

			if (this.admin.birthDate == '') {
				return false;
			}


			return true;
		}

	}



});