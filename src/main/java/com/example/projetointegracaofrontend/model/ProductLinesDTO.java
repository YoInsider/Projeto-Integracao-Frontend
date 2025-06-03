package com.example.projetointegracaofrontend.model;

public class ProductLinesDTO {

    private Long id;
    private String name;

    public ProductLinesDTO() {}

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

    public String toString() {
        return name;
    }
}
