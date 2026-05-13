package com.wms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.Entity.StorageBin;

public interface StorageBinRepository extends JpaRepository<StorageBin, Long>{

	Optional<StorageBin> findById(Long binId);

	 
}
