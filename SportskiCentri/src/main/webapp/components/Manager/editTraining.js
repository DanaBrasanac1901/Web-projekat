Vue.component("edit-training", {
	
	data: function(){
		return{
			t : app.selectedTraining,
			trainers : null
		    
		    
		    
		    
			
		}
		
		
	},
	
	template: ` 
<div>
	
	
	<div class="loginForma">
		<form id="login"  class="login-form" @submit='editTraining' method = "post">
				<table>
					<tr>
						<td><label for="name">Ime :</label></td>
						<td><input class="loginInput"  type="text"  v-model="t.name"  ></td>
		
		    		</tr>
		    		<tr>
						<td><label for="description">Opis :</label></td>
						<td><input class="loginInput"  type="text"  v-model="t.description"  ></td>
		
		    		</tr>
		<!-			<tr>
						<td><label for="price">Doplata za trening :</label></td>
						<td><input class="loginInput"   type="number"  step="any" v-model="t.price" ></td>
				
					</tr>
					<tr>
						<td><label for="duration">Trajanje treninga :</label></td>
						<td><input class="loginInput"   type="number"  step="any" v-model="t.duration" ></td>
				
					</tr>
					
					<tr>		
	    				<td><label for="trainingType">Tip treninga :</label></td>
							<td><select v-model="t.type" class="loginInput" >
									<option value="GROUP">grupni trening</option>
									<option value="PERSONAL">personalni trening</option>
									<option value="GYM">teretana</option>
									<option value="SAUNA">sauna</option>									
							    </select>                                
						</td>
					</tr>
					<tr>
						<td><label>Trener :</label></td>
						<td>
							<select  v-model="t.trainerUsername" @change="trainerSelected($event)"   class="loginInput" >
									<option v-for="t in trainers"  value="t.username" >{{t.username}}</option>							
							</select>
						</td>
						
					</tr>
					
					
					<tr>
						<td><label style="margin-top: 500px;" for="picturetPath">Slika :</label></td>
						<td>
						<tr>	<input  class="loginInput" style="margin-bottom: 0px;"   type="file" name="picturePath" accept="images/*"  @change="logoSelected" >
						</tr>
								<tr>
							<img   class="img-box"    v-bind:src="t.picturePath" alt="bilo sta">
						</tr>
				
						</td>
				
					</tr>	
				    </table>
						 <input  class="button-3" type="submit" value="Izmeni">
				
					
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
		
		
	},
	
	methods: {
		
		logoSelected : function(event) {
			this.t.picturePath  =  "images\\" + event.target.files[0].name
		
		
		},
		editTraining : function(event){
			if (event != undefined){
				event.preventDefault();
			}
				
				
			if (!this.isValidToAddTraining()) {
				alert('Obrisali ste polja neophodna za trening.');
				return;
			}	
			
			

			axios
		    .post("rest/trainings/edit" , 
		    {
			"id": this.t.id,
			"name" : this.t.name,
			"type" : this.t.type,
			"trainerUsername" : this.t.trainerUsername,
		    "description" : this.t.description,
		    "picturePath" : this.t.picturePath,
		    "price" : this.t.price,
		    "duration" : this.t.duration ,
		    "facilityId" : this.t.facilityId
			})
			.then(response=>{
			if(response.data  == "uspesno"){
				alert("Uspešno ste izmenili treining.")

	        	router.push("/allTrainings");
				
			}else if(response.data == "ima"){
				alert("Ime treninga koje ste  dodali već postoji.")
				this.name = ""
				
			}
			})
			
			
		},	 
		trainerSelected : function(event){
				
				this.t.trainerUsername = event.target.options[event.target.options.selectedIndex].text
				
    	},
			
		isValidToAddTraining : function() {
			if (this.t.name =='') {
				return false;
			}
			if (this.t.trainingType =='') {
				return false;
			}
			
			if (this.t.picturePath  =='') {
				return false;
			}
					
			return true;
		}
		
	   
	
	}
	
});