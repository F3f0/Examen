package com.example.Web_Scraping_1.controller;

import com.example.Web_Scraping_1.dto.ProductRequest;
import com.example.Web_Scraping_1.error.CustomizedNotFoundException;
import com.example.Web_Scraping_1.model.ProductMod;
import com.example.Web_Scraping_1.repository.ProductModRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ProductModController {

    private final ProductModRepository productModRepository;

    @GetMapping
    public Iterable<ProductMod> getAllProducts() {
        return productModRepository.findAll();
    }


    @GetMapping("/{name}")
    public ProductMod getItemByName(@PathVariable String name)
            throws CustomizedNotFoundException {
        ProductMod productByName = productModRepository.findProductByName(name);
        if(productByName == null){
            throw new CustomizedNotFoundException(
                    "The item: " + name + " could not be found");
        }
        return productByName;
    }

    @PostMapping("/contain")
    public List<ProductMod>  getItemContainingName(@RequestBody ProductRequest product)
            throws CustomizedNotFoundException {
        List<ProductMod> productByName = productModRepository.findProductModByNameContainsIgnoreCase(product.name());
        if(productByName == null){
            throw new CustomizedNotFoundException(
                    "The item: " + product.name() + " could not be found");
        }
        return productByName;
    }

    @PostMapping
    public String addNewProduct(@RequestBody ProductMod productMod) {
        productModRepository.save(productMod);
        return "Saved";
    }
}
