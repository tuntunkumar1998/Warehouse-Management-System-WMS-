package com.wms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.Entity.StorageBin;
import com.wms.repository.StorageBinRepository;

@Service
public class StorageBinService {

	private final StorageBinRepository repo;

    public StorageBinService(
            StorageBinRepository repo) {

        this.repo = repo;
    }

    // Save
    public StorageBin saveBin(StorageBin bin) {

        return repo.save(bin);
    }

    // Get All
    public List<StorageBin> getAllBins() {

        return repo.findAll();
    }

    // Get By ID
    public StorageBin getBinById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Bin Not Found"));
    }

    // Update
    public StorageBin updateBin(
            Long id,
            StorageBin bin) {

        StorageBin old =
                repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Bin Not Found"));

        old.setBinCode(bin.getBinCode());

        return repo.save(old);
    }

    // Delete
    public void deleteBin(Long id) {

        repo.deleteById(id);
    }
	
}
