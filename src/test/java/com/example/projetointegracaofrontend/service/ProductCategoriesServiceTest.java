package com.example.projetointegracaofrontend.service;

import com.example.projetointegracaofrontend.dto.ProductCategoriesDTO;
import com.example.projetointegracaofrontend.dto.ProductLinesDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductCategoriesServiceTest {
    @Mock
    private RestTemplate restTemplate = new RestTemplate();

    @InjectMocks
    private ProductCategoriesService productCategoriesService = new ProductCategoriesService(restTemplate);

    @Test
    public void testGetCategories() {
        String baseURL = "http://localhost:8080/api/categories";
        Long id = 1L;
        String url = baseURL + "/" + id;

        List<ProductCategoriesDTO> mockCategories = Arrays.asList(
                new ProductCategoriesDTO(1L, "Category A"),
                new ProductCategoriesDTO(2L, "Category B")
        );

        ResponseEntity<List<ProductCategoriesDTO>> mockResponse = new ResponseEntity<>(mockCategories, HttpStatus.OK);

        when(restTemplate.exchange(
                eq(url),
                eq(HttpMethod.GET),
                isNull(),
                ArgumentMatchers.<ParameterizedTypeReference<List<ProductCategoriesDTO>>>any()
        )).thenReturn(mockResponse);

        List<ProductCategoriesDTO> result = productCategoriesService.getCategories(id);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("Category A", result.get(0).getName());
        assertEquals(2, result.get(1).getId());
        assertEquals("Category B", result.get(1).getName());

        verify(restTemplate, times(1)).exchange(
                eq(url),
                eq(HttpMethod.GET),
                isNull(),
                ArgumentMatchers.<ParameterizedTypeReference<List<ProductCategoriesDTO>>>any()
        );
    }
}