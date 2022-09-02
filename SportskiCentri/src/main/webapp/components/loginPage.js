Vue.component("login-page", {
	
	data: function(){
		return{
			
		}
		
		
	},
	
	template: ` 
<div>
	<div class="topnav">
 	 	<a  style="float: left; "href="#/">Početna strana</a>
 	 	<a  href="#/registration">Registruj se</a>
 	 	<a  class="active" href="#/login">Uloguj se</a>
 	 
	</div>
	
	<div class="loginForma">
		  <form @submit='login'>
				<table>
					<tr>
						<td>Korisničko ime  :</td>
						<td><input class="loginInput" type="text"  v-model="username"></td>
		
		    		</tr>
					<tr>
						<td >Lozinka :</td>
						<td><input class="loginInput"  type="password" v-model="password"></td>
				
					</tr>
				
					
					</table>
					
					
				    
				<input   class="button-3"  type="submit" value="Uloguj se">
				
						
					
		</form>
	
	</div>
		 
	
	
	
</div>		  
`
	, 
	mounted () {
        axios
          .get('rest/facilities/test')
          .then(response => (alert(response.data)))
    },
	
	methods: {
		login : function() {
			
		/*	if (!this.isValidToLogIn()) {
				alert('Niste popunili sva polja za prijavu');
				return;
			}
			*/
		//	event.preventDefault();
		
			axios
			.post("rest/login/login"/*,{username:this.username,password:this.password}*/)
		    .then(response=>{
		    	if(response.data != null){
					alert("Faca ti je sranje")
				}
				
				
			
		       }
		    )
/*				
			.catch(function(error){
				alert('Neuspešno logovanje')
			})*/ 
		},
		
			isValidToLogIn : function() {
				
			if (this.username =='') {
				
				return false;
			}
			if (this.password == '') {
				
				return false;
			}

			return true;
		}
		
		
	}
	
	
	
});