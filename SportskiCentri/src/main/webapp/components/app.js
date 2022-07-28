const WelcomePage = { template: '<welcome-page></welcome-page>' }
const RegistrationPage = { template: '<registration-page></registration-page>' }
const LoginPage = { template: '<login-page></login-page>' }


const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	    { path: '/', component: WelcomePage},
	    { path: '/registration', component: RegistrationPage},
	    { path: '/login', component: LoginPage},
	    
	    
	  ]
});

var app = new Vue({
	router,
	el: '#sportShop'
});

