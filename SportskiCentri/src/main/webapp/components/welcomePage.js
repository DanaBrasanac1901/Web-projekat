Vue.component("welcome-page", {
		data: function () {
		    return {
		      facilities: null
		    }
		    },
	
	template: ` 
<div>
	<navigation-bar></navigation-bar>

<div>



<table class = "facilities" >
	<tr >
		<th>LOGO</th>
		<th>IME</th>
		<th>OCENA</th>
		<th>STATUS</th>
		<th>TIP OBJEKTA</th>
		<th>POCETAK RADNOG VREMENA</th>
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
, mounted () {
        axios
          .get('rest/facilities')
          .then(response => (this.facilities = response.data))
    },
 
	
});