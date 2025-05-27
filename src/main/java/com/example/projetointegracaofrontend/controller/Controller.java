package com.example.projetointegracaofrontend.controller;

import com.example.projetointegracaofrontend.model.ProductCategories;
import com.example.projetointegracaofrontend.model.ProductLines;
import com.example.projetointegracaofrontend.model.ProductModels;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
//import org.example.model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox<ProductLines> comboBoxLines;

    @FXML
    private TitledPane model;

    @FXML
    private Accordion accord;

    @FXML
    private TitledPane lines;

    @FXML
    private TreeView<String> modelTreeView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboBoxLines.getItems().addAll(ProductLines.values());

   ;    comboBoxLines.setOnAction(event -> {
            model.setDisable(false);

            String selected = String.valueOf(comboBoxLines.getSelectionModel().getSelectedItem());
            treeViewStructure(selected);
        });
    }

    private void treeViewStructure(String selected) {
        TreeItem<String> root = new TreeItem<>();
        modelTreeView.setShowRoot(false);
        modelTreeView.setRoot(root);

        addProductLines(selected, root, ProductLines.ARES);
        addProductLines(selected, root, ProductLines.CRONOS);
    }

    private static void addProductLines(String selected, TreeItem<String> root, ProductLines line) {
        if (selected != null && !selected.isEmpty() && selected.equals(line.getNome())) {
            for (ProductCategories categories : ProductCategories.values()) {
                if (categories.getLines() == line) {
                    TreeItem<String> category = new TreeItem<>(categories.getNome());
                    root.getChildren().addAll(category);

                    for (ProductModels models : ProductModels.values()) {
                        if (models.getCategories() == categories) {
                            TreeItem<String> model = new TreeItem<>(models.getNome());
                            category.getChildren().addAll(model);
                        }
                    }
                }
            }
        }
    }
}