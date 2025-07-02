package com.example.projetointegracaofrontend.dto;

public class ProductCategoriesDTO {
    private Long id;
    private String name;
    private ProductLinesDTO line;

    public ProductCategoriesDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductLinesDTO getLine() {
        return line;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLine(ProductLinesDTO line) {
        this.line = line;
    }

    public String toString() {
        return name;
    }
}
