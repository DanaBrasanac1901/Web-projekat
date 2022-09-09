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
							<td><select v-model="t.trainingType" class="loginInput" >
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
							<select  v-model="t.selectedTrainer" @change="trainerSelected($event)"   class="loginInput" >
									<option v-for="t in trainers"  value="t.username" >{{t.username}}</option>							
							</select>
						</td>
						
					</tr>
					
					
					<tr>
						<td><label for="picturePath">Slika :</label></td>
						<td><input  class="loginInput"  type="file" name="picturePath" accept="images/*" @change="logoSelected"></td>
				
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
	},
	
	methods: {
		editTraining : function(event){}
				
		
	},
			
			trainerSelected : function(event){
				
				this.selectedTrainer = event.target.options[event.target.options.selectedIndex].text
				
			},
	
	
	
});