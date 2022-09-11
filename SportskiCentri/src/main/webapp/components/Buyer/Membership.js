Vue.component("membership", {
	data: function() {
		return {
			customer: { points: "" },
			activeMembership: { id: "", deleted: false, payDate: "", expirationDate: "", buyer: "", status: true, numberOfEntrances: 100, remainingEntrances: 100, price: 0 },
			selectedMembership: { id: "", price: 0 },
			allMemberships: {},
			hasMembership: false,
			membershipType: ""


		};
	},

	template: ` 
  
            <div class="AllMemberships">
	            <h2>Članarine u ponudi</h2>
	            <table class="memberships">
	            
	                <th>Šifra članarine</th>
	                <th>Tip članarine</th>
	                <th>Početna cena</th>
	                 <th>Broj ulaza</th>
	                 <th>Status</th>
	                <tbody>
	                    <tr v-for="M in allMemberships"  v-on:click="selectMembership(M)"
	                    v-bind:class="{selectedMembershipClass : selectedMembership.id===M.id}">
	                       
	                        <td>{{M.id}}</td>
	                        
	                        <td v-if="M.membershipType === 'YEAR'">Godišnja</td>
	                        <td v-else-if="M.membershipType === 'MONTH'">Mesečna</td>
	                        <td v-else>Nedeljna</td>
	                        
	                        <td>{{M.price}}</td>
	                        <td>{{M.numberOfEntrances}}</td>
	                        
	                        <td v-if="activeMembership && M.id === activeMembership.id">AKTIVNA</td>
	                        <td v-else>NEAKTIVNA</td>
	                    </tr>
	                </tbody>
	            </table> 
	            <div v-if="hasMembership" class="activeMembership">
	                                        
	                <h2>Aktivna članarina</h2>
	                <div class= "paragrafi">
	                <p>
	                	Kod članarine: {{activeMembership.id}}
	                </p>
	                
	                <p>
	                    Datum izbora članarine:  {{getDate(activeMembership.payDate)}}
	                </p>
	                
	                <p>
	                    Datum isteka članarine: {{getDate(activeMembership.expirationDate)}}
	                </p>
	                
	                <p>
	               		 Cena: {{activeMembership.price}}
	                </p>
	                
	                <p>
	                	Preostali broj aktivnosti: {{activeMembership.remainingEntrances}} 
	                </p>
	               </div>
	            </div>
	       
	    	</div>
    `,
	mounted() {



		axios.get("rest/buyers/memberships").then((result) => {
			this.allMemberships = result.data;
		});

		axios.get("rest/buyers/active-membership").then((result) => {
			if (result.data) {
				this.activeMembership = result.data;
				this.hasMembership = true;
			}

		})

	},

	methods: {


		selectMembership(mem) {
			this.selectedMembership = mem;
		},
		
		getDate: function(datum) {
		
			console.log(datum);
			return new Date(datum.year, datum.monthValue-1, datum.dayOfMonth).toLocaleDateString("sr-RS");
			
		},

	},
});

