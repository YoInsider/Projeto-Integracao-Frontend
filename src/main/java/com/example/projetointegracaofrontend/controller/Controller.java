package com.example.projetointegracaofrontend.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.model.*;
import org.example.repository.ProductCategoriesRepository;
import org.example.repository.ProductLinesRepository;
import org.example.repository.ProductModelsRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {
    @FXML
    private ComboBox<ProductLines> comboBoxLines;

    @FXML
    private TitledPane tpModel;

    @FXML
    private TreeView<String> modelTreeView;

    private final ProductLinesRepository linesRepo = new ProductLinesRepository();
    private final ProductCategoriesRepository categoriesRepo = new ProductCategoriesRepository();
    private final ProductModelsRepository modelsRepo = new ProductModelsRepository();

    private List<ProductCategories> getCategoriesByLine(ProductLines line) {
        return categoriesRepo.findAll()
                .stream()
                .filter(c -> c.getLine().getId() == line.getId())
                .collect(Collectors.toList());
    }

    private List<ProductModels> getModelsByCategory(ProductCategories category) {
        return modelsRepo.findAll()
                .stream()
                .filter(m -> m.getCategory().getId() == category.getId())
                .collect(Collectors.toList());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxProperties();
    }

    private void comboBoxProperties() {
        comboBoxLines.getItems().addAll(linesRepo.findAll());

        comboBoxLines.setOnAction(event -> {
            tpModel.setDisable(false);
            String selected = String.valueOf(comboBoxLines.getSelectionModel().getSelectedItem());
            treeViewStructure(selected);
        });
    }

    private void treeViewStructure(String selected) {
        TreeItem<String> root = new TreeItem<>();
        modelTreeView.setShowRoot(false);
        modelTreeView.setRoot(root);

        if (selected == null || selected.isEmpty()) return;

        for (ProductLines line : linesRepo.findAll()) {
            if (!selected.equals(line.getName())) continue;

            List<ProductCategories> categories = getCategoriesByLine(line);
            for (ProductCategories category : categories) {
                TreeItem<String> categoryItem = new TreeItem<>(category.getName());
                root.getChildren().addAll(categoryItem);

                List<ProductModels> models = getModelsByCategory(category);
                for (ProductModels model : models) {
                    TreeItem<String> modelItem = new TreeItem<>(model.getName());
                    categoryItem.getChildren().addAll(modelItem);
                }
            }
        }
    }
}