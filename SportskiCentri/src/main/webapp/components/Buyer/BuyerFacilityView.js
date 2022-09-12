Vue.component("facility-view", {
	data: function() {
		return {
			f: app.selectedFacilitie,
			trainings: null,
			chosenTraining: {id : 0 },
		}
	},

	template: ` 
<div>
<div>


<table class = "facilities" style="margin-top:100px;">
	<tr >
		<th>LOGO</th>
		<th>IME</th>
		<th>OCENA</th>
		<th>TIP OBJEKTA</th>
		<th>STATUS</th>
		<th>POČETAK RADNOG VREMENA</th>
		<th>KRAJ RADNOG VREMENA</th>
		<th>LOKACIJA</th>
	
	</tr>
	<tr >
		<td><img v-bind:src="f.logoPath" width="200px" Height="200px" alt="bilo sta"></td>	
		<td>{{f.name }}</td>
		<td>{{f.grade }}</td>
		<td>{{f.facType }}</td>
		<td>{{f.status }}</td>
		<td>{{f.start }}</td>
		<td>{{f.end }}</td>
		<td>{{f.location.adress.city }}{{f.location.adress.street }}{{f.location.adress.streetNumber}}</td>
		
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

	<tr v-for="t in trainings" v-on:click="selectTraining(t)" 
	v-bind:class="{activeRowClass : chosenTraining.id===t.id}">
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
		  
`
	,
	mounted() {
		axios
			.get('rest/trainings/' + app.selectedFacilitie.id)
			.then(response => {
				this.trainings = response.data
			});



	},

	methods: {

		selectTraining(t) {
			this.chosenTraining = t;
			
			axios.post('rest/buyers/trainings/' + this.chosenTraining.id).then((result)=>{
				console.log(result)
				if(result === "NEMA CLANARINU"){
					alert("Prvo morate kupiti članarinu");
				}else if(result === "USPESAN TRENING"){
					alert("Trening uspešno zabeležen");
				}else{
					alert("Članarina vam je istekla");
				}
			
				
			});
			
			
		},


	},

});