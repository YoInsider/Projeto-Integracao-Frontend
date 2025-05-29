package com.example.projetointegracaofrontend.model;

public enum ProductCategories {
    CRONOS_OLD("Cronos Old", ProductLines.CRONOS),
    CRONOS_L("Cronos L", ProductLines.CRONOS),
    CRONOS_NG("Cronos-NG", ProductLines.CRONOS),
    ARES_TB("Ares TB", ProductLines.ARES),
    ARES_THS("Ares THS", ProductLines.ARES);

    private final String nome;
    private final ProductLines lines;

    ProductCategories(String nome, ProductLines lines) {
        this.nome = nome;
        this.lines = lines;
    }

    public String getNome() {
        return nome;
    }

    public ProductLines getLines() {
        return lines;
    }

    public String toString() {
        return nome;
    }
}
