package com.example.projetointegracaofrontend.dto;

public class ProductModelsDTO {
    private Long id;
    private String name;
    private ProductCategoriesDTO category;

    public ProductModelsDTO() {}

    public ProductModelsDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductModelsDTO(Long id, String name, ProductCategoriesDTO category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

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
