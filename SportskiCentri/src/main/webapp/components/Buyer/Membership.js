Vue.component("membership", {
	data: function() {
		return {
			customer: { points: "" },
			activeMembership: { id: "", deleted: false, payDate: "", expirationDate: "", buyer: {}, status: true, numberOfEntrances: 100, remainingEntrances: 100, price: 0 },
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
                                        
                                        <td v-if="M.status=== false"> NEAKTIVNA</td>
                                        <td v-else>AKTIVNA</td>
                                    </tr>
                                </tbody>
                            </table>
                       
            </div>
       
    
    `,
	mounted() {



		axios.get("rest/buyers/memberships").then((result) => {
			console.log(result);
			this.allMemberships = result.data;
		});
		
		axios.get()

	},

	methods: {


		selectMembership(mem) {
			this.selectedMembership = mem;
		},
	},
});

