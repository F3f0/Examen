package com.example.Web_Scraping_1.utils;

import com.example.Web_Scraping_1.model.ProductMod;
import com.example.Web_Scraping_1.repository.ProductModRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner creatingData(ProductModRepository productRepository) {
        return (args) -> {

            JsoupLogic Scraper = new JsoupLogic();
            List<JsoupLogic.Product> products = Scraper.GetProducts();


            for (JsoupLogic.Product product : products) {
                /*System.out.println(
                        String.format("Product:\n%s\n%s\n\n", product.getName(), product.getPrice())
                );*/
                ProductMod productMod = ProductMod.builder().name(product.getName()).price(product.getPrice()).id(1L).build();

                productRepository.save(productMod);
            }

        };
    }
}