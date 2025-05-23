package com.example.projetointegracaofrontend;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox<String> comb;

    @FXML
    private TitledPane model;

    @FXML
    private Accordion accord;

    @FXML
    private TitledPane lines;

    @FXML
    private TreeView<String> tree;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comb.getItems().addAll("Cronos", "Ares");

        comb.setOnAction(event -> {
            model.setDisable(false);

            String selected = comb.getSelectionModel().getSelectedItem();
            if (selected != null && !selected.isEmpty() && selected == "Cronos") {
                TreeItem<String> root = new TreeItem<>();
                tree.setShowRoot(false);
                tree.setRoot(root);

                TreeItem<String> category1 = new TreeItem<>("Cronos Old");
                TreeItem<String> category2 = new TreeItem<>("Cronos L");
                TreeItem<String> category3 = new TreeItem<>("Cronos‑NG");

                root.getChildren().addAll(category1, category2, category3);

                category1.getChildren().addAll(
                        new TreeItem<>("Cronos 6001‑A"),
                        new TreeItem<>("Cronos 6003"),
                        new TreeItem<>("Cronos 7023")
                );
                category2.getChildren().addAll(
                        new TreeItem<>("Cronos 6021L"),
                        new TreeItem<>("Cronos 6021L"),
                        new TreeItem<>("Cronos 7023L")
                );
                category3.getChildren().addAll(
                        new TreeItem<>("Cronos 6001‑NG"),
                        new TreeItem<>("Cronos 6003‑NG"),
                        new TreeItem<>("Cronos 6021‑NG"),
                        new TreeItem<>("Cronos 6031‑NG"),
                        new TreeItem<>("Cronos 7021‑NG"),
                        new TreeItem<>("Cronos 7023‑NG")
                );
            }
            if (selected != null && !selected.isEmpty() && selected == "Ares") {
                TreeItem<String> root = new TreeItem<>();
                tree.setShowRoot(false);
                tree.setRoot(root);

                TreeItem<String> category1 = new TreeItem<>("Ares TB");
                TreeItem<String> category2 = new TreeItem<>("Ares THS");
                root.getChildren().addAll(category1, category2);

                category1.getChildren().addAll(
                        new TreeItem<>("ARES 7021"),
                        new TreeItem<>("ARES 7031"),
                        new TreeItem<>("ARES 7023")
                );
                category2.getChildren().addAll(
                        new TreeItem<>("ARES 8023 15"),
                        new TreeItem<>("ARES 8023 200"),
                        new TreeItem<>("ARES 8023 2,5")
                );
            }
        });

        model.setOnMouseClicked(event -> {
            accord.setPrefHeight(326);
        });

        lines.setOnMouseClicked(event -> {
            accord.setPrefHeight(100);
        });
    }
}