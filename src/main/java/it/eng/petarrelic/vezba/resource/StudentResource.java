package it.eng.petarrelic.vezba.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eng.petarrelic.vezba.domain.Student;
import it.eng.petarrelic.vezba.service.StudentService;

@RestController
@RequestMapping(value = "/api/student", produces= {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentResource extends BaseResource{
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/studenti")
	public List<Student> displayAll(){
		return studentService.findAll();
	}
	
	
	@GetMapping("/studenti/{id}")
	public Student displayOne(@PathVariable int id) {
		return studentService.findOne(id);
	}
	
	
	@PutMapping("/studenti/{id}")
	public Student editStudent(@PathVariable int id, @RequestBody Student newStudent) {
		return studentService.editStudent(id, newStudent);
	}
	
	
	@PostMapping("/studenti")
	public Student saveNewStudent(@RequestBody Student newStudent) {
		return studentService.saveStudent(newStudent);
	}
	
	
	@DeleteMapping("/studenti/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
	
}
