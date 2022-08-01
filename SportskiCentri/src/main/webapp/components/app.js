const WelcomePage = { template: '<welcome-page></welcome-page>' }
const RegistrationPage = { template: '<registration-page></registration-page>' }
const LoginPage = { template: '<login-page></login-page>' }
const AdminHome = { template: '<admin-home></admin-home>' }
const BuyerHome = { template: '<buyer-home></buyer-home>' }


const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	    { path: '/', component: WelcomePage},
	    { path: '/registration', component: RegistrationPage},
	    { path: '/login', component: LoginPage},
	    { path: '/adminHome', component: AdminHome}, 
	    { path: '/buyerHome', component: BuyerHome}, 
	   
	  ]
});

var app = new Vue({
	router,
	el: '#sportShop'
});

