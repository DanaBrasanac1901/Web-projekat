const AllFacilities = { template: '<all-facilities-admin></all-facilities-admin>' }
const FacilitieContent = { template: '<facilitie-content></facilitie-content>' }
const AllUsers = { template: '<all-users></all-users>' }
const EditAdmin = { template: '<edit-admin></edit-admin>' }
const AddFacility = { template: '<add-facility></add-facility>' }
const NewManager = { template: '<new-manager></new-manager>' }
const NewTrainer = { template: '<new-trainer></new-trainer>' }




const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: AllFacilities},
	     { path: '/facilitieContent', component: FacilitieContent},
	     { path: '/allUsers', component: AllUsers},
		 { path: '/editAdmin', component: EditAdmin},
	     { path: '/addFacility', component: AddFacility},
	     { path: '/newManager', component: NewManager},
	     { path: '/newTrainer', component: NewTrainer},
	      
	   
	  ]
});

var app = new Vue({
	router,
	el: '#admin',
	data: {
		selectedFacilitie: {},
		newFacilitie : {},
		

		
		
	}
});
