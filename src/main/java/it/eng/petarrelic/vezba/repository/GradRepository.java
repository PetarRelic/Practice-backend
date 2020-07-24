package it.eng.petarrelic.vezba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eng.petarrelic.vezba.domain.Grad;

@Repository
public interface GradRepository  extends JpaRepository<Grad, Integer> {

}
