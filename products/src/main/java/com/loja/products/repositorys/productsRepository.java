package com.loja.products.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.products.models.Product;

public interface productsRepository extends JpaRepository<Product, Long>{
    
}
