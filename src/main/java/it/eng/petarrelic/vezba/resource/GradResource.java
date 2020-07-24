package it.eng.petarrelic.vezba.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eng.petarrelic.vezba.domain.Grad;
import it.eng.petarrelic.vezba.service.GradService;

@RestController
@RequestMapping(value = "/api/grad", produces= {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GradResource extends BaseResource{

	@Autowired
	private GradService gradService;
	
	
	@GetMapping("/gradovi")
	public List<Grad> displayAll(){
		return gradService.findAll();
	}
	
	
	@GetMapping("/gradovi/{id}")
	public Grad displayOne(@PathVariable int id) {
		return gradService.findOne(id);
	}
	
	
	@PostMapping("/gradovi")
	public Grad saveNewGrad(@RequestBody Grad newGrad) {
		return gradService.saveGrad(newGrad);
	}
	
	
	@DeleteMapping("/gradovi/{id}")
	public void deleteGrad(@PathVariable int id) {
		gradService.deleteGrad(id);
	}
	
}
