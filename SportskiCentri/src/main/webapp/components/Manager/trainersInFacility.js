Vue.component("trainers", {
	data: function () {
		    return {
			trainers : [] ,
		 	 
		     
		     
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
	</tr>
	<tr v-for="u in trainers" class="active-row">
		<td>{{u.username }}</td>
		<td>{{u.firstName }}</td>
		<td>{{u.lastName }}</td>
		<td>{{u.gender}}</td>
		
	</tr>
	</table>
	
</div>		  
`
	,mounted(){
		axios
			.get('rest/trainers/trainersInFacility')
			.then(res=>{this.trainers = res.data})
		
	},
	methods : {

	}
});