Vue.component("membership", {
	data: function () {
		    return {
		      type : 'ALL',
		      searchType : '',
			  name : '',
		      facilities: null,
		      allFacilities: null,
		      searchedFacilities : null,
		      statusFacilities : null,
		      filteredFacilities : null,
		      
		      status: 'ALL',
		      sortParametar: '',
		      sortMode: 'opadajuce'
		      
		    }
		    }
});