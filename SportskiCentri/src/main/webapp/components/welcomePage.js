Vue.component("welcome-page", {


	
	
	template: ` 
<div>
	<div class="topnav">
 	 <a class="active" style="float: left; ">Početna strana</a>
 	 <a href="#/registration">Registruj se</a>
 	 <a href="#/login">Uloguj se</a>

	</div>
	
	<button v-on:click="lazar">lazar</button>
	
	
	
</div>		  
`
	, 
	methods : {
		lazar : function (){		
			axios
			.post('rest/login/lazar')
			.then(alert("Majmune"))
		}
	},
	mounted () {
        axios
          .get('rest/facilities/test')
          .then(response => (alert(response.data)))
    },
	
	
});