package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import com.storemanagement.app.storemanagement.Entities.Products;
import com.storemanagement.app.storemanagement.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    public void addProduct(ProductsDTO productDto){
        Products product = Products.builder()
                .name(productDto.getName())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
        .build();
        productsRepository.save(product);
    }

    public List<Products> getAllProducts(){
       return productsRepository.findAll();
    }

    public Products getProductByName(String name){

        return productsRepository.findByName(name);
    }


}