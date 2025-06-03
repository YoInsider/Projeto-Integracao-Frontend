package com.example.projetointegracaofrontend.model;

public class ProductModelsDTO {

    private Long id;
    private String name;
    private ProductCategoriesDTO category;

    public ProductModelsDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoriesDTO getCategory() {
        return category;
    }

    public void setCategory(ProductCategoriesDTO category) {
        this.category = category;
    }

    public String toString() {
        return name;
    }
}
