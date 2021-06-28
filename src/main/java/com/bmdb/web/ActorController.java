package com.bmdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/actors")
public class ActorController {

	@Autowired
	private ActorRepo actorRepo;
	
	@GetMapping("/")
	public Iterable<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Actor> get(@PathVariable Integer id) {
		return actorRepo.findById(id);
	}
	
	@PostMapping("/")
	public Actor add(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("/")
	public Actor update(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@DeleteMapping("/{id}")
	public Optional<Actor> delete(@PathVariable int id) {
		Optional<Actor> actor = actorRepo.findById(id);
		if (actor.isPresent()) {
			try {
				actorRepo.deleteById(id);
			} catch (DataIntegrityViolationException dive) {
				// catch exception when movie exists as FK for another table
				System.err.println(dive.getRootCause().getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Foreign Key Constraint Issue - Actor ID:" + id + " is referred to elsewhere.");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception caught during actor delete");
			}
		} else {
			System.err.println("Actor delete error - No actor found for ID:" + id);
		}
		return actor;
	}
	
}
