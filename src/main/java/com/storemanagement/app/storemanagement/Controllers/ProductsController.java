package com.storemanagement.app.storemanagement.Controllers;

import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import com.storemanagement.app.storemanagement.Entities.Products;
import com.storemanagement.app.storemanagement.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductsController {

    @Autowired
    ProductsService productsService;
    @PostMapping(path = "/add")
    public void addProduct(@RequestBody ProductsDTO productsDTO){
        productsService.addProduct(productsDTO);
    }

    @GetMapping
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }


}
