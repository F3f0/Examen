package com.example.Web_Scraping_1.repository;

import com.example.Web_Scraping_1.model.ProductMod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductModRepository extends JpaRepository<ProductMod, Long> {
    ProductMod findProductByName(String name);
    List<ProductMod> findProductModByNameContainsIgnoreCase(String name);
}
