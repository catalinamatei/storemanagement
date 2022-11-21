package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import com.storemanagement.app.storemanagement.Entities.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductsServiceTest {
    @Autowired
    ProductsService productsService;

    @Test
    public void findByNameTest(){
        String name = "para";
        Products product = productsService.getProductByName(name);
        assertEquals("para", product.getName());
        assertEquals("fructe", product.getCategory());
        assertEquals(1L, product.getPrice());
    }

    @Test
    void addProductTest() throws Exception {
        String name = "apa minerala";
        ProductsDTO productDTO = new ProductsDTO("bauturi", name, 2L);
        productsService.addProduct(productDTO);
        assertEquals( name, productsService.getProductByName(name).getName());
        assertEquals("bauturi", productsService.getProductByName(name).getCategory());
        assertEquals(2L, productsService.getProductByName(name).getPrice());
    }

    @Test
    void updateProductTest() throws Exception{
        String name = "para";
        ProductsDTO productDTO = new ProductsDTO("fructe", name, 1L);
        productsService.updateProduct(productDTO, "para ro");
        assertEquals( name, productsService.getProductByName(name).getName());
        assertEquals("fructe", productsService.getProductByName(name).getCategory());
        assertEquals(1L, productsService.getProductByName(name).getPrice());
    }
}