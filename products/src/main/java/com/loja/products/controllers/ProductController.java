package com.loja.products.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.loja.products.DTO.ProductDTO;
import com.loja.products.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;
    @PostMapping()
    public ResponseEntity<ProductDTO> post(@RequestBody ProductDTO productDTO) {
        return service.post(productDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getByAll(){
        return service.getByAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(Long id){
        return service.getById(id);
    }
    
}
