package com.wms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table (name = "products")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "Product Name Required")
    private String name;

    @NotBlank(message = "SKU Required")
    private String sku;

    
    private String barcode;

    @Min(value = 1,
            message = "Price must be greater than 0")
    private Double price;
	
}
