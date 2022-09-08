Vue.component("all-trainings", {
	data: function () {
		    return {
		      
		      trainings: null,
		      f : 0
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
		<button  v-on:click="newContent" class="button-3">Kreiraj novi sadržaj</button>                               
</div>
		  
`
	,
	 mounted(){
		axios
		 .get("rest/managers/getFacilitie")
		 .then(res=> {
			this.f=res.data;  
			this.getTrainings();
		 
		 
		 })
		
 				
	},
	methods : {
		getTrainings : function (){
		
		axios
          .get('rest/trainings/' + this.f)
          .then(response => {
	     		this.trainings = response.data})
	
			
			
	},
	newContent : function(event){
		if (event != undefined){
				event.preventDefault();}
			
		router.push("/newTraining")
	
	
	
			
	}
	}
	
	
	
	
	

});