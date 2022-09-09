Vue.component("all-trainings", {
	data: function () {
		    return {
		      
		      trainings: null,
		      f : 0,
		      selectionSearch : '',
			  since : 0,
			  to : 0
		    }
		  
		  
		  },

	template: ` 
<div>

<div class='filterBar'>
					<table>
						<tr>
							<td><label for="since">Pretraga od:</label></td>
							<td><input type="number"  v-model="since" min="0" v-on:keyup="searchPrice"></td>
							<td><label for="to">do:</label></td>
							<td><input type="number"  v-model="to" v-on:keyup="searchPrice" min="0" ></td>
	
							<td>
							<select v-model="selectionSearch"  v-on:change="selectionChange">
									<option value="price">ceni</option>
									<option value="date">datumu</option>
									<option value="getFree">treninge bez doplate</option>
									
								</select>
							</td>
				
				<!--			<td>
							<td><label>Status</label><td>
							<select v-model="status"  v-on:change="statusOpen">
									<option value="OPEN">Otvoren</option>
									<option value="CLOSED">Zatvoren</option>
									<option value="ALL">Svi</option>
									
								</select>
							</td>
							<td><label>Tip objekta</label><td>
							<select v-model="type"  v-on:change="facilitieType">
									<option value="GYM">teretana</option>
									<option value="POOL">bazen</option>
									<option value="SPORT_CENTER">sportski centar</option>
									<option value="DANCING_STUDIO,">plesni studio</option>
									<option value="DOJO">dojo</option>
									<option value="ALL">Svi</option>
									
								</select>
							</td>
							<td><label>Sortiranje</label><td>
							<select v-model="sortParametar"  v-on:change="sortFunction">
									<option value="name">ime</option>
									<option value="location">lokacija</option>
									<option value="grade">ocena</option>									
							</select>
							</td>
							<select v-model="sortMode"  v-on:change="sortFunction">
									<option value="rastuce">rastuće</option>
									<option value="opadajuce">opadajuće</option>									
							</select>
							</td>
			-->	
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
		<th>IZMENI</th>
	</tr>

	<tr v-for="t in trainings" class="active-row">
		<td><img v-bind:src="t.picturePath" width="200px" Height="200px" alt="bilo sta"></td>	
		<td>{{t.name }}</td>
		<td>{{t.duration }}</td>
		<td>{{t.price }}</td>
		<td>{{t.description }}</td>
		<td>{{t.type }}</td>
		<td>{{t.trainerUsername }}</td>
		<td><button class="button-3" @click="EditTrainingPage(t)">Izmeni</button></td>
		
	</tr>
	</table>
		<button  v-on:click="newContent" class="button-3">Kreiraj novi sadržaj</button>                               
</div>
</div>
		  
`
	,
	 mounted(){
		this.getAll()			
 				
	},
	methods : {
		getAll : function(){
			axios
		 .get("rest/managers/getFacilitie")
		 .then(res=> {
			this.f=res.data;  
			this.getTrainings();
		 
		 
		 })
			
			
		},
		
		
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
	
	
	
			
	},
	EditTrainingPage : function(tr){
		app.selectedTraining = tr
		router.push('/editTraining')
		
	},searchPrice : function(event){
		 if (event != undefined){
				event.preventDefault();
			}
		
		if(this.to === ''){
			this.to=0
		}
		if(this.since === ''){
			this.since=0
		}
		
		
		 axios
		 	.get('rest/trainings/' + this.since + '/searchPrice/' + this.to)
			.then(response => {
				this.trainings = response.data
				
			})
						
		
	},
	
		selectionChange : function(event){
			if (event != undefined){
				event.preventDefault();
			}
			
			this.since = 0;
			this.to = 0
			
			if(this.selectionSearch ==='getFree'){
				axios
					.get('rest/trainings/searchFree')			
					.then(response => {
						this.trainings = response.data
				
			})
			
			}else{
				this.getAll()
			}
			
			
			
	}
	
	
	
	
	
	}
	
	
	

});