package com.loja.products.DTO;

import com.loja.products.models.Product;

public record ProductDTO(
    String name,
    String descricao,
    Double price,
    Long categoryId) {
    public ProductDTO(Product product){
        this(
        product.getName(), 
        product.getDescricao(), 
        product.getPrice(),
        product.getCategoryId());
    }
}
