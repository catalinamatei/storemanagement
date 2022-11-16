package com.storemanagement.app.storemanagement.Controllers;

import com.storemanagement.app.storemanagement.APIErrors.NoSuchProductExistsExeption;
import com.storemanagement.app.storemanagement.APIErrors.ProductAlreadyExistsExeption;
import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import com.storemanagement.app.storemanagement.Entities.Products;
import com.storemanagement.app.storemanagement.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ExceptionHandler(ProductAlreadyExistsExeption.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> handleProductExistsException(ProductAlreadyExistsExeption exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }
    @GetMapping
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping(path = "/{name}")
    public Products getProduct(@PathVariable String name){

        return productsService.getProductByName(name);
    }
    @ExceptionHandler(NoSuchProductExistsExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchProductExistsExeption exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @DeleteMapping(path = "/delete/{name}")
    public void deleteProduct(@PathVariable String name){
        productsService.deleteProductByName(name);
    }

    @PutMapping(path = "/update/{name}")
    public void updateProduct(@PathVariable String name, @RequestBody ProductsDTO productDTO){
        productsService.updateProduct(productDTO, name);
    }
}
