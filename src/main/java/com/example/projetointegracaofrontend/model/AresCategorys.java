package com.example.projetointegracaofrontend.model;

public enum AresCategorys {
    ARES_TB("Ares TB", new String[]{"ARES 7021", "ARES 7031", "ARES 7023"}),
    ARES_THS("Ares THS", new String[]{"ARES 8023 15", "ARES 8023 200", "ARES 8023 2,5"});

    private final String nome;
    private final String[] models;

    AresCategorys(String nome, String[] models) {
        this.nome = nome;
        this.models = models;
    }

    public String[] getModels() {
        return models;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome;
    }
}
