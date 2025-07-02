package com.example.projetointegracaofrontend.dto;

public class ProductLinesDTO {
    private Long id;
    private String name;

    public ProductLinesDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return name;
    }
}
