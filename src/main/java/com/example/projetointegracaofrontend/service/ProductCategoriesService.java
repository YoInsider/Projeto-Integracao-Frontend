package com.example.projetointegracaofrontend.service;

import com.example.projetointegracaofrontend.model.ProductCategoriesDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductCategoriesService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<ProductCategoriesDTO> buscarPorLinha(Long id) {
        String url = "http://localhost:8080/api/categorias/"+id;

        ResponseEntity<List<ProductCategoriesDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductCategoriesDTO>>() {}
        );
        return response.getBody();
    }
}
