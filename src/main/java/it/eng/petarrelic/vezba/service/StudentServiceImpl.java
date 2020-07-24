package it.eng.petarrelic.vezba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.eng.petarrelic.vezba.domain.Student;
import it.eng.petarrelic.vezba.logging.Loggable;
import it.eng.petarrelic.vezba.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	@Loggable
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	// didn't put (propagation=Propagation.REQUIRED) because it is default one
	@Transactional
	@Loggable
	@Override
	public Student findOne(int id) {
		return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Could not find the student with id:" + id));
	}

	@Transactional
	@Loggable
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Transactional
	@Loggable
	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	@Transactional
	@Loggable
	@Override
	public Student editStudent(int id, Student newStudent) {
		return studentRepository.findById(id).map(student -> {
			student.setIme(newStudent.getIme());
			student.setPrezime(newStudent.getPrezime());
			student.setDatumRodjenja(newStudent.getDatumRodjenja());
			student.setGrad(newStudent.getGrad());
			return studentRepository.save(student);
		})
		.orElseGet(() -> {
			newStudent.setId(id);
			return studentRepository.save(newStudent);
		});
	}

}
