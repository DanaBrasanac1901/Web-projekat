Vue.component("all-facilities-admin", {
	data: function () {
		    return {
		      type : 'ALL',
		      searchType : '',
			  name : '',
		      facilities: null,
		      allFacilities: null,
		      searchedFacilities : null,
		      statusFacilities : null,
		      filteredFacilities : null,
		      
		      status: 'ALL',
		      sortParametar: '',
		      sortMode: 'opadajuce'
		      
		    }
		    },
	
	template: ` 
<div>
<!--PRETRAGA-->

	
			<div class='filterBar'>
				<form @submit='search'>
					<table>
						<tr>
							<td><label for="name">Pretraga :</label></td>
							<td><input type="text" v-model="name" v-on:keyup="search"></td>
	
							<td>
							<select v-model="searchType"  v-on:change="search">
									<option value="name">ime</option>
									<option value="type">tip objekta</option>
									<option value="location">lokacija</option>
									<option value="grade">ocena</option>
								</select>
							</td>
							<td>
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
							<td>
							<select v-model="sortMode"  v-on:change="sortFunction">
									<option value="rastuce">rastuće</option>
									<option value="opadajuce">opadajuće</option>									
							</select>
							</td>
				
     					</tr>
			
					</table>
				</form>

			</div>

<div>


<table class = "facilities" >
	<tr >
		<th>LOGO</th>
		<th>IME</th>
		<th>OCENA</th>
		<th>TIP OBJEKTA</th>
		<th>STATUS</th>
		<th>POČETAK RADNOG VREMENA</th>
		<th>KRAJ RADNOG VREMENA</th>
		<th>LOKACIJA</th>
		<th>DETALJNIJE</th>
		<th>OBRISI</th>
		
		
		
	</tr>
	<tr v-for="f in facilities" class="active-row">
		<td><img v-bind:src="f.logoPath" width="200px" Height="200px" alt="bilo sta"></td>	
		<td>{{f.name }}</td>
		<td>{{f.grade }}</td>
		<td>{{f.facType }}</td>
		<td>{{f.status }}</td>
		<td>{{f.start }}</td>
		<td>{{f.end }}</td>
		<td>{{f.location.adress.city }}     {{f.location.adress.street }}    {{f.location.adress.streetNumber}}</td>
		<td><button class="button-3" @click="openFacilityPage(f)">Detaljnije</button></td>
		<td><button class="button-3" @click="deleteFunction(f)">Obrisi</button></td>
		
		
	</tr>
	</table>
</div>
</div>
`
	, mounted(){
		
		
 		this.getAllFacilities();
		
	},
	methods:{
		getAllFacilities : function(){
		axios
          .get('rest/facilities')
          .then(response => {
	     		this.facilities = response.data
				this.facilities.sort((a, b) =>b.status.localeCompare(a.status));
				this.allFacilities = response.data;	
				this.statusFacilities = response.data;
		      	this.filteredFacilities = response.data;
			    this.searchedFacilities = response.data;
				})
		  
		
		
	},
		
		
	 search : function(event){
		 if (event != undefined){
				event.preventDefault();
			}		 
		//alert("Pretrazi")	
		 axios
		 	.post('rest/facilities/search', {"type":this.searchType, "search":this.name})
			.then(response => {
			//	this.facilities = response.data
			//	this.allFacilities = response.data
			//	this.statusFacilities = response.data;
		     // 	this.filteredFacilities = response.data	;
		     
			   	this.searchedFacilities = response.data	;
			//	alert(	this.searchedFacilities.length)
			//	alert(	this.filteredFacilities.length)
			//	alert(	this.statusFacilities.length)
				
				
				
				this.intersect()	
				
				
				})
				
			
				
		
			
	//		this.intersect();
			/*else if(this.selectionSearch==='name'){			
				for(r of this.allUsers){
						if(r.firstName.toUpperCase().trim().match(this.search.toUpperCase().trim())){
							
							filterUsers.push(r);
						}
				}
					this.users = filterUsers
			}else if(this.selectionSearch==='lastName'){			
				for(r of this.allUsers){
						if(r.lastName.toUpperCase().trim().match(this.search.toUpperCase().trim())){
							
							filterUsers.push(r);
						}
				}*/		
		
		},
		statusOpen : function(event){
							
		     if (event != undefined){
				event.preventDefault();
				}
				
			//	alert("status")
		
				if(this.status=="ALL"){			
					this.statusFacilities = this.allFacilities
					
				}else{
			//	alert("status")
			
				let filteredFacilities = [];
				for(fac of this.allFacilities){
					
					if(fac.status==this.status){	
						filteredFacilities.push(fac)
					}
									
				
				}
				this.statusFacilities = filteredFacilities;
			
				}
				
				this.intersect()	
		
	},
        facilitieType : function(event){
			
		//	alert("Tip")
			
		     if (event != undefined){
				event.preventDefault();
				}
				if(this.type=="ALL"){
					this.filteredFacilities = this.allFacilities
				}else{
				
			
				let filteredFacilities = [];
				for(fac of this.allFacilities){
					
					if(fac.facType==this.type){	
						filteredFacilities.push(fac)
					}
									
				
				}
				this.filteredFacilities = filteredFacilities
				}
				
				
				
				this.intersect()	
				
		
	},
	
	sortFunction : function(event){
		  if (event != undefined){
				event.preventDefault();
				}
				
		 if (this.sortMode == 'rastuce'){
                if (this.sortParametar == 'name'){
                 	this.facilities.sort((a, b) => a.name.localeCompare(b.name));
                }else if (this.sortParametar == 'location'){
													
                    this.facilities.sort((a, b) => a.location.adress.city.localeCompare(b.location.adress.city));
                }else if (this.sortParametar == 'grade'){
                    this.facilities.sort((a, b) => a.grade - b.grade);
                }
            }
            
         if (this.sortMode == 'opadajuce'){
                if (this.sortParametar == 'name'){
                 	this.facilities.sort((a, b) => b.name.localeCompare(a.name));
                }else if (this.sortParametar == 'location'){
													
                    this.facilities.sort((a, b) => b.location.adress.city.localeCompare(a.location.adress.city));
                }else if (this.sortParametar == 'grade'){
                    this.facilities.sort((a, b) => b.grade - a.grade);
                }
            }
              
           
          
            
		
	},
	
	openFacilityPage : function (fac) {
		app.selectedFacilitie = fac
		router.push('/facilitieContent')
		
		
		
	},
	deleteFunction : function (fac) {
	
		 axios
		   .post('rest/facilities/delete/'+ fac.id)
	   
	     location. reload()
	
	
	},
	intersect : function (){
			
		showFac  =[]
		filteredsorted = this.filteredFacilities.filter(value => this.statusFacilities.includes(value));
		for(r of filteredsorted){
			for(p of this.searchedFacilities){
				if(r.id == p.id){showFac.push(p)}
				
			}
			
		}
		
		this.facilities = showFac
		this.sortFunction();
	}
	


		
	}
	
});