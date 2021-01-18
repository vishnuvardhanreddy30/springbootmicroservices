package com.microservice.moviecatalogservice.model;

import java.util.List;

public class UserRatings {
	
	UserRatings(){}

	List<Ratings> list;

	public List<Ratings> getList() {
		return list;
	}

	public void setList(List<Ratings> list) {
		this.list = list;
	}
}
