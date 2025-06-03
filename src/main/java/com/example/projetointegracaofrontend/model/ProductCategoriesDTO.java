package com.example.projetointegracaofrontend.model;

public class ProductCategoriesDTO {

    private Long id;
    private String name;
    private ProductLinesDTO line;

    public ProductCategoriesDTO() {}

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

    public ProductLinesDTO getLine() {
        return line;
    }

    public void setLine(ProductLinesDTO line) {
        this.line = line;
    }

    public String toString() {
        return name;
    }
}
