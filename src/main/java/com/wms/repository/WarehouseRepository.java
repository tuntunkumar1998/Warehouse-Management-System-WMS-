package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.Entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

	//Warehouse save(Warehouse warehouse);

}
