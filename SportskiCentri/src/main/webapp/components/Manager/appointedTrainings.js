Vue.component("appointed-trainings", {
	data: function () {
		    return {
		      
		      trainings: null,
		      allTrainings : null,
		      f : 0,
		      selectionSearch : '',
		      selectionSort : '',
		      sortMode : 'rastuce',
		      filter : 'ALL',
			  since : 0,
			  to : 0,
			  sinceDate : null,
			  toDate : null
		    }
		  
		  
		  },

	template: ` 
<div>

<div class='filterBar'>
					<table>
						<tr>
						<div v-if="selectionSearch==='price'">
							<td><label for="since">Pretraga od:</label></td>
							<td><input type="number"  v-model="since" min="0" v-on:keyup="searchPrice"></td>
							<td><label for="to">do:</label></td>
							<td><input type="number"  v-model="to" v-on:keyup="searchPrice" min="0" ></td>
						</div>
						<div v-else-if="selectionSearch==='date'">
							<td><label for="sinceDate">Pretraga od:</label></td>
							<td><input type="date"  v-model="sinceDate" min="0" v-on:keyup="searchPrice"></td>
							<td><label for="toDate">do:</label></td>
							<td><input type="date"  v-model="toDate" v-on:keyup="searchPrice" min="0" ></td>
						</div>
							<td><label for="selectionSearch">Pretraga od:</label></td>
							<td>
							<select v-model="selectionSearch"  v-on:change="selectionChange">
									<option value="price">ceni</option>
									<option value="date">datumu</option>
									<option value="getFree">treninge bez doplate</option>
									
								</select>
							</td>
							<td><label for="selectionSort">Sortirati po:</label></td>
							<td>
							<select v-model="selectionSort"  v-on:change="sortFunction">
									<option value="price">ceni</option>
									<option value="date">datumu</option>
									
							</select>
							</td>
							<td>	
								<select v-model="sortMode"  v-on:change="sortFunction">
									<option value="rastuce">rastuće</option>
									<option value="opadajuce">opadajuće</option>									
								</select>
							</td>
							<td><label>Filtriranje po :</label><td>
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
	     		this.trainings = response.data;
	     		this.allTrainings = response.data})
	
			
			
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
			
			
			
	},
	sortFunction : function(event){
		  if (event != undefined){
				event.preventDefault();
				}
		 if (this.sortMode == 'rastuce'){
                if (this.selectionSort == 'price'){
                 	this.trainings.sort(function(a, b){return a.price-b.price});;
                }/*else if (this.sortParametar == 'location'){
													
                    this.facilities.sort((a, b) => a.location.adress.city.localeCompare(b.location.adress.city));
                }else if (this.sortParametar == 'grade'){
                    this.trainings.sort((a, b) => a.grade - b.grade);
                }*/
            }
            
         if (this.sortMode == 'opadajuce'){
                if (this.selectionSort == 'price'){
                 	this.trainings.sort(function(a, b){return b.price-a.price});
                }/*else if (this.selectionSort == 'location'){
													
                    this.facilities.sort((a, b) => b.location.adress.city.localeCompare(a.location.adress.city));
                }else if (this.selectionSort == 'grade'){
                    this.facilities.sort((a, b) => b.grade - a.grade);
                }*/
            }
               
            
            
		
	},
	filterChanged : function(event){
		 if (event != undefined){
				event.preventDefault();
				}
				if(this.filter=="ALL"){
						this.getAll()
						
					
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