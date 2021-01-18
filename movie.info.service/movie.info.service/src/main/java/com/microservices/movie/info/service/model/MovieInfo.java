package com.microservices.movie.info.service.model;

public class MovieInfo {

	private String id;
    private String title;
    private String overview;
    
    public MovieInfo() {}
    
	public MovieInfo(String id, String title, String overview) {
		super();
		this.id = id;
		this.title = title;
		this.overview = overview;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
    
	
}
