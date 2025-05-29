package com.example.projetointegracaofrontend.model;

public enum ProductModels {
    CRONOS_6001_A("Cronos 6001-A", ProductCategories.CRONOS_OLD),
    CRONOS_6003("Cronos 6003", ProductCategories.CRONOS_OLD),
    CRONOS_7023("Cronos 7023", ProductCategories.CRONOS_OLD),
    CRONOS_6021L("Cronos 6021L", ProductCategories.CRONOS_L),
    CRONOS_6021LL("Cronos 6021L", ProductCategories.CRONOS_L),
    CRONOS_7023L("Cronos 7023L", ProductCategories.CRONOS_L),
    CRONOS_6001_NG("Cronos 6001-NG", ProductCategories.CRONOS_NG),
    CRONOS_6003_NG("Cronos 6003-NG", ProductCategories.CRONOS_NG),
    CRONOS_6021_NG("Cronos 6021-NG", ProductCategories.CRONOS_NG),
    CRONOS_6031_NG("Cronos 6031-NG", ProductCategories.CRONOS_NG),
    CRONOS_7021_NG("Cronos 7021-NG", ProductCategories.CRONOS_NG),
    CRONOS_7023_NG("Cronos 7023-NG", ProductCategories.CRONOS_NG),
    ARES_7021("ARES 7021", ProductCategories.ARES_TB),
    ARES_7031("ARES 7031", ProductCategories.ARES_TB),
    ARES_7023("ARES 7023", ProductCategories.ARES_TB),
    ARES_8023_15("ARES 8023 15", ProductCategories.ARES_THS),
    ARES_8023_200("ARES 8023 200", ProductCategories.ARES_THS),
    ARES_8023_2_5("ARES 8023 2,5", ProductCategories.ARES_THS);

    private final String nome;
    private final ProductCategories categories;

    ProductModels(String nome, ProductCategories categories) {
        this.nome = nome;
        this.categories = categories;
    }

    public String getNome() {
        return nome;
    }

    public ProductCategories getCategories() {
        return categories;
    }

    public String toString() {
        return nome;
    }
}
