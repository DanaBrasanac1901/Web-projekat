const AllFacilities = { template: '<all-facilities-manager></all-facilities-manager>' }
const FacilitieContent = { template: '<facilitie-content></facilitie-content>' }
const EditManager= { template: '<edit-manager></edit-manager>' }
const ManagersFacilitie= { template: '<managers-facilitie></managers-facilitie>' }
const Trainers = { template: '<trainers></trainers>' }
const Buyers = { template: '<buyers></buyers>' }
const AllTrainings = { template: '<all-trainings></all-trainings>' }
const NewTraining = { template: '<new-training></new-training>' }
const EditTraining = { template: '<edit-training></edit-training>' }
const AppointedTraining = { template: '<appointed-training></appointed-training>' }


const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: AllFacilities},
	     { path: '/facilitieContent', component: FacilitieContent},
	     { path: '/editManager', component: EditManager},
	     { path: '/managersFacilitie', component: ManagersFacilitie},
	     { path: '/trainers', component: Trainers},
	     { path: '/buyers', component: Buyers},
	     { path: '/allTrainings', component: AllTrainings},
	     { path: '/newTraining', component: NewTraining},
	     { path: '/editTraining', component: EditTraining},
	   	 { path: '/appointedTraining', component: AppointedTraining},
	   	 
	     
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
