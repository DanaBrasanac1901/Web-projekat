const WelcomePage = { template: '<welcome-page></welcome-page>' }
const RegistrationPage = { template: '<registration-page></registration-page>' }
const LoginPage = { template: '<login-page></login-page>' }
const AdminHome = { template: '<admin-home></admin-home>' }
const BuyerHome = { template: '<buyer-home></buyer-home>' }
const TrainerHome = { template: '<trainer-home></trainer-home>' }
const ManagerHome = { template: '<manager-home></manager-home>' }
const FacilitieView = { template: '<facilitie-view></facilitie-view>' }


const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	    { path: '/', component: WelcomePage},
	    { path: '/registration', component: RegistrationPage},
	    { path: '/login', component: LoginPage},
	    { path: '/adminHome', component: AdminHome}, 
	    { path: '/buyerHome', component: BuyerHome}, 
	    { path: '/trainerHome', component: TrainerHome}, 
	    { path: '/managerHome', component: ManagerHome}, 
	    { path: '/facilitieView', component: FacilitieView}, 
	   
	  ]
});

var app = new Vue({
	router,
	el: '#sportShop',
	data: {
		selectedFacilitie: {}
		
		
	}
});

