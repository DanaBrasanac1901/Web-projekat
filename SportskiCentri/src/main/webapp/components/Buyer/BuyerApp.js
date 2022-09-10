const AllFacilities = { template: '<all-facilities></all-facilities>' }



const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: AllFacilities},
	    
	    
	      
	   
	  ]
});

var app = new Vue({
	router,
	el: '#buyer',
	data: {
		selectedFacilitie: {},

		
		
	}
});
