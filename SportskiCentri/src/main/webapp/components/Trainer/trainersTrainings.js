Vue.component("trainer-traings", {
	data: function () {
		    return {
		      
		      trainings: [],
		      
		  
		  }
		  },

	template: ` 
<div>


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
		 	
		 
		 })			
 				
	},

	
	

});