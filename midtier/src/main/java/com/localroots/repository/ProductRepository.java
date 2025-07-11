package com.localroots.repository;

import com.localroots.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByHarvest_HarvestId(Long harvestId);
    List<Product> findByNameContainingIgnoreCase(String name);
}
