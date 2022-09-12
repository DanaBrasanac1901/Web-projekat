Vue.component("trainer-traings", {
	data: function () {
		    return {
		      
		      trainings: [],
		      filter : '',
		      allTrainings : []
		 		     
		  
		  }
		  },

	template: ` 
<div>
<div class='filterBar'>
					<table>
						<tr>

<select v-model="filter"  v-on:change="filterChanged">
									<option value="GROUP">grupni trening</option>
									<option value="PERSONAL">personalni trening</option>
									<option value="GYM">teretana</option>
									<option value="SAUNA">sauna</option>
									<option value="ALL">svi</option>
												
									
								</select>
							</td>
		
     					</tr>
			
					</table>

			</div>


<table class = "facilities"  style="margin-top:100px;">
	<tr >
		<th>SLIKA</th>
		<th>NAZIV</th>
		<th>TRAJANJE</th>
		<th>DOPLATA</th>		
		<th>OPIS</th>
		<th>TIP</th>
		<th>TRENER</th>
	
	</tr>

	<tr v-for="t in trainings" class="active-row">
		<td><img v-bind:src="t.picturePath" width="200px" Height="200px" alt="bilo sta"></td>	
		<td>{{t.name }}</td>
		<td>{{t.duration }}</td>
		<td>{{t.price }}</td>
		<td>{{t.description }}</td>
		<td>{{t.type }}</td>
		<td>{{t.trainerUsername }}</td>
		
		
	</tr>
	</table>
		                            
</div>
</div>
		  
`
	,
	 mounted(){
		axios
		 .get("rest/trainers/trainingsOfTrainer")
		 .then(res=> {
			this.trainings = res.data
		 	this.allTrainings = res.data
		 
		 })			
 				
	},
	methods :{
		
	filterChanged : function(event){
		 if (event != undefined){
				event.preventDefault();
				}
				if(this.filter=="ALL"){
						this.trainings = this.allTrainings
						
					
				}else{
					let filteredTrainings= [];
					
					for(tr of this.allTrainings){
						
						if(tr.type == this.filter)
						filteredTrainings.push(tr)
						
					}	
						
					this.trainings = filteredTrainings;
				}
		
	
		}
		
	}
});