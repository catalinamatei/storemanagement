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
            if(productDto.getName() == null || productDto.getCategory() == null|| productDto.getPrice() == null){
                logger.log(Level.WARNING, "POST Product: one or more elements was not assigned with a value and will be null");
            }
            productsRepository.save(product);
            logger.log(Level.INFO, "Product was added");
        }
        catch (Exception e){
            logger.log(Level.INFO, "Product was not added");
        }
    }

    public List<Products> getAllProducts(){
       return productsRepository.findAll();
    }

    public Products getProductByName(String name) {

        Products product = productsRepository.findByName(name);
        if(product == null){
            logger.log(Level.INFO, "Product with name " + name +" wasn't found");
        }
        else{
            logger.log(Level.INFO, "Product with name " + name + " was found");
        }
        return product;
    }

    public void deleteProductByName(String name){

        Products product = productsRepository.findByName(name);

        if(product == null){
            logger.log(Level.INFO, "Product with name " + name +" wasn't found");
        }
        else{
            productsRepository.delete(product);
            logger.log(Level.INFO, "Product with name " + name + " was deleted");
        }
    }

    public void updateProduct(ProductsDTO product, String name){

        Products updatedproduct = productsRepository.findByName(name);

        if( product.getPrice() == null){
            updatedproduct.setPrice(updatedproduct.getPrice());
            logger.log(Level.WARNING, "Product with name " + name + " has no price included in the body so the value of the field will be the same");
        }
        else{
            updatedproduct.setPrice(product.getPrice());
        }
        if( product.getCategory() == null){
            updatedproduct.setCategory(updatedproduct.getCategory());
            logger.log(Level.INFO, "Product with name " + name + " has no category included in the body so the value of the field will be the same");
        }
        else {
            updatedproduct.setCategory(product.getCategory());
        }
        if( product.getName() == null){
            updatedproduct.setName(updatedproduct.getName());
            logger.log(Level.INFO, "Product with name " + name + " has no name included in the body so value of the field will be the same");
        }
        else{
            updatedproduct.setName(product.getName());
        }

        productsRepository.save(updatedproduct);
        logger.log(Level.INFO, "Product with name " + name + " was updated");
    }
}
