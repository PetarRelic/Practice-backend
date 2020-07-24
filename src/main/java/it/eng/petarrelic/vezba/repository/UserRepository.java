package it.eng.petarrelic.vezba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eng.petarrelic.vezba.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
}
