const BuyerHome = { template: '<buyer-home></buyer-home>' }
const Membership = { template: '<membership></membership>' }
const BuyerProfile = { template: '<buyer-profile></buyer-profile>' }
const TrainingHistory = { template: '<training-history></training-history>' }
const WelcomePage = { template: '<welcome-page></welcome-page>' }
const BuyerFacilityView = {template: '<facility-view></facility-view>'}

const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	     { path: '/', component: BuyerHome},
	     { path: '/membership', component: Membership},
	     { path: '/buyer-profile', component: BuyerProfile},
	     { path: '/training-history', component: BuyerProfile},
	     { path: '/welcome-page', component: WelcomePage},
	     { path: '/facility-view', component: BuyerFacilityView},
	      
	   
	  ]
});

var app = new Vue({
	router,
	el: '#buyer',
	data: {
		selectedFacilitie: {},

		
		
	}
});
