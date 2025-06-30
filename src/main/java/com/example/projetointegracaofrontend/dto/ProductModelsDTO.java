package com.example.projetointegracaofrontend.dto;

public class ProductModelsDTO {
    private Long id;
    private String name;
    private ProductCategoriesDTO category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategoriesDTO getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(ProductCategoriesDTO category) {
        this.category = category;
    }

    public String toString() {
        return name;
    }
}
