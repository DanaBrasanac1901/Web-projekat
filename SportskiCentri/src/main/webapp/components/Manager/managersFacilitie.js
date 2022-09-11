Vue.component("managers-facilitie", {
	data: function () {
		    return {
		      f : {},
		      trainings: null
		    }
		  },

	template: ` 
<div>
<div>


<table class = "facilities" style="margin-top:100px;">
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
	<tr >
		<td><img v-bind:src="f.logoPath" width="200px" Height="200px" alt="bilo sta"></td>	
		<td>{{f.name }}</td>
		<td>{{f.grade }}</td>
		<td>{{f.facType }}</td>
		<td>{{f.status }}</td>
		<td>{{f.start }}</td>
		<td>{{f.end }}</td>
		<td>{{f.location.adress.city }}{{f.location.adress.street }}{{f.location.adress.streetNumber}}</td>
		
	</tr>
	</table>
</div>


</div>
		  
`
	,
	 mounted(){
 		axios
          .get('rest/facilities/managersFacilitie')
          .then(response => {
	     		this.f = response.data})
		
	},
	
	
	
	
	

});