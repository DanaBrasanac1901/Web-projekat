Vue.component("all-users", {
	data: function () {
		    return {
		     users : null ,
		     allUsers : null
		    }
		    },
	
	template: ` 
<div>
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
		
			axios
				.get('rest/users')
				.then(res=>{this.users = res.data})
				//.then(res=>{alert(res.data.length )})
			


	},
	methods : {
		getAllUsers : function(){
			axios
				.get('rest/users')
				.then(res=>{
					this.users = res.data
					this.allUsers = res.data})
		},
		search: function(){
			this.filerUsers = [];
		
			for(r of this.allUsers){
				if(r.username.toUpperCase().trim().match(this.pretraga.naziv.toUpperCase().trim())){
						this.filterUsers.push(r);
				}
				
				this.users = filterUsers
			}
		},
		
		
		
		
	}
});