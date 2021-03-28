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
import com.grupoasd.loan.management.system.model.Asset;
import com.grupoasd.loan.management.system.repository.AssetRepository;

/**
 * AssetController
 * 
 * @author Cristhian Andres Villada Garcia
 * @date 27/03/2021
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AssetController {
	
	@Autowired
	private AssetRepository assetRepository;

	@GetMapping("/assets")
	public List<Asset> getAllAsset() {
		return assetRepository.findAll();
	}

	@GetMapping("/assets/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable(value = "id") Long assetId)
			throws ResourceNotFoundException {
		
		Asset asset = assetRepository.findById(assetId)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + assetId));
		
		return ResponseEntity.ok().body(asset);
	}

	@PostMapping("/assets")
	public ResponseEntity<Asset> createAsset(@Validated @RequestBody Asset asset) {
		
		// TODO validar (nunca una fecha de baja debe ser superior a una fecha de compra)
		
		if (asset.getRetirementDate().getTime() < asset.getPurchaseDate().getTime()) {
//			new GlobalExceptionHandler().globleExcpetionHandler("Error: la fecha de dada de baja as anterior a la fecha de compra", 
//					"Corrija las fechas de compra y dada de baja");
			System.out.println("No va a ser insertado por Error: la fecha de dada de baja as anterior a la fecha de compra.");
			
			new ResourceNotFoundException("Error: la fecha de dada de baja as anterior a la fecha de compra.");
//			return ResponseEntity.unprocessableEntity();
		}
		
		final Asset updatedAsset = assetRepository.save(asset);
		
		return ResponseEntity.ok(updatedAsset);
	}

	@PutMapping("/assets/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable(value = "id") Long assetId,
			@Validated @RequestBody Asset assetDetails) throws ResourceNotFoundException {
		
		Asset asset = assetRepository.findById(assetId)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + assetId));

		asset.setSerial(assetDetails.getSerial());
		asset.setRetirementDate(assetDetails.getRetirementDate());
		
		final Asset updatedAsset = assetRepository.save(asset);
		
		return ResponseEntity.ok(updatedAsset);
	}

	@DeleteMapping("/assets/{id}")
	public Map<String, Boolean> deleteAsset(@PathVariable(value = "id") Long assetId)
			throws ResourceNotFoundException {
		
		Asset asset = assetRepository.findById(assetId)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + assetId));

		assetRepository.delete(asset);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}

}
