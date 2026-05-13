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

import com.wms.Entity.StorageBin;
import com.wms.service.StorageBinService;

@RestController
@RequestMapping("/api/bins")
public class StorageBinController {

	private final StorageBinService service;

    public StorageBinController(
            StorageBinService service) {

        this.service = service;
    }

    // CREATE
    @PostMapping
    public StorageBin saveBin( @RequestBody StorageBin bin) {

        return service.saveBin(bin);
    }

    // GET ALL
    @GetMapping
    public List<StorageBin> getAllBins() {

        return service.getAllBins();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public StorageBin getBinById(@PathVariable Long id) {

        return service.getBinById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public StorageBin updateBin(
            @PathVariable Long id,
            @RequestBody StorageBin bin) {

        return service.updateBin(id, bin);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBin(@PathVariable Long id) {

        service.deleteBin(id);

        return "Storage Bin Deleted";
    }
	
}
