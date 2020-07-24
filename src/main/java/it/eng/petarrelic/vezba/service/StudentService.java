package it.eng.petarrelic.vezba.service;

import java.util.List;

import it.eng.petarrelic.vezba.domain.Student;

public interface StudentService {

	
	/**
	 * 
	 * @return all students
	 */
	public List<Student> findAll();
	
	/**
	 * 
	 * @param id
	 * @return one student
	 */
	public Student findOne(int id);
	
	/**
	 * 
	 * @param student
	 * @return saved student
	 */
	public Student saveStudent(Student student);
	
	/**
	 * 
	 * @param id
	 * deleting student
	 */
	public void deleteStudent(int id);
	
	/**
	 * 
	 * @param id
	 * @param student
	 * @return edited student
	 */
	public Student editStudent(int id, Student student);
}
