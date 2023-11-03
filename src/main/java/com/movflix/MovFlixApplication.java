package com.movflix;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movflix.model.Movie;
import com.movflix.repository.MovieRepository;

@SpringBootApplication
public class MovFlixApplication {
	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(MovFlixApplication.class, args);
	}
	@PostConstruct
	public void Initialize() {
		Movie m1=new Movie(1,"Tiger 1", 100);
		Movie m2=new Movie(2,"KGF 1", 200);
		Movie m3=new Movie(3,"Jawan", 300);
		Movie m4=new Movie(4,"King", 400);
		Movie m5=new Movie(5,"Godfather", 500);
		List<Movie> mlist=List.of(m1,m2,m3,m4,m5);
		movieRepository.saveAll(mlist);
		
	}

}
