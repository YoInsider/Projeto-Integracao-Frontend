package com.example.projetointegracaofrontend.controller;

import com.example.projetointegracaofrontend.dto.ProductCategoriesDTO;
import com.example.projetointegracaofrontend.dto.ProductLinesDTO;
import com.example.projetointegracaofrontend.dto.ProductModelsDTO;
import com.example.projetointegracaofrontend.service.ProductCategoriesService;
import com.example.projetointegracaofrontend.service.ProductLinesService;
import com.example.projetointegracaofrontend.service.ProductModelsService;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    private ProductLinesService linesService;

    @Mock
    private ProductCategoriesService categoryService;

    @Mock
    private ProductModelsService modelService;

    @InjectMocks
    private Controller controller;

    @BeforeAll
    static void initToolKit() {
        new JFXPanel();
    }

    @Test
    public void testInitialize() throws Exception {
        testComboBoxProperties();
        controller.initialize(null, null);
    }

    @Test
    public void testComboBoxProperties() throws Exception {
        List<ProductLinesDTO> lines = Arrays.asList(
                new ProductLinesDTO(1L, "Line A"),
                new ProductLinesDTO(2L, "Line B")
        );

        when(linesService.getLines()).thenReturn(lines);

        controller = new Controller(linesService, categoryService, modelService);

        ComboBox<ProductLinesDTO> comboBox = new ComboBox<>();
        Field comboField = Controller.class.getDeclaredField("comboBoxLines");
        comboField.setAccessible(true);
        comboField.set(controller, comboBox);

        TitledPane mockTpModel = new TitledPane();
        Field tpModelField = Controller.class.getDeclaredField("tpModel");
        tpModelField.setAccessible(true);
        tpModelField.set(controller, mockTpModel);

        Method method = Controller.class.getDeclaredMethod("comboBoxProperties");
        method.setAccessible(true);
        method.invoke(controller);

        TreeView<String> treeView = new TreeView<>();
        Field treeViewField = Controller.class.getDeclaredField("modelTreeView");
        treeViewField.setAccessible(true);
        treeViewField.set(controller, treeView);

        comboBox.getSelectionModel().select(1);
        comboBox.getOnAction().handle(new ActionEvent());

        assertEquals(2, comboBox.getItems().size());
        assertEquals(1, comboBox.getItems().get(0).getId());
        assertEquals("Line A", comboBox.getItems().get(0).getName());
        assertEquals(2, comboBox.getItems().get(1).getId());
        assertEquals("Line B", comboBox.getItems().get(1).getName());

        verify(linesService).getLines();
    }

    @Test
    public void testTreeViewStructure() throws Exception{
        Long id = 1L;
        ProductLinesDTO mockLine = new ProductLinesDTO(1L, "Line A");

        List<ProductCategoriesDTO> mockCategories = Arrays.asList(
                new ProductCategoriesDTO(1L, "Category A"),
                new ProductCategoriesDTO(2L, "Category B")
        );

        when(categoryService.getCategories(id)).thenReturn(mockCategories);

        List<ProductModelsDTO> mockModels = Arrays.asList(
                new ProductModelsDTO(1L, "Model A"),
                new ProductModelsDTO(2L, "Model B")
        );

        when(modelService.getModels(id)).thenReturn(mockModels);

        TreeView<String> treeView = new TreeView<>();
        Field treeViewField = Controller.class.getDeclaredField("modelTreeView");
        treeViewField.setAccessible(true);
        treeViewField.set(controller, treeView);

        Method method = Controller.class.getDeclaredMethod("treeViewStructure", ProductLinesDTO.class);
        method.setAccessible(true);
        method.invoke(controller, mockLine);

        TreeItem<String> root = treeView.getRoot();
        assertNotNull(root);
        assertEquals(2, root.getChildren().size());

        TreeItem<String> categoryItem = root.getChildren().get(0);
        TreeItem<String> categoryItem1 = root.getChildren().get(1);
        assertEquals("Category A", categoryItem.getValue());
        assertEquals("Category B", categoryItem1.getValue());

        TreeItem<String> modelItem = categoryItem.getChildren().get(0);
        TreeItem<String> modelItem1 = categoryItem.getChildren().get(1);
        assertEquals("Model A", modelItem.getValue());
        assertEquals("Model B", modelItem1.getValue());

        verify(categoryService).getCategories(id);
        verify(modelService).getModels(id);
    }
}