Vue.component("welcome-page", {
	data: function () {
		    return {
		      type : '',
			  name : '',
		      facilities: null,
		      allFacilities: null,
		      status: ''
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
				this.allFacilities = response.data
				
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
				if(this.status!="ALL"){
					this.statusOpen();
				}
				
				
				})
							
		
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
		isValid : function() {
			if (this.type == '') {
				return false;
			}

			return true;
		}
		
	}
	
});