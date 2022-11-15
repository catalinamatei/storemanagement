package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import com.storemanagement.app.storemanagement.Entities.Products;
import com.storemanagement.app.storemanagement.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;
    Logger logger = Logger.getLogger(ProductsService.class.getName());

    public void addProduct(ProductsDTO productDto){
        try {
            Products product = Products.builder()
                    .name(productDto.getName())
                    .category(productDto.getCategory())
                    .price(productDto.getPrice())
                    .build();
            if(productDto.getName().equals("null") || productDto.getCategory().equals("null") || productDto.getPrice() == null){
                logger.log(Level.WARNING, "one or more elements was not assigned with a value and will be null");
            }
            productsRepository.save(product);
        } catch (Exception e){
            logger.log(Level.INFO, "Product was not added");
        }

        logger.log(Level.INFO, "Product was added");

    }

    public List<Products> getAllProducts(){
       return productsRepository.findAll();
    }

    public Products getProductByName(String name){

        return productsRepository.findByName(name);
    }

    public void deleteProductByName(String name){
         productsRepository.delete(productsRepository.findByName(name));
    }

    public void updateProduct(ProductsDTO product, String name){

        Products updatedproduct = productsRepository.findByName(name);
        updatedproduct.setCategory(product.getCategory());
        updatedproduct.setName(product.getName());
        updatedproduct.setPrice(product.getPrice());
        productsRepository.save(updatedproduct);

    }

}
