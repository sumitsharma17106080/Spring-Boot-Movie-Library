package com.movflix.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movflix.model.Movie;
import com.movflix.repository.MovieRepository;

@Controller
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	
	
	@PostMapping("/searchByMovieId")
	public String searchByMovieId(@RequestParam("movie_id") int movie_id, Model m){
		try {
		Movie movie=movieRepository.findById(movie_id).get();
		m.addAttribute("movie", movie);
		return "movie";
		}
		catch(Exception e) {
			m.addAttribute("message", " No Match !!Movie Id Does not Exist , Try Different Movie Id");
			return "error";
		}
		
	}
	@PostMapping("/searchByMovieName")
	public String searchByMovieName(@RequestParam("movie_name") String movie_name,Model m){
		try {
		Movie movie= movieRepository.findByMovieName(movie_name);
		m.addAttribute("movie", movie);
		if(movie!=null)return "movie";
		m.addAttribute("message", "No Match !Movie Name Does not Exist, Try Different Name");
		return "error";
		}
		catch(Exception e){
			m.addAttribute("message", "Exception No Match !1Movie Name Does not Exist, Try Different Name");
			return "error";
			
		}
		
	}
	
	@PostMapping("/searchByMovieCollection")
	public String searchByMovieCo(@RequestParam("movie_collection") Integer collection,Model m){
		
		 List<Movie> movieList= movieRepository.findByCollectionGreaterThan(collection);
		 m.addAttribute("movieList", movieList);
		 m.addAttribute("message", "No Match !! Collection Does not Achieve Till Now Any Movie , Try With Less Collection");
		 if(movieList.isEmpty()) return "error";
		 return "movielist";
		
	}
	@PostMapping("/login")
	public String logIn(@RequestParam("username") String username,@RequestParam("password") String password){
		if(username.equals("sumit@gmail.com") && password.equals("sumit")) {
			return "redirect:/admin.html";
		}
	return "redirect:/error.html";
		
	}

	@PostMapping("/addMovie")
	public String addMovie(@ModelAttribute Movie movie,Model m) {
		String message=null;
		Movie movie2= movieRepository.save(movie);
		if(movie2==null) {
			message="Funtionlity  is not available still in Progress";
			m.addAttribute("message", message);
			return "message";
		}
		message="Movie Add Successfully";
		m.addAttribute("message", message);
		return "message";
		
	}

	@PostMapping("/modifyMovie")
	public String modifyMovie(@ModelAttribute Movie movie,Model m) {
		Movie movie2=null;
		String message=null;
		try {
		movieRepository.deleteById(movie.getMovie_id());
		movie2=movieRepository.save(movie);
		if(movie2==null) {
			message="Modify Funtionlity  is not available still in Progress";
			m.addAttribute("message", message);
			return "error";
		}
		message="Movie Modify Successfully";
		m.addAttribute("message", message);
		return "message";
		}
		catch(Exception e) {
			message="Exception Modify Funtionlity  is not available still in Progress";
			m.addAttribute("message", message);
			return "error";
		}
	}

	@GetMapping("/all")
	public String searchAll(Model m){
		
		 List<Movie> movieList= (List<Movie>) movieRepository.findAll();
		 m.addAttribute("movieList", movieList);
		 m.addAttribute("message", "Database is Empty");
		 if(movieList.isEmpty()) return "error";
		 return "movielist";
		
	}
	

}
