Vue.component("welcome-page", {
	data: function () {
		    return {
		      type : 'ALL',
			  name : '',
		      facilities: null,
		      allFacilities: null,
		      status: 'ALL',
		      sortParametar: '',
		      sortMode: 'opadajuce'
		      
		    }
		    },
	
	template: ` 
<div>
	<div class="topnav">
 	 <a class="active" style="float: left; ">Početna strana</a>
 	 <a href="#/registration">Registruj se</a>
 	 <a href="#/login">Uloguj se</a>

	</div>
<!--PRETRAGA-->

	
			<div class='filterBar'>
				<form @submit='search'>
					<table>
						<tr>
							<td><label for="name">Pretraga :</label></td>
							<td><input type="text" placeholder="Naziv" v-model="name" v-on:keyup="search"></td>
	
							<td>
							<select v-model="type"  v-on:change="search">
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
				this.allFacilities = response.data
		/*		if(this.status!="ALL"){
					this.statusOpen();
				}
				if(this.type!="ALL"){
					this.facilitieType();
				}
		*/			
			    
				})
		  
		
		
	},
		
		
	 search : function(event){
		 if (event != undefined){
				event.preventDefault();
			}
		 if (!this.isValid()) {
				return;
			}
		 axios
		 	.post('rest/facilities/search', {"type":this.type, "search":this.name})
			.then(response => {
				this.facilities = response.data
				this.allFacilities = response.data
/*				if(this.status!="ALL"){
					this.statusOpen();
				}
				if(this.type!="ALL"){
					this.facilitieType();
				}
				
				*/	
				})
						
		
		},
        facilitieType : function(event){
			
			
			
		     if (event != undefined){
				event.preventDefault();
				}
				if(this.type=="ALL"){
					if (!this.isValid()) {
						this.getAllFacilities()
						}else{
				     	this.search();
						}
					return;
				}
				
			
				let filteredFacilities = [];
				for(fac of this.allFacilities){
					
					if(fac.facType==this.type){	
						filteredFacilities.push(fac)
					}
									
				
				}
				
				this.facilities = filteredFacilities
				
				
		
	},
		statusOpen : function(event){
			
			
			
		     if (event != undefined){
				event.preventDefault();
				}
				if(this.status=="ALL"){
					if (!this.isValid()) {
						this.getAllFacilities()
						}else{
				     	this.search();
						}
					return;
				}
				
			
				let filteredFacilities = [];
				for(fac of this.allFacilities){
					
					if(fac.status==this.status){	
						filteredFacilities.push(fac)
					}
									
				
				}
				
				this.facilities = filteredFacilities
				
				
		
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
		router.push('/facilitieView')
		
		
		
	},
	

		isValid : function() {
			if (this.type == '') {
				return false;
			}

			return true;
		}
		
	}
	
});