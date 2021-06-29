package com.bmdb.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Credit;

public interface CreditRepo extends CrudRepository<Credit, Integer> {

	// Custom query - get all credits by movie id
	List<Credit> findAllByMovieId(int id);
	// List<Credit> findAllByMovie(Movie movie); <--also works
	
	// Custom query - get all credits by actor id
	List<Credit> findAllByActorId(int id);

	// Custom query - get all credits by rating
	List<Credit> findAllByMovieRating(String rating);
	
	// Custom query - get all credits by actor name
	List<Credit> findAllByActorName(String name);
}
