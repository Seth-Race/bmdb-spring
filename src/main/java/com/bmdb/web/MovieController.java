package com.bmdb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@GetMapping("/")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Movie get(@PathVariable Integer id) {
		return movieRepo.getById(id);
	}
	
	@PostMapping("/")
	public Movie add(@RequestBody Movie movie) {
		 return movieRepo.save(movie);
	}
	
	@PutMapping("/")
	public Movie update(@RequestBody Movie movie) {
		 return movieRepo.save(movie);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		movieRepo.deleteById(id);
	}
	
}
