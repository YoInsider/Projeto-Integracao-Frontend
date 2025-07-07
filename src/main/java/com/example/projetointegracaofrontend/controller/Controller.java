package com.example.projetointegracaofrontend.controller;

import com.example.projetointegracaofrontend.dto.ProductCategoriesDTO;
import com.example.projetointegracaofrontend.dto.ProductLinesDTO;
import com.example.projetointegracaofrontend.dto.ProductModelsDTO;
import com.example.projetointegracaofrontend.service.ProductCategoriesService;
import com.example.projetointegracaofrontend.service.ProductLinesService;
import com.example.projetointegracaofrontend.service.ProductModelsService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    protected ComboBox<ProductLinesDTO> comboBoxLines;

    @FXML
    protected TitledPane tpModel;

    @FXML
    protected TreeView<String> modelTreeView;

    protected ProductLinesService linesService = new ProductLinesService();
    protected ProductCategoriesService categoryService = new ProductCategoriesService();
    protected ProductModelsService modelService = new ProductModelsService();

    public Controller() {}

    public Controller(ProductLinesService linesService, ProductCategoriesService categoryService, ProductModelsService modelService) {
        this.linesService = linesService;
        this.categoryService = categoryService;
        this.modelService = modelService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxProperties();
    }

    protected void comboBoxProperties() {
        List<ProductLinesDTO> linhas = linesService.getLines();
        comboBoxLines.getItems().addAll(linhas);

        comboBoxLines.setOnAction(event -> {
            tpModel.setDisable(false);
            ProductLinesDTO selected = comboBoxLines.getSelectionModel().getSelectedItem();

            treeViewStructure(selected);
        });
    }

    protected void treeViewStructure(ProductLinesDTO selected) {
        TreeItem<String> root = new TreeItem<>();
        modelTreeView.setRoot(root);
        modelTreeView.setShowRoot(false);

        List<ProductCategoriesDTO> categorias = categoryService.getCategories(selected.getId());
        for (ProductCategoriesDTO categoria : categorias) {
            TreeItem<String> category = new TreeItem<>(categoria.getName());
            root.getChildren().addAll(category);

            List<ProductModelsDTO> modelos = modelService.getModels(categoria.getId());
            for (ProductModelsDTO modelo : modelos) {
                TreeItem<String> model = new TreeItem<>(modelo.getName());
                category.getChildren().addAll(model);
            }
        }
    }
}