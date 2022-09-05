package dto;

public class SearchDto {
	
	private String search;
	private String type;
	
	public SearchDto(String search, String type) {
		super();
		this.search = search;
		this.type = type;
	}
	public SearchDto() {
		
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	

}
