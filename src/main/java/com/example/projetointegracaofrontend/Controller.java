package com.example.projetointegracaofrontend;

import com.example.projetointegracaofrontend.model.AresCategorys;
import com.example.projetointegracaofrontend.model.CronosCategorys;
import com.example.projetointegracaofrontend.model.ProductLines;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

        addCronos(selected, root);
        addAres(selected, root);
    }

    private static void addAres(String selected, TreeItem<String> root) {
        if (selected != null && !selected.isEmpty() && selected == ProductLines.ARES.getNome()) {
            for (AresCategorys categorys : AresCategorys.values()) {
                TreeItem<String> category = new TreeItem<>(categorys.getNome());
                root.getChildren().addAll(category);

                for (String models : categorys.getModels()) {
                    TreeItem<String> model = new TreeItem<>(models);
                    category.getChildren().addAll(model);
                }
            }
        }
    }

    private static void addCronos(String selected, TreeItem<String> root) {
        if (selected != null && !selected.isEmpty() && selected == ProductLines.CRONOS.getNome()) {
            for (CronosCategorys categorys : CronosCategorys.values()) {
                TreeItem<String> category = new TreeItem<>(categorys.getNome());
                root.getChildren().addAll(category);

                for (String models : categorys.getModels()) {
                    TreeItem<String> model = new TreeItem<>(models);
                    category.getChildren().addAll(model);
                }
            }
        }
    }
}