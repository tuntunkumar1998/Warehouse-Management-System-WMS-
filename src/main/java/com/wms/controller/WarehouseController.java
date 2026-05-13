package com.wms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.Entity.Warehouse;
import com.wms.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

	private final WarehouseService service;

    public WarehouseController(
            WarehouseService service) {

        this.service = service;
    }

    // CREATE
    @PostMapping
    public Warehouse saveWarehouse(@RequestBody Warehouse warehouse) {

        return service.saveWarehouse(
                warehouse);
    }

    // GET ALL
    @GetMapping
    public List<Warehouse> getAllWarehouses() {

        return service.getAllWarehouses();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Warehouse getWarehouseById(
            @PathVariable Long id) {

        return service.getWarehouseById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Warehouse updateWarehouse(
            @PathVariable Long id,
            @RequestBody Warehouse warehouse) {

        return service.updateWarehouse(
                id,
                warehouse);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteWarehouse(
            @PathVariable Long id) {

        service.deleteWarehouse(id);

        return "Warehouse Deleted Successfully";
    }
	
}
