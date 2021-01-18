package com.microservices.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ratingsdataservice.model.Ratings;
import com.microservices.ratingsdataservice.model.UserRatings;

@RestController
@RequestMapping("/ratings")
public class RatingsDataServiceResource {

	@RequestMapping("/{movieId}")
	public Ratings getMovieRatings(@PathVariable("movieId") String movieId) {
		return new Ratings(movieId,4);
	}
	
	@RequestMapping("/userlist/{userRatings}")
	public UserRatings getUserRatings(String userRatings){
		List<Ratings> list = Arrays.asList(new Ratings("100", 4), new Ratings("505", 3));
		UserRatings ratings= new UserRatings();
		ratings.setList(list);
		return ratings;
	}
}
