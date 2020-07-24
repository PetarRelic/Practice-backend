package it.eng.petarrelic.vezba.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eng.petarrelic.vezba.domain.User;
import it.eng.petarrelic.vezba.service.UserService;

@RestController
@RequestMapping(value = "/users", produces= {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserResource extends BaseResource {

	@Autowired
	private UserService userService;
	
	
	@GetMapping()
	public List<User> getAll(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User getOne(@PathVariable int id) {
		return userService.findOne(id);
	}
	
	@PutMapping("/{id}")
	public User editUser(@PathVariable int id, @RequestBody User newUser) {
		return userService.editUser(id, newUser);
	}
	
}
