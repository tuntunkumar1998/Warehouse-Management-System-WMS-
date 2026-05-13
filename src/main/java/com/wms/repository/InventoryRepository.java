package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.Entity.InventoryItem;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

}
