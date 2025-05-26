package com.example.projetointegracaofrontend.model;

public enum CronosCategorys {
    CRONOS_OLD("Cronos Old", new String[]{"Cronos 6001-A", "Cronos 6003", "Cronos 7023"}),
    CRONOS_L("Cronos L", new String[]{"Cronos 6021L", "Cronos 6021L", "Cronos 7023L"}),
    CRONOS_NG("Cronos-NG", new String[]{"Cronos 6001-NG", "Cronos 6003-NG", "Cronos 6021-NG", "Cronos 6031-NG", "Cronos 7021-NG", "Cronos 7023-NG"});

    private final String nome;
    private final String[] models;

    CronosCategorys(String nome, String[] models) {
        this.nome = nome;
        this.models = models;
    }

    public String getNome() {
        return nome;
    }

    public String[] getModels() {
        return models;
    }

    public String toString() {
        return nome;
    }
}