/**
 * 
 */
package com.grupoasd.loan.management.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.loan.management.system.exception.ResourceNotFoundException;
import com.grupoasd.loan.management.system.model.Person;
import com.grupoasd.loan.management.system.repository.PersonRepository;

/**
 * EmployeeController
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 26/03/2021
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		
		return ResponseEntity.ok().body(person);
	}

	@PostMapping("/persons")
	public Person createPerson(@Validated @RequestBody Person person) {
		return personRepository.save(person);
	}

	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
			@Validated @RequestBody Person personDetails) throws ResourceNotFoundException {
		
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

		person.setIdType(personDetails.getIdType());
		person.setIdNumber(personDetails.getIdNumber());
		person.setNames(personDetails.getNames());
		person.setSurnames(personDetails.getSurnames());
		person.setBrithDate(personDetails.getBrithDate());
		person.setAddress(personDetails.getAddress());
		
		final Person updatedPerson = personRepository.save(person);
		
		return ResponseEntity.ok(updatedPerson);
	}

	@DeleteMapping("/persons/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

		personRepository.delete(person);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

}
