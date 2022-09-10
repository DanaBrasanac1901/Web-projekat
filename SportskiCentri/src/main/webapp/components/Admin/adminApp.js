const AllFacilities = { template: '<all-facilities></all-facilities>' }
const FacilitieContent = { template: '<facilitie-content></facilitie-content>' }




const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: AllFacilities},
	     { path: '/facilitieContent', component: FacilitieContent},
	    
	      
	   
	  ]
});

var app = new Vue({
	router,
	el: '#admin',
	data: {
		selectedFacilitie: {},

		
		
	}
});
