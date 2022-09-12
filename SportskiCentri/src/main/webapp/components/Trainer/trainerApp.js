const AllFacilities = { template: '<all-facilities-manager></all-facilities-manager>' }
const FacilitieContent = { template: '<facilitie-content></facilitie-content>' }
const EditTrainer= { template: '<edit-trainer></edit-trainer>' }


const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: AllFacilities},
	     { path: '/facilitieContent', component: FacilitieContent},
	     { path: '/editTrainer', component: EditTrainer},
	    
	     
	  ]
});

var app = new Vue({
	router,
	el: '#trainer',
	data: {
		selectedFacilitie: {},
		newFacilitie : {},
		

		
		
	}
});
