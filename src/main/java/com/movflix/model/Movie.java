package com.movflix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@Column(name = "MovieID")
	private int movie_id;
	
	@Column(name = "MovieName")
	private String movieName;
	
	@Column(name = "Collection")
	private int collection;

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public Movie(int movie_id, String movieName, int collection) {
		super();
		this.movie_id = movie_id;
		this.movieName = movieName;
		this.collection = collection;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_name=" + movieName + ", collection=" + collection + "]";
	}
	
	
	
	

}
