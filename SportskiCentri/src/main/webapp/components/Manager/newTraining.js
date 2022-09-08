Vue.component("new-training", {
	
	data: function(){
		return{
			name : '',
			trainingType : '',
			trainerUsername : '',
		    description : '',
		    picturePath : '',
		    price : 0,
		    
		    
			
		}
		
		
	},
	
	template: ` 
<div>
	
	
	<div class="loginForma">
		<form id="login"  class="login-form" @submit='register' method = "post">
				<table>
					<tr>
						<td><label for="name">Ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="name"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="price">Lozinka :</label></td>
						<td><input class="loginInput"   type="number" min="1" step="any" v-model="price" ></td>
				
					</tr>
			
	    			<td><label for="trainingType">Tip objekta :</label></td>
						<td><select v-model="facilityType" class="loginInput" >
									<option value="GROUP">grupni trening</option>
									<option value="PERSONAL">personalni trening</option>
									<option value="GYM">teretana</option>
									<option value="SAUNA">sauna</option>									
								</select>                                
						</td>
	<!--			
					<tr>
						<td><label for="lastName">Prezime  :</label></td>
						<td><input class="loginInput"  type="text"  v-model="lastName"  ></td>
					<tr>
						<td><label for="gender">Pol :</label></td>
						<td><select v-model="gender" class="loginInput" >
									<option value="MALE">muški</option>
									<option value="FEMALE">ženski</option>
								</select>                                
						</td>
		
		    		</tr>
				-->
					<tr>
						<td><label for="picturePath">Slika :</label></td>
						<td><input class="loginInput"  type="file" name="picturePath" accept="images/*" @change="logoSelected"></td>
				
					</tr>
								
				    </table>
						 <input  class="button-3" type="submit" value="Dodaj">
				
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	, 
	mounted(){
		
	},
	
	methods: {
		
			logoSelected : function(event) {
			this.pircturePath =  "images\\" + event.target.files[0].name
		
		},
		
/*		register : function(event) {
			if (event != undefined){
				event.preventDefault();
			}
			
			
			
			if (!this.isValidToRegister()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}
			
			
			axios
		    .post("rest/managers/register" , {"username" : this.username,
            "password": this.password,
	         "firstName" : this.firstName,
	         "lastName" : this.lastName,
	         "gender" : this.gender,
	         "birthDate"  : this.birthDate})
			.then(response=>{
			if(response.data  == "uspesno"){
				alert("Uspesno ste dodali novog menadžera.")
				this.username = "",
            	this.password = "",
	        	this.firstName = "",
	       		this.lastName = "",
	        	this.gender = "",
	        	this.birthDate = null
	        	router.push("/adminHome");
				
			}else if(response.data == "ima"){
				alert("Korisničko ime koje ste uneli već postoji.")
				this.username = ""
				
			}
			
			})
			
		
			.catch(function(error){
				alert('Neuspešno registrovanje!')
	
			})
			
			
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
	*/	
	}
	
	
	
});