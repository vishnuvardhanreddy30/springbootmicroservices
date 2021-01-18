package com.microservice.moviecatalogservice.model;

public class Movie {

	private String movieId;
	private String movieInfo, movieTitle;
	
	public Movie() {}
	
	public Movie(String movieId, String movieInfo, String movieTitle) {
		super();
		this.movieId = movieId;
		this.movieInfo = movieInfo;
		this.movieTitle = movieTitle;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	
	
	
}
