Vue.component("manager-home", {

	template: ` 
<div>
	MANAGER
	

	</div>
</div>		  
`,mounted(){
	axios
		.get("rest/managers/getFacilitie")
		.then(res => {alert(res.data)
		
		})
}

});