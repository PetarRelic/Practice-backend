package it.eng.petarrelic.vezba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.eng.petarrelic.vezba.domain.Grad;
import it.eng.petarrelic.vezba.logging.Loggable;
import it.eng.petarrelic.vezba.repository.GradRepository;

@Service
public class GradServiceImpl implements GradService {

	@Autowired
	private GradRepository gradRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Loggable
	@Override
	public List<Grad> findAll() {
		return gradRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Loggable
	@Override
	public Grad findOne(int id) {
		return gradRepository.findById(id).orElseThrow(()-> new RuntimeException("Could not find the grad with id:" + id));
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Loggable
	@Override
	public Grad saveGrad(Grad grad) {
		return gradRepository.save(grad);
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Loggable
	@Override
	public void deleteGrad(int id) {
		gradRepository.deleteById(id);
	}

}
