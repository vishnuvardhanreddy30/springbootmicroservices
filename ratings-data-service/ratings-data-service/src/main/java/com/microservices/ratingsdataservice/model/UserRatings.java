package com.microservices.ratingsdataservice.model;

import java.util.List;

public class UserRatings {

	public UserRatings(){}
	private  List<Ratings> list;

	public List<Ratings> getList() {
		return list;
	}

	public void setList(List<Ratings> list) {
		this.list = list;
	}
}
