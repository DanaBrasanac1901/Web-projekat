const AllFacilities = { template: '<all-facilities-manager></all-facilities-manager>' }
const FacilitieContent = { template: '<facilitie-content></facilitie-content>' }
const EditManager= { template: '<edit-manager></edit-manager>' }
const ManagersFacilitie= { template: '<managers-facilitie></managers-facilitie>' }


const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: AllFacilities},
	     { path: '/facilitieContent', component: FacilitieContent},
	     { path: '/editManager', component: EditManager},
	     { path: '/managersFacilitie', component: ManagersFacilitie},
	     
	  ]
});

var app = new Vue({
	router,
	el: '#manager',
	data: {
		selectedFacilitie: {},
		newFacilitie : {},
		

		
		
	}
});
