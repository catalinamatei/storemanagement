package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductsServiceTest {
    @Autowired
    ProductsService productsService;

    @Test
    void addProductTest() throws Exception {
        ProductsDTO productDTO = new ProductsDTO("bauturi", "apa", 2L);
        productsService.addProduct(productDTO);
        assertEquals( "apa", productsService.getProductByName("apa").getName());
        assertEquals("bauturi", productsService.getProductByName("apa").getCategory());
        assertEquals(2L, productsService.getProductByName("apa").getPrice());
    }
}