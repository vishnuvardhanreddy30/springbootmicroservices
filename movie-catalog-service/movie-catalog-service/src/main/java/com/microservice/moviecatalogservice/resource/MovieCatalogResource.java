package com.microservice.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.moviecatalogservice.model.CatalogItem;
import com.microservice.moviecatalogservice.model.Movie;
import com.microservice.moviecatalogservice.model.Ratings;
import com.microservice.moviecatalogservice.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	
	  @Autowired 
	  RestTemplate restTemplate;
	 
	/*
	 * @Autowired WebClient.Builder webClientBuilder;
	 */
	
	@RequestMapping("/{userId}")
	List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		//RestTemplate restTemplate = new RestTemplate();
		
		//Integer rate = restTemplate.getForObject("http://localhost:8087/ratings/foo", Ratings.class).getRatings();
		//String name = restTemplate.getForObject("http://localhost:8086/movies/foo", Movie.class).getName();
		//System.out.println("RestCall: "+name+" : "+rating);
		UserRatings ratings  = restTemplate.getForObject("http://ratings-data-service/ratings/userlist/"+userId, UserRatings.class);
		//return Collections.singletonList(new CatalogItem(name, userId, rating)); 
		//return Collections.singletonList(new CatalogItem("Data", userId, 4));
		return ratings.getList().stream().map(rating -> {
			
			Movie movie= restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			//Integer rate = webClientBuilder.build().get().uri("http://localhost:8087/ratings/foo").retrieve().bodyToMono(Ratings.class).block().getRatings();
			//String name = webClientBuilder.build().get().uri("http://localhost:8086/movies/foo").retrieve().bodyToMono(Movie.class).block().getName();
			return new CatalogItem(movie.getMovieTitle(), movie.getMovieInfo(), rating.getRatings());
		}).collect(Collectors.toList());
	}
	
	
	
}
