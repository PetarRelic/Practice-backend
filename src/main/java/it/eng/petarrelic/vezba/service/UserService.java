package it.eng.petarrelic.vezba.service;

import java.util.List;

import it.eng.petarrelic.vezba.domain.User;


public interface UserService {

	/**
	 * 
	 * @return all users
	 */
	public List<User> findAll();
	
	/**
	 * 
	 * @param id
	 * @return one user
	 */
	public User findOne(int id);
	
	/**
	 * 
	 * @param id
	 * @param user
	 * @return edited user
	 */
	public User editUser(int id, User user);
	
}
