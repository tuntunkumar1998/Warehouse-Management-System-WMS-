package com.wms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.Entity.Warehouse;
import com.wms.repository.WarehouseRepository;

@Service
public class WarehouseService {

	    private final WarehouseRepository repo;

	    public WarehouseService(
	            WarehouseRepository repo) {

	        this.repo = repo;
	    }

	    // Save
	    public Warehouse saveWarehouse(
	            Warehouse warehouse) {

	        return repo.save(warehouse);
	    }

	    // Get All
	    public List<Warehouse> getAllWarehouses() {

	        return repo.findAll();
	    }

	    // Get By ID
	    public Warehouse getWarehouseById(Long id) {

	        return repo.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Warehouse Not Found"));
	    }

	    // Update
	    public Warehouse updateWarehouse(
	            Long id,
	            Warehouse warehouse) {

	        Warehouse old =
	                repo.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Warehouse Not Found"));

	        old.setWarehouseName(
	                warehouse.getWarehouseName());

	        old.setLocation(
	                warehouse.getLocation());

	        return repo.save(old);
	    }

	    // Delete
	    public void deleteWarehouse(Long id) {

	        repo.deleteById(id);
	    }
	
	
}
