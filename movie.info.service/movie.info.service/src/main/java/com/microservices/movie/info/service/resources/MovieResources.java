package com.microservices.movie.info.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.movie.info.service.model.Movie;
import com.microservices.movie.info.service.model.MovieInfo;

@RestController
@RequestMapping("/movies")
public class MovieResources {
	
	@Value(value = "${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		MovieInfo info =restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieInfo.class);
		
		System.out.println(info.getTitle());
		
		return new Movie(info.getId(), info.getOverview(), info.getTitle());
	}

}
