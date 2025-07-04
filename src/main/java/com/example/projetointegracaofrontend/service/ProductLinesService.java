package com.example.projetointegracaofrontend.service;

import com.example.projetointegracaofrontend.dto.ProductLinesDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductLinesService {
    private String baseURL = "http://localhost:8080/api/lines";
    private RestTemplate restTemplate = new RestTemplate();

    public ProductLinesService(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.baseURL = url;
    }

    public ProductLinesService() {

    }

    public List<ProductLinesDTO> getLines() {
        ResponseEntity<List<ProductLinesDTO>> response = restTemplate.exchange(
                baseURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductLinesDTO>>() {}
        );
        return response.getBody();
    }
}
