Vue.component("trainers", {
	data: function () {
		    return {
			trainers : [] ,
		 	 
		     
		     
		    }
		    },
	
	template: ` 
<div>

<div class='filterBar'>
					
<table class = "facilities" >
	<tr >
		<th>USERNAME</th>
    	<th>IME</th>
		<th>PREZIME</th>
		<th>POL</th>
		<th>ULOGA</th>
		<th v-if = 'selectionFilter =="buyer"'>BROJ BODOVA</th>
		
		
		
	</tr>
	<tr v-for="u in trainers" class="active-row">
		<td>{{u.username }}</td>
		<td>{{u.firstName }}</td>
		<td>{{u.lastName }}</td>
		<td>{{u.gender}}</td>
		<td>{{u.userRole }}</td>	
		<td v-if = 'selectionFilter =="buyer"'>{{u.points }}</td>	
		
	</tr>
	</table>
</div>		  
`
	,mounted(){
		
	},
	methods : {



		
		
	}
});