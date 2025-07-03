package com.example.projetointegracaofrontend.service;

import com.example.projetointegracaofrontend.dto.ProductModelsDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductModelsService {
    private String baseURL = "http://localhost:8080/api/models";
    private RestTemplate restTemplate = new RestTemplate();

    public ProductModelsService(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.baseURL = url;
    }

    public ProductModelsService() {

    }

    public List<ProductModelsDTO> getModels(Long id) {
        String url = baseURL + "/" + id;
        ResponseEntity<List<ProductModelsDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductModelsDTO>>() {}
        );
        return response.getBody();
    }
}
