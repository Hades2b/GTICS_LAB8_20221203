package com.example.clienteweb.dao;

import com.example.clienteweb.entity.Product;
import com.example.clienteweb.dto.ProductDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductDao {

    public List<Product> listarProductos() {
        List<Product> lista = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "http://localhost:8080/product";

        ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(endPoint, Product[].class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            Product[] body = responseEntity.getBody();
            lista = Arrays.asList(body);
        }

        return lista;
    }

    public Product obtenerProducto(int id){
        Product product = null;

        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "http://localhost:8080/product/"+id;

        try {
            ResponseEntity<ProductDTO> forEntity = restTemplate.getForEntity(endPoint, ProductDTO.class);

            if(forEntity.getStatusCode().is2xxSuccessful()){
                ProductDTO productDto = forEntity.getBody();
                product = productDto.getProducto();
                return product;
            } else return null;

        } catch (HttpClientErrorException e) {
            System.err.println(e.getResponseBodyAsString());
            return null;
        }
    }



    public void guardar(Product product){

        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "http://localhost:8080/product";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Product> httpEntity = new HttpEntity<>(product,httpHeaders);

        if(product.getIdProduct() ==null){
            restTemplate.postForEntity(endPoint,httpEntity,Product.class);
        }else{
            restTemplate.put(endPoint,httpEntity,Product.class);
        }

    }

    public void deleteProductById(int id){

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete("http://localhost:8080/product?id="+id);
    }


}
