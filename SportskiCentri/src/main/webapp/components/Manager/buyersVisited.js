Vue.component("buyers", {
	data: function () {
		    return {
			buyers : [] ,
		 	 
		     
		     
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
	<tr v-for="u in buyers" class="active-row">
		<td>{{u.username }}</td>
		<td>{{u.firstName }}</td>
		<td>{{u.lastName }}</td>
		<td>{{u.gender}}</td>
		
	</tr>
	</table>
	
</div>		  
`
	,mounted(){
	/*	axios
			.get('rest/buyers/buyersInFacility')
			.then(res=>{this.buyers = res.data})
		*/
	},
	methods : {

	}
});