Vue.component("welcome-page", {
	data: function () {
		    return {
		      type : '',
			  name : '',
		      facilitie: null
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
<!--		
							<td><input type="text" placeholder="Lokacija(grad)" v-model="adress"></td>
							<td>
								<select v-model="avgGrade">
									<option value="">Prosečna ocena</option>
									<option value="1">0-1</option>
									<option value="2">1-2</option>
									<option value="3">2-3</option>
									<option value="4">3-4</option>
									<option value="5">4-5</option>
								</select>
							</td>
							<td>
								<select v-model="restaurantStatus">
									<option value="">Status</option>
									<option value="Radi">Radi</option>
									<option value="Ne_radi">Ne radi</option>
								</select>
							</td>
-->					
			
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
	
	<tr v-for="f in facilitie" class="active-row">
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
 		axios
          .get('rest/facilities')
          .then(response => (this.facilitie = response.data))
	
	},
	methods:{
	 search : function(event){
		 if (event != undefined){
				event.preventDefault();
			}
		 if (!this.isValidToLogIn()) {
				return;
			}
		 axios
		 	.post('rest/facilities/search', {"type":this.type, "search":this.name})
			.then(response => (this.facilitie = response.data))
			
		
		},
		isValidToLogIn : function() {
			if (this.type == '') {
				return false;
			}

			return true;
		}
		
	}
	
});