Vue.component("admin-home", {
	
	data: function(){
		return{
			name : "",
            facilityType : "",
	        street: "",
	        streetNumber: "",
	        city: "",
	        postalCode: "",
	        logoPath : "",
	        managers: null,
	        selectedManager: ""
	        
			
		}
		
		
	},
	
	template: ` 
<div>
	<div class="topnav">
 	 	<a  style="float: left; "href="#/">Početna strana</a>
 	 	<a   class="active" >Registruj se</a>
 	 	<a    href="#/login">Uloguj se</a>
 	 
	</div>
	
	<div class="loginForma">
		<form id="login" class="login-form"  method = "post"  >
				<table >
					<tr>
						<td><label for="name">Ime objekta:</label></td>
						<td><input class="loginInput"  type="text"  v-model="name"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="facilityType">Tip objekta :</label></td>
						<td><select v-model="facilityType" class="loginInput" >
									<option value="GYM">teretana</option>
									<option value="POOL">bazen</option>
									<option value="SPORT_CENTER">sportski centar</option>
									<option value="DOJO">dojo</option>									
								</select>                                
						</td>
		
					</tr>
						<tr>
						<td><label for="street">Ulica :</label></td>
						<td><input class="loginInput"  type="text"  v-model="street"  ></td>
						
		    		</tr>
		    							
					<tr>
						<td><label for="streetNumber">Broj u ulici :</label></td>
						<td><input class="loginInput"  type="text"  v-model="streetNumber"  ></td>
						
		    		</tr>
		    							
					<tr>
						<td><label for="city">Grad :</label></td>
						<td><input class="loginInput"  type="text"  v-model="city"  ></td>
						
		    		</tr>
					<tr>
						<td><label for="poastalCode">Poštanski broj :</label></td>
						<td><input class="loginInput"  type="text"  v-model="postalCode"  ></td>
					</tr>
					<tr>
						<td><label for="logo">Logo :</label></td>
						<td><input class="loginInput"  type="file" name="logo" accept="images/*" @change="logoSelected"></td>
					</tr>
					<tr>	
						<td><label >Menadzer :</label></td>
						<td>
							<select id='man' v-model="selectedManager" @change="managerSelected($event)"   class="loginInput" >
									<option v-for="m in managers"  value="manager.username" >{{m.username}}</option>							
							</select>
							<button id="but"   v-on:click="newManager" class="button-3">Kreiraj novog menadžera</button>                                
			
					    </td>
					</tr>	
				    </table>
						 <input  class="button-3"  v-on:click="addFacility" type="button" value="Dodaj objekat">
				
					
		</form>
	
	</div>
	
	
	
	
</div>		  
`
	, 
	mounted(){
		this.managersLoad()			
			
	},
	
	methods: {
		managersLoad : function(){
		axios
			.get('rest/managers/free')
			.then(response=>{
				this.managers = response.data	
			if(this.managers.length <1 ){
				document.getElementById('but').style.display ="body"
				document.getElementById('man').style.display ="none"
				 
			}else{
				
			  document.getElementById('man').style.display ="body"
			  document.getElementById('but').style.display ="none"
				 
			}	
			})
			
			
		},
		
		
		
		addFacility : function(event) {
			if (event != undefined){
				event.preventDefault();
			}
			
			
			
			if (!this.isValidToAdd()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}
		
			
			
			axios
			.post('rest/managers/' + this.selectedManager)
			axios
		    .post("rest/facilities/createNew" , 
		    {
			"name" : this.name,
            "facilityType" : this.facilityType,
	        "street" : this.street,
	        "streetNumber" : this.streetNumber,
	        "city" : this.city,
	        "postalCode" : this.postalCode,
	        "logoPath" : this.logoPath			
						
			
		})
			.catch(function(error){
				alert('Neuspešno registrovanje!')
	
			})
			
			this.name =""
            this.facilityType = "";
	        this.street = "";
	        this.streetNumber = "";
	        this.city =  "";
	        this.postalCode = "";
	        this.logoPath  = "";
	        this.managers = null;
	        this.selectedManager = ""
	        
			if(this.managers != null){
			if(this.managers.length < 0 ){
				
				document.getElementById('but').style.display ="block"
				document.getElementById('man').style.display ="none"
			
				 
			}else{
				
			  document.getElementById('man').style.display ="block"
			  document.getElementById('but').style.display ="none"
				 
			}}else{
				document.getElementById('but').style.display ="block"
				document.getElementById('man').style.display ="none"
				
				
			}	
			alert("Uspešno ste dodali novi objekat.")
			
			
			
		},
		
			isValidToAdd : function() {
			if (this.name == '') {
				return false;
			}
			if (this.facilityType == '') {
				return false;
			}
			
			if (this.street == '') {
				return false;
			}
			
			if (this.streetNumber == '') {
				return false;
			}
			
			if (this.city == '') {
				return false;
			}
			
			if (this.postalCode == '') {
				return false;
			}
			if (this.selectedManager == '') {
				return false;
			}
			
			
			return true;
		
		},
		
		logoSelected : function(event) {
			this.logoPath =  "images\\" + event.target.files[0].name
		
			
		},
		
		managerSelected : function(event) {
			this.selectedManager = event.target.options[event.target.options.selectedIndex].text
		},
		
		newManager : function(){
			router.push('/newManager')
		}

		
	}
	
	
	
});