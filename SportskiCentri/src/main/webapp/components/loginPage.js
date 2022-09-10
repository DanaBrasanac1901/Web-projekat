Vue.component("login-page", {

	data: function() {
		return {
			username: "",
			password: "",

		}


	},

	template: ` 
<div>
	
	<div class="loginForma">
		<form  id="login" class="login-form" @submit='login' method = "post">
				<table>
					<tr>
						<td><label for="username">Korisničko ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="username"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="password">Lozinka :</label></td>
						<td><input class="loginInput"  type="password" v-model="password" ></td>
				
					</tr>
					
				    </table>
						 <input  class="button-3" type="submit" value="Uloguj se">
				
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	,
	mounted() {

	},

	methods: {
		login: function(event) {
			if (event != undefined) {
				event.preventDefault();
			}
			if (!this.isValidToLogIn()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}


			axios
				.post("rest/login/login", { "username": this.username, "password": this.password })
				.then(response => {

					if (response.data == "buyer") {
						location.href = "buyer.html";
					} else if (response.data == "trainer") {
						alert("Trener je uspesno ulogovan")
						router.push('/trainerHome')

					} else if (response.data == "manager") {
						alert("Menadžer je uspesno ulogovan")
						router.push('/managerHome')
					} else if (response.data == "admin") {
						alert("Admin je uspesno ulogovan")
						//		router.push('/adminHome')					
						location.href = "admin.html";
					} else if (response.data == "banned") {
						alert("Korisnik je blokiran")
						this.username = "";
						this.password = "";
					} else if (response.data == "deleted") {
						alert("Korisnik je obrisan.")
						this.username = "";
						this.password = "";
					} else if (response.data == "wrong password") {
						alert("Pogresili ste sifru.")
						this.password = "";
					} else if (response.data == "not") {
						alert("Korisničko ime je nepostojeće.")
						this.username = "";
						this.password = "";
					}




				})


				.catch(function(error) {
					alert('Neuspešno logovanje')
				})
		},

		isValidToLogIn: function() {
			if (this.username == '') {
				return false;
			}
			if (this.password == '') {
				return false;
			}

			return true;
		}


	}



});