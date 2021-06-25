package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
