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
import com.grupoasd.loan.management.system.model.Area;
import com.grupoasd.loan.management.system.repository.AreaRepository;

/**
 * AreaController
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AreaController {

	@Autowired
	private AreaRepository areaRepository;

	@GetMapping("/areas")
	public List<Area> getAllAreas() {
		return areaRepository.findAll();
	}

	@GetMapping("/areas/{id}")
	public ResponseEntity<Area> getAreaById(@PathVariable(value = "id") Long areaId)
			throws ResourceNotFoundException {
		
		Area area = areaRepository.findById(areaId)
				.orElseThrow(() -> new ResourceNotFoundException("Area not found for this id :: " + areaId));
		
		return ResponseEntity.ok().body(area);
	}

	@PostMapping("/areas")
	public Area createArea(@Validated @RequestBody Area area) {
		return areaRepository.save(area);
	}

	@PutMapping("/areas/{id}")
	public ResponseEntity<Area> updateArea(@PathVariable(value = "id") Long areaId,
			@Validated @RequestBody Area areaDetails) throws ResourceNotFoundException {
		
		Area area = areaRepository.findById(areaId)
				.orElseThrow(() -> new ResourceNotFoundException("Area not found for this id :: " + areaId));

		area.setName(areaDetails.getName());
		area.setCity(areaDetails.getCity());
		area.setAddress(areaDetails.getAddress());
		
		final Area updatedArea = areaRepository.save(area);
		
		return ResponseEntity.ok(updatedArea);
	}

	@DeleteMapping("/areas/{id}")
	public Map<String, Boolean> deleteArea(@PathVariable(value = "id") Long areaId)
			throws ResourceNotFoundException {
		
		Area area = areaRepository.findById(areaId)
				.orElseThrow(() -> new ResourceNotFoundException("Area not found for this id :: " + areaId));

		areaRepository.delete(area);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
}
