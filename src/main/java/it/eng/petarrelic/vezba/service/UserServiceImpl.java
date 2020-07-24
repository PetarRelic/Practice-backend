package it.eng.petarrelic.vezba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.eng.petarrelic.vezba.domain.User;
import it.eng.petarrelic.vezba.logging.Loggable;
import it.eng.petarrelic.vezba.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Loggable
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Loggable
	@Override
	public User findOne(int id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the user with id:" + id));
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Loggable
	@Override
	public User editUser(int id, User newUser) {
		return userRepository.findById(id).map(user -> {
			user.setUsername(newUser.getUsername());
			user.setPassword(newUser.getPassword());
			user.setEnabled(newUser.isEnabled());
			return userRepository.save(user);
		})
		.orElseGet(() -> {
			newUser.setId(id);
			return userRepository.save(newUser);
		});
	}
}
