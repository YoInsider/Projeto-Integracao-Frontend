package com.example.projetointegracaofrontend.controller;

import com.example.projetointegracaofrontend.dto.ProductCategoriesDTO;
import com.example.projetointegracaofrontend.dto.ProductLinesDTO;
import com.example.projetointegracaofrontend.dto.ProductModelsDTO;
import com.example.projetointegracaofrontend.service.ProductCategoriesService;
import com.example.projetointegracaofrontend.service.ProductLinesService;
import com.example.projetointegracaofrontend.service.ProductModelsService;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit.ApplicationTest;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTest extends ApplicationTest {
    private Controller controller;

    @Before
    public void setUp() {
        controller = spy(Controller.class);
        controller.comboBoxLines = new ComboBox<>();
        controller.tpModel = new TitledPane();
        controller.modelTreeView = new TreeView<>();
        controller.linesService = mock(ProductLinesService.class);
        controller.categoryService = mock(ProductCategoriesService.class);
        controller.modelService = mock(ProductModelsService.class);
    }

    @Test
    public void testInitialize() throws Exception {
        doNothing().when(controller).comboBoxProperties();

        controller.initialize(null, null);

        verify(controller).comboBoxProperties();
    }

    @Test
    public void testComboBoxProperties() throws Exception {
        List<ProductLinesDTO> lines = Arrays.asList(
                new ProductLinesDTO(1L, "Line A"),
                new ProductLinesDTO(2L, "Line B")
        );

        when(controller.linesService.getLines()).thenReturn(lines);

        controller.comboBoxProperties();

        controller.comboBoxLines.getSelectionModel().select(1);
        controller.comboBoxLines.getOnAction().handle(new ActionEvent());
        ProductLinesDTO selected = controller.comboBoxLines.getSelectionModel().getSelectedItem();

        assertEquals("",2, controller.comboBoxLines.getItems().size());
        assertEquals("", 1L, controller.comboBoxLines.getItems().get(0).getId());
        assertEquals("Line A", controller.comboBoxLines.getItems().get(0).getName());
        assertEquals("", 2L, controller.comboBoxLines.getItems().get(1).getId());
        assertEquals("Line B", controller.comboBoxLines.getItems().get(1).getName());

        doNothing().when(controller).treeViewStructure(selected);

        verify(controller.linesService).getLines();
        verify(controller).treeViewStructure(selected);
    }

    @Test
    public void testTreeViewStructure() throws Exception{
        Long id = 1L;
        ProductLinesDTO mockLine = new ProductLinesDTO(1L, "Line A");

        List<ProductCategoriesDTO> mockCategories = Arrays.asList(
                new ProductCategoriesDTO(1L, "Category A"),
                new ProductCategoriesDTO(2L, "Category B")
        );

        when(controller.categoryService.getCategories(id)).thenReturn(mockCategories);

        List<ProductModelsDTO> mockModels = Arrays.asList(
                new ProductModelsDTO(1L, "Model A"),
                new ProductModelsDTO(2L, "Model B")
        );

        when(controller.modelService.getModels(id)).thenReturn(mockModels);

        controller.treeViewStructure(mockLine);

        TreeItem<String> root = controller.modelTreeView.getRoot();
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

        verify(controller.categoryService).getCategories(id);
        verify(controller.modelService).getModels(id);
    }
}