const AllFacilities = { template: '<all-facilities></all-facilities>' }
const FacilitieContent = { template: '<facilitie-content></facilitie-content>' }
const AllUsers = { template: '<all-users></all-users>' }
const EditAdmin = { template: '<edit-admin></edit-admin>' }




const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: AllFacilities},
	     { path: '/facilitieContent', component: FacilitieContent},
	     { path: '/allUsers', component: AllUsers},
		 { path: '/editAdmin', component: EditAdmin},
	      
	   
	  ]
});

var app = new Vue({
	router,
	el: '#admin',
	data: {
		selectedFacilitie: {},

		
		
	}
});
