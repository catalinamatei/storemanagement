package com.storemanagement.app.storemanagement.Controllers;

import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import com.storemanagement.app.storemanagement.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "products")
public class ProductsController {

    @Autowired
    ProductsService productsService;
    @PostMapping(path = "/add")
    public void addProduct(@RequestBody ProductsDTO productsDTO){
        productsService.addProduct(productsDTO);
    }


}
