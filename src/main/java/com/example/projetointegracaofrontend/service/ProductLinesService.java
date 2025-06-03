package com.example.projetointegracaofrontend.service;

import com.example.projetointegracaofrontend.model.ProductLinesDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductLinesService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<ProductLinesDTO> buscarLinha() {
        String url = "http://localhost:8080/api/linhas";

        ResponseEntity<List<ProductLinesDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductLinesDTO>>() {}
        );
        return response.getBody();
    }
}
