package com.loja.products.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loja.products.DTO.ProductDTO;
import com.loja.products.models.Product;
import com.loja.products.repositorys.productsRepository;

@Service
public class ProductService {
    @Autowired
    productsRepository repository;

    public ResponseEntity<ProductDTO> post(ProductDTO productDTO){
        try{
            var product = new Product(productDTO);
            repository.save(product);
            return ResponseEntity.created(new URI("/products")).body(productDTO);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<ProductDTO> getById(Long id){
        try{
            var product = repository.findById(id);
            if(!product.isPresent()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(new ProductDTO(product.get()));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<ProductDTO>> getByAll(){
        try{
            var products = repository.findAll();
            if(products == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(products.stream().map(ProductDTO::new).toList());
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
