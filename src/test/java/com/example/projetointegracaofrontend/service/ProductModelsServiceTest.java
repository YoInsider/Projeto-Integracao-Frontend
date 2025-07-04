package com.example.projetointegracaofrontend.service;

import com.example.projetointegracaofrontend.dto.ProductModelsDTO;
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
class ProductModelsServiceTest {
    @Mock
    private RestTemplate restTemplate = new RestTemplate();

    @InjectMocks
    private ProductModelsService productModelsService = new ProductModelsService(restTemplate, "http://localhost:8080/api/models");

    @Test
    void testGetModels() {
        Long id = 1L;
        String url = "http://localhost:8080/api/models/" + id;

        List<ProductModelsDTO> mockModels = Arrays.asList(
                new ProductModelsDTO(1L, "Model A"),
                new ProductModelsDTO(2L, "Model B")
        );

        ResponseEntity<List<ProductModelsDTO>> mockResponse = new ResponseEntity<>(mockModels, HttpStatus.OK);

        when(restTemplate.exchange(
                eq(url),
                eq(HttpMethod.GET),
                isNull(),
                ArgumentMatchers.<ParameterizedTypeReference<List<ProductModelsDTO>>>any()
        )).thenReturn(mockResponse);

        List<ProductModelsDTO> result = productModelsService.getModels(id);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("Model A", result.get(0).getName());
        assertEquals(2, result.get(1).getId());
        assertEquals("Model B", result.get(1).getName());

        verify(restTemplate, times(1)).exchange(
                eq(url),
                eq(HttpMethod.GET),
                isNull(),
                ArgumentMatchers.<ParameterizedTypeReference<List<ProductModelsDTO>>>any()
        );
    }
}