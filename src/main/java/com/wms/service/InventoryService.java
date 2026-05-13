package com.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.Entity.InventoryItem;
import com.wms.repository.InventoryRepository;

import jakarta.transaction.Transactional;
 

@Service
public class InventoryService {

	
	private final InventoryRepository repo;

    public InventoryService(
            InventoryRepository repo) {

        this.repo = repo;
    }

    // Save
    public InventoryItem saveItem(
            InventoryItem item) {

        return repo.save(item);
    }

    // Get All
    public List<InventoryItem> getAllItems() {

        return repo.findAll();
    }

    // Get By ID
    public InventoryItem getItemById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Inventory Item Not Found"));
    }

    // Update
    public InventoryItem updateItem(
            Long id,
            InventoryItem item) {

        InventoryItem old =
                repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Inventory Item Not Found"));

        old.setQuantity(item.getQuantity());

        return repo.save(old);
    }

    // Delete
    public void deleteItem(Long id) {

        repo.deleteById(id);
    }
}
