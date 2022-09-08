Vue.component("new-training", {
	
	data: function(){
		return{
			f : 0,
			name : '',
			trainingType : '',
			selectedTrainer : '',
			trainers : null,
		    description : '',
		    picturePath : '',
		    price : 0,
		    duration : 0
		    
		    
		    
		    
			
		}
		
		
	},
	
	template: ` 
<div>
	
	
	<div class="loginForma">
		<form id="login"  class="login-form" @submit='addTraining' method = "post">
				<table>
					<tr>
						<td><label for="name">Ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="name"  ></td>
		
		    		</tr>
					<tr>
						<td><label for="price">Doplata za trening :</label></td>
						<td><input class="loginInput"   type="number" min="1" step="any" v-model="price" ></td>
				
					</tr>
					<tr>
						<td><label for="duration">Vreme trajanja treninga :</label></td>
						<td><input class="loginInput"   type="number" min="1" step="any" v-model="duration" ></td>
				
					</tr>
					<tr>		
	    				<td><label for="trainingType">Tip treninga :</label></td>
							<td><select v-model="trainingType" class="loginInput" >
									<option value="GROUP">grupni trening</option>
									<option value="PERSONAL">personalni trening</option>
									<option value="GYM">teretana</option>
									<option value="SAUNA">sauna</option>									
							    </select>                                
						</td>
					</tr>
					<tr>
						<td><label >Menadzer :</label></td>
						<td>
							<select  v-model="selectedTrainer" @change="trainerSelected($event)"   class="loginInput" >
									<option v-for="t in trainers"  value="t.username" >{{t.username}}</option>							
							</select>
						</td>
						
					</tr>
					
					
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
		axios
			.get('rest/trainers')
			.then(res=>{
				this.trainers = res.data				
			})
		axios	
			.get("rest/managers/getFacilitie")
		 	.then(res=> {this.g = res.data})		
	},
	
	methods: {
		
			logoSelected : function(event) {
			this.pircturePath =  "images\\" + event.target.files[0].name
		
		},
			addTraining : function(event){
			if (event != undefined){
				event.preventDefault();
			}
				
				
			if (!this.isValidToAddTraining) {
				alert('Niste popunili sva neophodna polja za dodavanje treninga.');
				return;
			}	
				
			
			axios
		    .post("rest/trainers/" + this.f + "/new-content" , 
		    {
			"name" : this.name,
			"type" : 'trainingType',
			"trainerUsername" : this.trainingType,
		    "description" : this.description,
		    "picturePath" : this.picturePath,
		    "price" : this.price,
		    "duration" : this.duration 
			})
			.then(response=>{
			if(response.data  == "uspesno"){
				alert("Uspešno ste dodali novi sadržaj u objekat.")

	        	router.push("/allTrainings");
				
			}else if(response.data == "ima"){
				alert("Ime sadržaja koje ste  dodali već postoji.")
				this.name = ""
				
			}
			
			})
			
		
			.catch(function(error){
				alert('Neuspešno dodavanje novog sadržaja!')
	
			})
	
						
			},
			
			isValidToAddTraining : function() {
			if (this.name == '') {
				return false;
			}
			if (this.trainingType == '') {
				return false;
			}
			
			if (this.picturePath == '') {
				return false;
			}
					
			return true;
		}
		
	}
	
	
	
});