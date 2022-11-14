package com.storemanagement.app.storemanagement.Repositories;

import com.storemanagement.app.storemanagement.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    Products findByName(String name);
}
