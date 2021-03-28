/**
 * 
 */
package com.grupoasd.loan.management.system.controller;

import java.util.ArrayList;
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
import com.grupoasd.loan.management.system.model.Area;
import com.grupoasd.loan.management.system.model.Asset;
import com.grupoasd.loan.management.system.model.Loan;
import com.grupoasd.loan.management.system.model.Person;
import com.grupoasd.loan.management.system.model.dto.LoanDTO;
import com.grupoasd.loan.management.system.repository.AreaRepository;
import com.grupoasd.loan.management.system.repository.AssetRepository;
import com.grupoasd.loan.management.system.repository.LoanRepository;
import com.grupoasd.loan.management.system.repository.PersonRepository;

/**
 * LoanController
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class LoanController {

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private AssetRepository assetRepository;
	

	@GetMapping("/loans")
	public List<LoanDTO> getAllLoan() {
		
		List<LoanDTO> listLoanDTO = new ArrayList<>();
		
		for (Loan loan : loanRepository.findAll()) {
			
			LoanDTO loanDTO = new LoanDTO();
			loanDTO.setId(loan.getId());
			loanDTO.setPerson_id(loan.getPerson() != null ? loan.getPerson().getId() : null);
			loanDTO.setArea_id(loan.getArea() != null ? loan.getArea().getId() : null);
			loanDTO.setAsset_id(loan.getAsset().getId());
			
			listLoanDTO.add(loanDTO);
		}
		
		return listLoanDTO;
	}

	@GetMapping("/loans/{id}")
	public ResponseEntity<LoanDTO> getLoanById(@PathVariable(value = "id") Long loanId)
			throws ResourceNotFoundException {
		
		Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id :: " + loanId));
		
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setId(loan.getId());
		loanDTO.setPerson_id(loan.getPerson() != null ? loan.getPerson().getId() : null);
		loanDTO.setArea_id(loan.getArea() != null ? loan.getArea().getId() : null);
		loanDTO.setAsset_id(loan.getAsset().getId());
		
		return ResponseEntity.ok().body(loanDTO);
	}

	@PostMapping("/loans")
	public Loan createAsset(@Validated @RequestBody LoanDTO loanDTO) {
		
		Loan loan = new Loan();

		if (loanDTO.getPerson_id() != null) {
			Person person = personRepository.findById(loanDTO.getPerson_id()).orElse(null);
			loan.setPerson(person);
		}
		
		if (loanDTO.getArea_id() != null) {
			Area area = areaRepository.findById(loanDTO.getArea_id()).orElse(null);
			loan.setArea(area);
		}
		
		if (loanDTO.getAsset_id() != null) {
			Asset asset = assetRepository.findById(loanDTO.getAsset_id()).orElse(null);
			loan.setAsset(asset);
		}
		
		return loanRepository.save(loan);
	}

	@PutMapping("/loans/{id}")
	public ResponseEntity<LoanDTO> updateLoan(@PathVariable(value = "id") Long loanId,
			@Validated @RequestBody LoanDTO loanDetailsDTO) throws ResourceNotFoundException {
		
		Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id :: " + loanId));

		if (loanDetailsDTO.getPerson_id() != null) {
			Person person = personRepository.findById(loanDetailsDTO.getPerson_id()).orElse(null);
			loan.setPerson(person);
		}
		
		if (loanDetailsDTO.getArea_id() != null) {
			Area area = areaRepository.findById(loanDetailsDTO.getArea_id()).orElse(null);
			loan.setArea(area);
		}
		
		if (loanDetailsDTO.getAsset_id() != null) {
			Asset asset = assetRepository.findById(loanDetailsDTO.getAsset_id()).orElse(null);
			loan.setAsset(asset);
		}
		
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setId(loan.getId());
		loanDTO.setPerson_id(loan.getPerson() != null ? loan.getPerson().getId() : null);
		loanDTO.setArea_id(loan.getArea() != null ? loan.getArea().getId() : null);
		loanDTO.setAsset_id(loan.getAsset().getId());
		
		loanRepository.save(loan);
		
		return ResponseEntity.ok(loanDTO);
	}

	@DeleteMapping("/loans/{id}")
	public Map<String, Boolean> deleteLoan(@PathVariable(value = "id") Long loanId)
			throws ResourceNotFoundException {
		
		Loan loan = loanRepository.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id :: " + loanId));

		loanRepository.delete(loan);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
}
