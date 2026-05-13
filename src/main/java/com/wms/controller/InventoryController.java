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

import com.wms.Entity.InventoryItem;
import com.wms.service.InventoryService;


@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	private final InventoryService service;

    public InventoryController(
            InventoryService service) {

        this.service = service;
    }

    // CREATE
    @PostMapping
    public InventoryItem saveItem(
            @RequestBody InventoryItem item) {

        return service.saveItem(item);
    }

    // GET ALL
    @GetMapping
    public List<InventoryItem> getAllItems() {

        return service.getAllItems();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public InventoryItem getItemById(
            @PathVariable Long id) {

        return service.getItemById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public InventoryItem updateItem(
            @PathVariable Long id,
            @RequestBody InventoryItem item) {

        return service.updateItem(id, item);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteItem(
            @PathVariable Long id) {

        service.deleteItem(id);

        return "Inventory Item Deleted";
    }
}
