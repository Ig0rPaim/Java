package com.loja.products.DTO;

import com.loja.products.models.Category;

public record CategoryDTO(String name, String description) {
    public CategoryDTO(Category category){
        this(category.getName(),category.getDescription());
    }
}
