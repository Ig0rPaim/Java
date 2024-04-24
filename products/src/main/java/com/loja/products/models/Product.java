package com.loja.products.models;

import com.loja.products.DTO.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "products")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;
    private Double price;
    private Long categoryId;

    public Product(ProductDTO productDTO){
        this.name = productDTO.name();
        this.descricao = productDTO.descricao();
        this.price = productDTO.price();
        this.categoryId = productDTO.categoryId();
    }


}
