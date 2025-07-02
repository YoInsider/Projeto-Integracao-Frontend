package com.example.projetointegracaofrontend.service;

import com.example.projetointegracaofrontend.dto.ProductCategoriesDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductCategoriesService {
    private String baseURL = "http://localhost:8080/api/categories";
    private RestTemplate restTemplate = new RestTemplate();

    public ProductCategoriesService(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.baseURL = url;
    }

    public ProductCategoriesService() {

    }

    public List<ProductCategoriesDTO> getCategories(Long id) {
        String url = baseURL + "/" + id;
        ResponseEntity<List<ProductCategoriesDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductCategoriesDTO>>() {}
        );
        return response.getBody();
    }
}
