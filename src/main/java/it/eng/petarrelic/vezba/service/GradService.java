package it.eng.petarrelic.vezba.service;

import java.util.List;

import it.eng.petarrelic.vezba.domain.Grad;

public interface GradService {

	/**
	 *  @return Sve gradove
	 */
	public List<Grad> findAll();
	
	/**
	 * 
	 * @param id
	 * @return jedan grad
	 */
	public Grad findOne(int id);
	
	/**
	 * 
	 * @param grad
	 * @return cuva grad
	 */
	public Grad saveGrad(Grad grad);
	
	/**
	 * 
	 * @param id
	 */
	public void deleteGrad(int id);
	
}
