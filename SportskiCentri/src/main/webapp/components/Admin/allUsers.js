Vue.component("all-users", {
	data: function () {
		    return {
		     users : [] ,
		 	allUsers : [],
		     search : '',
		     selectionSearch : '',
		     selectionFilter : '',
		     
		    }
		    },
	
	template: ` 
<div>

<div class='filterBar'>
					<table>
						<tr>
							<td><label for="search">Pretraga :</label></td>
							<td><input type="text"  v-model="search" min="0" v-on:keyup="searchFunction"></td>
							<td><label for="selectionSearch">po : </label></td>
							<select v-model="selectionSearch"  v-on:change="selectionFunction">
									<option value="name">imenu</option>
									<option value="lastName">prezimenu</option>
									<option value="username">korisničkom imenu</option>
									
								</select>
							</td>
							<select v-model="selectionFilter"  v-on:change="filterFunction">
									<option value="ALL">svi</option>
									<option value="buyer">kupac</option>
									<option value="trainer">trener</option>
									<option value="admin">administrator</option>
									<option value="manager">menadžer</option>
									
									
								</select>
							</td>
			<!--				<td><label for="selectionSort">Sortirati po:</label></td>
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
		-->
     					</tr>
			
					</table>

			</div>


<table class = "facilities" >
	<tr >
		<th>USERNAME</th>
    	<th>IME</th>
		<th>PREZIME</th>
		<th>POL</th>
		<th>ULOGA</th>
		
		
	</tr>
	<tr v-for="u in users" class="active-row">
		<td>{{u.username }}</td>
		<td>{{u.firstName }}</td>
		<td>{{u.lastName }}</td>
		<td>{{u.gende}}</td>
		<td>{{u.userRole }}</td>	
		
	</tr>
	</table>
</div>		  
`
	,mounted(){
		
			this.getAllUsers();


	},
	methods : {
		filterFunction : function(event){
			this.search = '';
			if (event != undefined){
				event.preventDefault();}
		
				if(this.selectionFilter =='ALL'){
					
					this.getAllUsers();
				}else if(this.selectionFilter =='buyer'){
						
					this.getAllBuyers();
				}else if(this.selectionFilter =='admin'){
						
					this.getAllAdmins();
				}else if(this.selectionFilter =='trainer'){
						
					this.getAllTrainers();
				}else if(this.selectionFilter =='manager'){
						
					this.getAllManagers();
				}
				
				
			
			
		}, 

		getAllUsers : function(){
			axios
				.get('rest/users')
				.then(res=>{
					this.users = res.data
					this.allUsers = res.data})
		},
		getAllBuyers : function(){
			axios
				.get('rest/buyers')
				.then(res=>{
					this.users = res.data
					this.allUsers = res.data})
		},getAllAdmins : function(){
		
			axios
				.get('rest/admins')
				.then(res=>{
					this.users = res.data
					this.allUsers = res.data})
		},getAllManagers : function(){
			axios
				.get('rest/managers')
				.then(res=>{
					this.users = res.data
					this.allUsers = res.data})
		},getAllTrainers : function(){
			axios
				.get('rest/trainers')
				.then(res=>{
					this.users = res.data
					this.allUsers = res.data})
		},
		
		
		selectionFunction : function(event){
				 if (event != undefined){
				event.preventDefault();}
				this.search = '';
				this.users = this.allUsers			
			
		},
		searchFunction: function(){
			filterUsers = [];
			
			
			if(this.selectionSearch == ''){
			    this.users = this.allUsers
			    return ;	
			}
			
			
			if(this.selectionSearch==='username'){			
				for(r of this.allUsers){
						if(r.username.toUpperCase().trim().match(this.search.toUpperCase().trim())){
							
							filterUsers.push(r);
						}
				}
					this.users = filterUsers
			}else if(this.selectionSearch==='name'){			
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
				}
					
			}
			
			this.users = filterUsers
			
			
			
		},

		
		
	}
});